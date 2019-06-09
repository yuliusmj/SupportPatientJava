package patientsupport.patientsupport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import patientsupport.patientsupport.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}