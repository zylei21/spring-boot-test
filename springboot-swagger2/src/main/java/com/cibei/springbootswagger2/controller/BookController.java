package com.cibei.springbootswagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author lsf
 * @date 2019/07/02 13:22
 */

@RestController
@Api("图书信息")
@RequestMapping("/books")
public class BookController {

    Map<String,String> books=new HashMap<>();

    @ApiOperation("添加图书")
    @PostMapping("")
    public Map save(@RequestParam("name")String name,@RequestParam("author")String author){
        books.put(name,author);
        return books;
    }

    @ApiOperation("查找图书")
    @GetMapping("/{name}")
    public String queryBook(@PathVariable("name")String name){
        return name+":"+books.get(name);
    }

    @ApiOperation("修改作者")
    @PutMapping("/{name}")
    public Map updateBook(@PathVariable("name")String name,@RequestParam("author")String author){
        books.replace(name,author);
        return books;
    }
    @ApiOperation("删除图书")
    @DeleteMapping("/{name}")
    public Map deleteBook(@PathVariable("name")String name){
        books.remove(name);
        return books;
    }
}
