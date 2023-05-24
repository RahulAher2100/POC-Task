package com.microservice.department.controller;


import com.microservice.department.entity.Department;
import com.microservice.department.entity.DepartmentUser;
import com.microservice.department.entity.User;
import com.microservice.department.externalservice.UserFeignService;
import com.microservice.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserFeignService userFeignService;


    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){

        log.info("Inside addDepartment method of DepartmentController:{}", department);


        Department depart=this.departmentService.add(department);

        return new ResponseEntity<Department>(depart, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<DepartmentUser>getDepartments(@PathVariable("id") Long id){

        log.info("Inside addDepartment method of DepartmentController:{}", id);


        DepartmentUser getDepartment= this.departmentService.getDepartment(id);

            return new ResponseEntity<DepartmentUser>(getDepartment, HttpStatus.OK);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserUsingDepartment(@PathVariable("userId") Long userId){

        ResponseEntity<User> user=this.userFeignService.getUser(userId);

        return new ResponseEntity<User>(user.getBody(),HttpStatus.OK);

    }
}
