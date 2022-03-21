package com.yhorm.controller;

import com.yhorm.mapper.DepartmentMapper;
import com.yhorm.mapper.EmployeeMapper;
import com.yhorm.pojo.Department;
import com.yhorm.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;

    @RequestMapping ("/emps")
    public String queryEmployeeList(Model model){
        List<Employee> employeeList=employeeMapper.queryEmployeeList();
        Collection<Department>departments=departmentMapper.queryDepartmentList();
        model.addAttribute("emps",employeeList);
        model.addAttribute("departments",departments);
        return "/emp/list";
    }

    @GetMapping("/emp")
    public  String toAddPage(Model model){
        Collection<Department> departments=departmentMapper.queryDepartmentList();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        System.out.println("save=>"+employee);
        employeeMapper.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdatePage(@PathVariable("id")Integer id,Model model){
        Employee employee=employeeMapper.queryEmployeeById(id);
        model.addAttribute("emp",employee);

        Collection<Department>departments=departmentMapper.queryDepartmentList();
        model.addAttribute("departments",departments);
        return "emp/update";

    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee){
        employeeMapper.updateEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id")int id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/emps";
    }


}
