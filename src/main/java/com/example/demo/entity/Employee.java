package com.example.demo.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * @author lushusheng
 * @Date 2018-11-21
 * @Desc 当id设置为ObjectId类型和添加@Id注解时，
 * @Desc MongoDB数据库会自动生成主键，
 * @Desc 我们在保存对象时就不用设置id的值
 */
@Data
public class Employee {
    @Id
    private ObjectId id;
    private String name;
    private Integer age;
}
