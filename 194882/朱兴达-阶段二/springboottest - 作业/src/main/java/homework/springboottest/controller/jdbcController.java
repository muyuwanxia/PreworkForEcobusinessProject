package homework.springboottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class jdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/getbook")
    public String bookname(){
        String sql="SELECT bname FROM books WHERE bid=1";
        String num=jdbcTemplate.queryForObject(sql,String.class);
        return num;
    }

    @GetMapping("/insertbook")
    public List<Map<String,Object>> insertbook(){
        String sql="INSERT INTO books VALUES('算法导论',6,'独墅湖图书馆',0)";
        int ins=jdbcTemplate.update(sql);
        String sql2="SELECT bname FROM books WHERE bid=6";
        List<Map<String,Object>> num=jdbcTemplate.queryForList(sql2);
        return num;
    }

    @GetMapping("/deletebook")
    public String deletebook(){
        String sql="DELETE FROM books WHERE bid=6";
        int del=jdbcTemplate.update(sql);
        return (del==1?"success":"fail");
    }

    @GetMapping("/ulterbook")
    public List<Map<String,Object>> ulterbook(){
        String sql="UPDATE books SET bborrowed=1 WHERE bid=6";
        int ult=jdbcTemplate.update(sql);
        String sql2="SELECT bname FROM books WHERE bid=6";
        List<Map<String,Object>> num=jdbcTemplate.queryForList(sql2);
        return num;
    }

}
