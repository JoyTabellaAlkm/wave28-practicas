package com.mercadolibre.jparelationships.controller;

import com.mercadolibre.jparelationships.entity.manyToMany.Course;
import com.mercadolibre.jparelationships.entity.manyToMany.Student;
import com.mercadolibre.jparelationships.entity.oneToMany.bidirectional.Cart;
import com.mercadolibre.jparelationships.entity.oneToMany.bidirectional.Item;
import com.mercadolibre.jparelationships.entity.oneToMany.unidirectional.Sale;
import com.mercadolibre.jparelationships.entity.oneToMany.unidirectional.SaleDetail;
import com.mercadolibre.jparelationships.entity.oneToOne.bidirectional.Employee;
import com.mercadolibre.jparelationships.entity.oneToOne.bidirectional.Profile;
import com.mercadolibre.jparelationships.entity.oneToOne.unidirectional.Address;
import com.mercadolibre.jparelationships.entity.oneToOne.unidirectional.User;
import com.mercadolibre.jparelationships.repository.*;
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
    private final ISaleDetailRepositorio saleDetailRepositorio;
    private final ISaleRepository saleRepository;
    private final IItemRepository itemRepository;
    private final ICartRepository cartRepository;
    private final IStudentRepository studentRepository;
    private final ICourseRepository courseRepository;

    public GlobalController(IAddressRepository addressRepository, IUserRepository userRepository, IProfileRepository profileRepository, IEmployeeRepository employeeRepository, ISaleDetailRepositorio saleDetailRepositorio, ISaleRepository saleRepository, IItemRepository itemRepository, ICartRepository cartRepository, IStudentRepository studentRepository, ICourseRepository courseRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
        this.profileRepository = profileRepository;
        this.employeeRepository = employeeRepository;
        this.saleDetailRepositorio = saleDetailRepositorio;
        this.saleRepository = saleRepository;
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
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

    @GetMapping("/sale-details")
    public ResponseEntity<List<SaleDetail>> getAllSaleDetails() {
        return ResponseEntity.ok(saleDetailRepositorio.findAll());
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> getAllSales() {
        return ResponseEntity.ok(saleRepository.findAll());
    }

    @GetMapping("/carts")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartRepository.findAll());
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemRepository.findAll());
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

}
