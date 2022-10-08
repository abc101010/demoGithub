package com.example.demomybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.demomybatisplus.po.Student;
import com.example.demomybatisplus.mapper.StudentMapper;
import com.example.demomybatisplus.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    public Student getStudentById(int id){
        // 从dao层拿到 po 数据
        Student student = studentMapper.selectById(id);

        return student;
    }

    /**
     * 验证自定义方法传参数
     * @param id
     * @return
     */
    public Student getOneById(int id){
        Student student = studentMapper.getOneById(id);

        return student;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentMapper.getALL();

        return studentList;
    }

    public List<Student> getStudentList(){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("id", 3);
        queryWrapper.lt("id", 17);

        List<Student> studentList = studentMapper.selectList(queryWrapper);

        return studentList;
    }

    public List<Student> getStudentList2(){

        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.gt("id", 3);
        queryWrapper.lt("id", 17);
        queryWrapper.like("name", "%张三");

        List<Student> studentList = studentMapper.selectList(queryWrapper);

        return studentList;
    }


    /**
     * 更新学生信息
     * @param student
     * @return 0，更新失败；非0，更新成功；
     */
    public int updateStudentById(Student student){

        int result = studentMapper.updateById(student);

        return result;
    }

    public int updateStudentByWrapper(Student student){

        UpdateWrapper wrapper = new UpdateWrapper();
        // 需要更新的字段
        wrapper.set("name", student.getName());
        wrapper.set("gender", student.getGender());
        // 更新条件
        wrapper.eq("id", student.getId());

        int result = studentMapper.update(null, wrapper);

        return result;
    }

    /**
     * 插入一条新数据
     * @param student
     * @return 0，更新失败；1，更新成功；
     */
    public int insert(Student student){
        int result = studentMapper.insert(student);

        return result;
    }
}
