package com.mercadolibre.jparelationships.controller;

import com.mercadolibre.jparelationships.entity.oneToOne.bidirectional.Employee;
import com.mercadolibre.jparelationships.entity.oneToOne.bidirectional.Profile;
import com.mercadolibre.jparelationships.entity.oneToOne.unidirectional.Address;
import com.mercadolibre.jparelationships.entity.oneToOne.unidirectional.User;
import com.mercadolibre.jparelationships.repository.IAddressRepository;
import com.mercadolibre.jparelationships.repository.IEmployeeRepository;
import com.mercadolibre.jparelationships.repository.IProfileRepository;
import com.mercadolibre.jparelationships.repository.IUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class GlobalController {
    private final IAddressRepository addressRepository;
    private final IUserRepository userRepository;
    private final IProfileRepository profileRepository;
    private final IEmployeeRepository employeeRepository;

    public GlobalController(IAddressRepository addressRepository, IUserRepository userRepository, IProfileRepository profileRepository, IEmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> addresses = addressRepository.findAll();
        System.out.println(addresses);
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok(profileRepository.findAll());
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
