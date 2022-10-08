package com.example.demomybatisplus.controller;

import com.example.demomybatisplus.common.JsonResult;
import com.example.demomybatisplus.dto.StudentDto;
import com.example.demomybatisplus.po.Student;
import com.example.demomybatisplus.po.UserInfo;
import com.example.demomybatisplus.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")   // 解决开发阶段的跨域处理
@RestController
public class JsonController {

    @Autowired
    private StudentService studentService;

    // localhost:9015/getUserJson/10
    // 得到的结果： {"data":{"id":15,"name":"张三5","gender":"女"},"code":"0","msg":"操作成功"}
    @GetMapping("/getUserJson/{id}")
    public JsonResult<StudentDto> getUserJson(@PathVariable("id") int id) {

        // 从数据库拿到 po 数据
        Student student = studentService.getStudentById(id);

        // 将po数据转换成dto数据
        StudentDto dto = new StudentDto();
        dto.id = student.getId();
        dto.name = student.getName();
        dto.gender = student.getGender();

        // 将dto数据传送给前端
        return new JsonResult<>(dto);
    }

    // localhost:9015/oneStudent/15
    // 得到的结果： {"data":{"id":10,"name":"张三4","gender":"男"},"code":"0","msg":"操作成功"}
    @GetMapping("/oneStudent/{id}")
    public JsonResult<Student> getOneStudent(@PathVariable("id") int id) {

        Student student = studentService.getOneById(id);

        return new JsonResult<>(student);
    }


    // localhost:9015/allStudents
    // 得到的结果： {"data":[{"id":1,"name":"张三1","gender":"男"},{"id":2,"name":"李四2","gender":"男"},{"id":3,"name":"张三3","gender":"男"},{"id":10,"name":"张三4","gender":"男"},{"id":15,"name":"张三5","gender":"女"},{"id":16,"name":"20","gender":"女"},{"id":17,"name":"17","gender":"女"},{"id":18,"name":"18","gender":"女"},{"id":19,"name":"19","gender":"女"},{"id":20,"name":"20","gender":"女"}],"code":"0","msg":"操作成功"}
    @GetMapping("/allStudents")
    public JsonResult<List> getAllStudents() {

        List<Student> student = studentService.getAllStudent();

        return new JsonResult<>(student);
    }

    // localhost:9015/studentList
    // 得到的结果： {"data":[{"id":10,"name":"张三4","gender":"男"},{"id":15,"name":"张三5","gender":"女"},{"id":16,"name":"20","gender":"女"}],"code":"0","msg":"操作成功"}
    @GetMapping("/studentList")
    public JsonResult<List> getStudentList() {

        List<Student> student = studentService.getStudentList();

        return new JsonResult<>(student);
    }

    // localhost:9015/studentList2
    // 得到的结果： {"data":[{"id":10,"name":"张三4","gender":"男"},{"id":15,"name":"张三5","gender":"女"},{"id":16,"name":"20","gender":"女"}],"code":"0","msg":"操作成功"}
    @GetMapping("/studentList2")
    public JsonResult<List> getStudentList2() {

        List<Student> student = studentService.getStudentList2();

        return new JsonResult<>(student);
    }

    // localhost:9015/student
    // 参数：{
    //    "id":16,
    //    "name":"王武16",
    //    "gender":"女"
    //}
    // 下面情况，name字段不会被更新到数据库中
    //    {
    //        "id":17,
    //        "name":null,
    //        "gender":"女"
    //    }
    @PostMapping("/student")
    public int updateStudentById(@RequestBody Student student) {

        int result = studentService.updateStudentById(student);

        return result;
    }

    // localhost:9015/studentwrapper
    // 参数：{
    //    "id":17,
    //    "name":"王武17",
    //    "gender":"女"
    //}
    // 下面情况，name字段不会被更新到数据库中
    //    {
    //        "id":17,
    //        "name":null,
    //        "gender":"女"
    //    }
    @PostMapping("/studentwrapper")
    public int updateStudentByWrapper(@RequestBody Student student) {

        int result = studentService.updateStudentByWrapper(student);

        return result;
    }

    // localhost:9015/insert
    // 参数：{
    //    "name":"王武26",
    //    "gender":"女"
    //}
    @PostMapping("/insert")
    public int insert(@RequestBody Student student) {

        int result = studentService.insert(student);

        return result;
    }
}
