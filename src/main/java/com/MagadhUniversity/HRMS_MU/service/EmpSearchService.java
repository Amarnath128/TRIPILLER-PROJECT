package com.MagadhUniversity.HRMS_MU.service;

import org.springframework.stereotype.Service;

import com.MagadhUniversity.HRMS_MU.model.Employee;
import com.MagadhUniversity.HRMS_MU.repository.EmpSearchRepository;

import java.util.List;

@Service
public class EmpSearchService {

    private final EmpSearchRepository empSearchRepository;

    public EmpSearchService(EmpSearchRepository empSearchRepository) {
        this.empSearchRepository = empSearchRepository;
    }

    public List<Employee> searchEmployeesByName(String name) {
        return empSearchRepository.findByNameContainingIgnoreCase(name);
    }
}

/* 
package com.example.hrms.service;

import com.example.hrms.model.Employee;
import com.example.hrms.repository.EmpSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpSearchService {

    private final EmpSearchRepository empSearchRepository;

    public EmpSearchService(EmpSearchRepository empSearchRepository) {
        this.empSearchRepository = empSearchRepository;
    }

    public List<Employee> searchEmployeesByName(String name) {
        return empSearchRepository.findByNameContainingIgnoreCase(name);
    }
}
 */