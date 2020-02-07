package com.timi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    @GetMapping("userlist")
    public List<Map<String,Object>> userList(){
        String sql="select * from user.student";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    //添加用户
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into user.student(id,name,pwd) values(11,'小明','123')";
        jdbcTemplate.update(sql);
        return "addUser_ok!";
    }

    //修改用户
    @GetMapping("/updataUser/{id]")
    public String updataUser(@PathVariable("id") int id){
        String sql = "update user.student set name=?,pwd=? where id="+id;
        Object[] objects = new Object[2];
        objects[0]="小明2";
        objects[1]="zzzzzz";
        jdbcTemplate.update(sql,objects);
        return "update_ok!";
    }

    //删除用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from user.student where id =?";
        jdbcTemplate.update(sql,id);
        return "delete_ok!";
    }
}
