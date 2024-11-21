package com.MagadhUniversity.HRMS_MU.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MagadhUniversity.HRMS_MU.model.Employee;
import com.MagadhUniversity.HRMS_MU.service.EmpSearchService;

import java.util.List;

@Controller
public class EmpSearchController {

    private final EmpSearchService empSearchService;

    public EmpSearchController(EmpSearchService empSearchService) {
        this.empSearchService = empSearchService;
    }

    @GetMapping("/empsearch")
    public String searchEmployees(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Employee> employees = empSearchService.searchEmployeesByName(name == null ? "" : name);
        model.addAttribute("employees", employees);
        return "Empsearch_review"; // Refers to the Empsearch_review.html page in the templates folder
    }
}





/* 

package com.example.hrms.controller;

import com.example.hrms.model.Employee;
import com.example.hrms.service.EmpSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EmpSearchController {

    private final EmpSearchService empSearchService;

    public EmpSearchController(EmpSearchService empSearchService) {
        this.empSearchService = empSearchService;
    }

    @GetMapping("/empsearch")
    public String searchEmployees(@RequestParam(name = "name", required = false) String name, Model model) {
        List<Employee> employees = empSearchService.searchEmployeesByName(name == null ? "" : name);
        model.addAttribute("employees", employees);
        return "Empsearch_review"; // Refers to the Empsearch_review.html page in the templates folder
    }
}
 */