package patientsupport.patientsupport.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import patientsupport.patientsupport.helpers.MessagesUtil;
import patientsupport.patientsupport.models.parameters.Country;
import patientsupport.patientsupport.repository.CountryRepository;

@Controller
@RequestMapping("countries")
public class CountriesController {

    private String pathView = "admin/countries";
    private final CountryRepository countryRepository;

    @Autowired
    public CountriesController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    // Index
    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView view = new ModelAndView();
        view.addObject("Countries",countryRepository.findAll());
        view.setViewName(pathView + "/index");

        return view;
    }

    // Create
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView create(Country country) {
        ModelAndView view = new ModelAndView();
        view.setViewName(pathView + "/create");

        return view;
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ModelAndView store(@Valid Country country, BindingResult result, Model model) {
        ModelAndView view = new ModelAndView();
        
        if (result.hasErrors()) {
            view.setViewName(pathView + "/create");
            return view;
        }

        try {
			country.setCreatedBy("widres");
            countryRepository.save(country);
            view.setViewName("redirect:/countries");
            return view;
		} catch (DataAccessException ex) {
            if(ex.getClass().getSimpleName().equals("DataIntegrityViolationException")) {
                model.addAttribute("error", MessagesUtil.dataIntegrityViolationException);
            } else {
                model.addAttribute("error",ex.getMessage());
            }
            view.setViewName(pathView + "/create");
            return view;
		}
    }


    // Edit
    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id, Model model) {
        ModelAndView view = new ModelAndView();

        Country itemToEdit = findById(id);

        model.addAttribute("country", itemToEdit);
        view.setViewName(pathView + "/edit");
        return view;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    public ModelAndView update(@PathVariable("id") Integer id, @Valid Country country, BindingResult result, Model model) {
        ModelAndView view = new ModelAndView();
        
        if (result.hasErrors()) {
            country.setId(id);
            view.setViewName(pathView + "/edit");
            return view;
        }

        try {
			country.setLastModifiedBy("widres");
            countryRepository.save(country);
            view.setViewName("redirect:/countries");
            return view;
		} catch (DataAccessException ex) {
            if(ex.getClass().getSimpleName().equals("DataIntegrityViolationException")) {
                model.addAttribute("error", MessagesUtil.dataIntegrityViolationException);
            } else {
                model.addAttribute("error",ex.getMessage());
            }
            view.setViewName(pathView + "/edit");
            return view;
		}
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody String delete(@PathVariable("id") Integer id, Model model) {
        try {
            Country itemToDelete = findById(id);
            countryRepository.delete(itemToDelete);
            return "{\"Status\":\"200\",\"Message\":\"Registro eliminado correctamente\"}";
        } catch (Exception e) {
            return "{\"Status\":\"400\",\"Error\":\"Error al eliminar el registro\"}";
        }
        
    }

    private Country findById(int id) {
        return countryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Country Id:" + id));
    }
}