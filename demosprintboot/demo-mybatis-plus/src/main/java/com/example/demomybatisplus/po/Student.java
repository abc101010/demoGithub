package com.example.demomybatisplus.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

// 实体类，PO
@Data
@TableName("students")
public class Student implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    //@TableField("name")  如果属性名与数据库中的字段名不一致，可以通过TableField指定数据库中对应的字段名
    private String name;
    private String gender;
    private Date createTime;
    private Date updateTime;

    // 如果Java中用驼峰命名法，数据库对应的使用 'home_adress'
    // 如果在xml文件中，使用了'homeAdress'，一定要改成'home_adress'
    // private String homeAdress;
}
