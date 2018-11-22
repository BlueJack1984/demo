package com.example.demo.entity;


import lombok.Data;

import java.util.Date;

/**
 * @desc 图书实体类
 * @author lushusheng
 * @date 2018-11-21
 */

@Data
public class Book {
    private String id;
    private Integer price;
    private String name;
    private String publish;
    private Date createTime;
    private Date updateTime;
}
