package com.timi.test.controller;


import com.timi.test.entity.User;
import com.timi.test.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author timi
 * @since 2020-02-14
 */
@RestController
public class UserController {
    @Resource
    private UserService userService;

    //查询数据库的所有信息

    @GetMapping("/userList")
    public List<User> userList(){
        List<User> list_maps = userService.selectAll(null);
        return list_maps;
    }

    //添加用户
    @GetMapping("/addUser")
    public String addUser(){
        if(userService.insert(new User(4,"提米","M"))!=-1){
            return "addUser_ok!";
        }else
            return "addUser_fail";
    }

    //修改用户
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        User user = new User(id, "弥豆子", "FE");
        int i = userService.updateUser(user);
        if(i>0){
            return "update_ok！";
        }else {
            return "update_fail!";
        }

    }

    //删除用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        if(userService.deleteUserById(id)>0)
            return "delete_ok!";
        else
            return "delete_fail!";
    }


}

