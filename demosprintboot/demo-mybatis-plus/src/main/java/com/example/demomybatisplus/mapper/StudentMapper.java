package com.example.demomybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demomybatisplus.po.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     // 忽略警告
public interface StudentMapper extends BaseMapper<Student> {

    public List<Student> getALL();

    public Student getOneById(int id);

}
