package com.seu.springboot.controller;

import com.seu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("/list")
    public List<User> userList(){
        String sql = "select * from user";
        List<User> users = jdbcTemplate.query(sql,new UserRowMapper());
        return users;
    }

    @ResponseBody
    @RequestMapping("/add")
    public List<User> addUser(){
        String sql = "insert into user(id,name,age,money) values(?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{12345,"张飞",45,789456});
        return this.userList();
    }

    @ResponseBody
    @RequestMapping("/edit/{id}")
    public List<User> editUser(@PathVariable("id") int id){
        String sql = "update user set name=?,age=?,money=? where id="+id;
        jdbcTemplate.update(sql,new Object[]{"张三",25,456.12});
        return this.userList();
    }

    @ResponseBody
    @RequestMapping("/delete/{id}")
    public List<User> deleteUser(@PathVariable("id") int id){
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,id);
        return this.userList();
    }

    private class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user=new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setMoney(resultSet.getDouble("money"));
            return user;
        }
    }
}
