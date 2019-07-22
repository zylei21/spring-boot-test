package com.cibei.springbootapidoc.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 13:22
 * 测试ApiDoc
 * 先安装node.js
 * 然后安装ApiDoc
 *
 */

@RestController
@RequestMapping("/books")
public class BookController {

    Map<String,String> books=new HashMap<>();

    /**
     * @api {post} /save  保存图书信息
     * @apiName saveBook
     * @apiGroup books
     *
     * @apiParam {String} name book key.
     * @apiParam {String} author book value.
     * @apiSuccess {Map} books map of the book.
     *
     *
     * @apiSuccessExample Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *       "三国演义": "罗贯中",
     *     }
     *
     * @apiError NameAlreadyExists The key of book already exits.
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found
     *     {
     *       "error": "NameAlreadyExists"
     *     }
     */
    @PostMapping("")
    public Map save(@RequestParam("name")String name, @RequestParam("author")String author){
        books.put(name,author);
        return books;
    }
    /**
     * @api {GET} /books/{name} 获取图书信息
     * @apiGroup books
     * @apiVersion 0.0.1
     * @apiDescription 获取图书信息
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 0 代表无错误 1代表有错误
     * @apiSuccess (200) {String} name 书名
     * @apiSuccess (200) {String} author 作者名字
     * @apiSuccessExample {json} 返回样例:
     * {
     *   "code": 0,
     *   "msg": "",
     *   "三国演义":"罗贯中"
     * }
     */
    @GetMapping("/{name}")
    public String queryBook(@PathVariable("name")String name){
        return name+":"+books.get(name);
    }

    @PutMapping("/{name}")
    public Map updateBook(@PathVariable("name")String name,@RequestParam("author")String author){
        books.replace(name,author);
        return books;
    }
    @DeleteMapping("/{name}")
    public Map deleteBook(@PathVariable("name")String name){
        books.remove(name);
        return books;
    }
}
