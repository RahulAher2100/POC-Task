package com.microservice.department.service;

import com.microservice.department.entity.Department;
import com.microservice.department.entity.DepartmentUser;
import com.microservice.department.entity.User;
import com.microservice.department.externalservice.UserFeignService;
import com.microservice.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceIMPL implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    UserFeignService userFeignService;

    @Override
    public Department add(Department department) {

        log.info("Inside addDepartment DepartmentServiceIMPL: {}", department);

        return this.departmentRepository.save(department);
    }

    @Override
    public DepartmentUser getDepartment(long id) {

        log.info("Inside getDepartment DepartmentServiceIMPL: {}", id);

        DepartmentUser departmentUser = new DepartmentUser();

        Department department = departmentRepository.getById(id);

        ResponseEntity<User> user = this.userFeignService.getUser(department.getUserId());

        departmentUser.setDepartment(department);
        departmentUser.setUser(user.getBody());

        return departmentUser;

    }

}
