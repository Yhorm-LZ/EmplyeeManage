package com.yhorm.controller;

import com.yhorm.mapper.DepartmentMapper;
import com.yhorm.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentMapper departmentMapper;

    @GetMapping("/queryDepartmentById/{id}")
    public void queryDepartmentById(@PathVariable("id")Integer id, Model model){
        Department department=departmentMapper.queryDepartmentById(id);
        model.addAttribute("departments",department);
        return;
    }

    @GetMapping("/queryDepartmentList")
    public List<Department> queryDepartmentList(){
        List<Department> departmentList=departmentMapper.queryDepartmentList();
        return departmentList;
    }
}
