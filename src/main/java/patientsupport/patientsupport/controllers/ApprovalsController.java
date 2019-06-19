package patientsupport.patientsupport.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import patientsupport.patientsupport.repository.ApprovalRepository;
import patientsupport.patientsupport.services.UserService;

/**
 * ApprovalsController
 */
@Controller
@RequestMapping("approvals")
public class ApprovalsController {

    private String pathView = "aprovals";
    private ApprovalRepository _repository;
    private UserService userService;

    @Autowired
    public ApprovalsController(
        ApprovalRepository _repository,
        UserService userService) {

            this._repository = _repository;
            this.userService = userService;
        
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView list() {

        ModelAndView view = new ModelAndView();
        view.addObject("Approvals", _repository.findAll());
        view.setViewName(pathView + "/index");
        return view;


    }
    
}