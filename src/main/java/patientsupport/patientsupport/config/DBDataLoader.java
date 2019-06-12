package patientsupport.patientsupport.config;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import patientsupport.patientsupport.models.Role;
import patientsupport.patientsupport.models.User;
import patientsupport.patientsupport.repository.RoleRepository;
import patientsupport.patientsupport.repository.UserRepository;

@Component
public class DBDataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public DBDataLoader(UserRepository userRepository,
            RoleRepository roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void run(ApplicationArguments args) {

        if(userRepository.count() == 0) {
            User user = new User();
            user.setFirstName("Admin");
            user.setLastName("Admin");
            user.setEmail("admin@admin.com");
            user.setPhone("123456");
            user.setPassword("123456");
            user.setEnabled(true);
            user.setCreatedBy("Admin");
            user.setCreatedAt(new Date());

            saveUser(user, "ADMIN");

            User userE = new User();
            userE.setFirstName("Enfermero");
            userE.setLastName("Enfermero");
            userE.setEmail("enfermero@enfermero.com");
            userE.setPhone("123456");
            userE.setPassword("123456");
            userE.setEnabled(true);
            userE.setCreatedBy("Admin");
            userE.setCreatedAt(new Date());

            saveUser(userE, "ENFERMERO");
        }
    }

    public void saveUser(User user, String role) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        Role userRole = getRole(role);
        
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        userRepository.save(user);
    }

    private Role getRole(String role) {
        Role roleExits = roleRepository.findByDescription(role);

        if (roleExits != null) {
            return roleExits;
        } else {
            Role roleCreated = new Role();
            roleCreated.setActive(true);
            roleCreated.setCreatedBy("Admin");
            roleCreated.setDescription(role);
            roleRepository.save(roleCreated);

            return roleRepository.findByDescription(role);
        }

    }
}