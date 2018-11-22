package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.demo.entity.Book;
import com.example.demo.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * @desc 保存书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param book 书籍对象
     */
    @Override
    public String save(Book book) {
        logger.info("*********************" + "save method start");
        Long id = new Long(IdWorker.getId());
        book.setId(id.toString());
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        mongoTemplate.save(book);
        return "成功保存对象";
    }

    /**
     * @desc 查询所有书籍对象列表
     * @author lushusheng
     * @date 2018-11-21
     * @return 书籍列表
     */
    @Override
    public List<Book> findAll() {
        logger.info("*********************" + "findAll method start");
        List<Book> bookList = mongoTemplate.findAll(Book.class);
        return bookList;
    }

    /**
     * @desc 根据id查询书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param id 书籍对象id
     * @return 书籍对象
     */
    @Override
    public Book getById(String id) {
        logger.info("*********************" + "getById method start");
        Query query = new Query(Criteria.where("id").is(id));
        Book book = mongoTemplate.findOne(query, Book.class);
        return book;
    }

    /**
     * @desc 根据name名称查询书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param name 书籍对象名称
     * @return 书籍对象
     */
    @Override
    public Book getByName(String name) {
        logger.info("*********************" + "getByName method start");
        Query query = new Query(Criteria.where("name").is(name));
        Book book = mongoTemplate.findOne(query, Book.class);
        return book;
    }

    /**
     * @desc 更新书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param book 书籍对象
     * @return 更新成功标志
     */
    @Override
    public String update(Book book) {
        logger.info("*********************" + "update method start");
        Query query = new Query(Criteria.where("id").is(book.getId()));
        Update update = new Update().set("price", book.getPrice())
                .set("name", book.getName())
                .set("publish", book.getPublish())
                .set("updateTime", book.getUpdateTime());
        mongoTemplate.updateFirst(query, update, Book.class);
        return "成功更新对象";
    }

    /**
     * @desc 删除书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param book 书籍对象
     * @return 删除成功标志
     */
    @Override
    public String delete(Book book) {
        logger.info("*********************" + "delete method start");
        //Query query = new Query(Criteria.where("id").is(book.getId()));
        mongoTemplate.remove(book);
        return "成功删除对象";
    }

    /**
     * @desc 根据id删除书籍对象
     * @author lushusheng
     * @date 2018-11-21
     * @param id 书籍对象id
     * @return 删除成功标志
     */
    @Override
    public String delete(String id) {
        logger.info("*********************" + "delete method start");
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Book.class);
        return "成功删除对象";
    }
}
