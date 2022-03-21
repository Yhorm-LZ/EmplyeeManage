package com.yhorm.pojo;

import com.yhorm.controller.DepartmentController;
import com.yhorm.mapper.DepartmentMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private int gender;//0女1男
    private int department;
    private String birth;


}
