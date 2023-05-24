package com.microservice.department.service;

import com.microservice.department.entity.Department;
import com.microservice.department.entity.DepartmentUser;

import java.util.List;

public interface DepartmentService {
    Department add(Department department);

    DepartmentUser getDepartment(long id);
}
