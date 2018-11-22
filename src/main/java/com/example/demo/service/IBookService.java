package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;

/**
 * @desc 书籍服务接口
 * @author lushusheng
 * @date 2018-11-21
 */
public interface IBookService {
    /**
     * @desc 保存书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param book 书籍对象
     */
    String save(Book book);

    /**
     * @desc 查询所有书籍对象列表
     * @author lushusheng
     * @date 2018-11-21
     * @return 书籍列表
     */
    List<Book> findAll();

    /**
     * @desc 根据id查询书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param id 书籍对象id
     */
    Book getById(String id);

    /**
     * @desc 根据name名称查询书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param name 书籍对象名称
     */
    Book getByName(String name);

    /**
     * @desc 更新书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param book 书籍对象
     */
    String update(Book book);

    /**
     * @desc 删除书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param book 书籍对象
     */
    String delete(Book book);

    /**
     * @desc 根据id删除书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param id 书籍对象id
     */
    String delete(String id);
}
