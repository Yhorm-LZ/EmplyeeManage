package com.yhorm.mapper;

import com.yhorm.pojo.Department;
import com.yhorm.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {
    List<Department> queryDepartmentList();
    Department queryDepartmentById(int id);

}
