package com.seu.generator.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.seu.generator.mapper.UserMapper;
import com.seu.generator.model.User;
import com.seu.generator.service.impl.UserServiceImpl;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author test
 * @since 2020-02-14
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserServiceImpl userService;

    @Resource
    UserMapper userMapper;

    @GetMapping("/cha")
    public @ResponseBody Object selectOne(){
        return userService.getById(1094592041087729666L);
    }

    @GetMapping("/list")
    public String showList(Model model){

        List<User> userList=userService.list();
        model.addAttribute("LIST",userList);
        return "staff_list";
    }

    @RequestMapping("/pagelist/{pagenumber}")
    public String selectMyPage(Model model,@PathVariable Integer pagenumber) {

        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.ge("age",20);

        Page<User> page=new Page<User>(pagenumber,2);

        //IPage<User> iPage=userMapper.selectUserPage(page,queryWrapper);
        IPage<User> iPage=userMapper.selectPage(page,queryWrapper);
        System.out.println("总页数"+iPage.getPages());
        System.out.println("当前页数"+iPage.getCurrent());
        System.out.println("总记录数"+iPage.getTotal());
        List<User> userList=iPage.getRecords();
        model.addAttribute("LIST",userList);

        return "staff_list";
    }

    @RequestMapping("/del/{id}")
    public void del(Model model, @PathVariable String id, HttpServletResponse response) throws IOException {
        userService.removeById(id);
        response.sendRedirect("/user/list");
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable String id){
        User user=userService.getById(id);
        model.addAttribute("stf_toEdit",user);
        List<User> userList=userService.list();
        model.addAttribute("LIST",userList);
        return "staff_edit";
    }

    @PostMapping("/edit")
    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user=userService.getById(request.getParameter("id"));

        Long id=Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        Long managerId = Long.parseLong(request.getParameter("did"));

        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        user.setManagerId(managerId);

        userService.updateById(user);
        response.sendRedirect("./list");
    }

    @GetMapping("/toAdd")
    public String toAdd(Model model){
        List<User> userList=userService.list();
        model.addAttribute("LIST",userList);
        return "staff_add";
    }

    @PostMapping("/add")
    public void add(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user=new User();
        //Long id=Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Integer age = Integer.valueOf(request.getParameter("age"));
        String email = request.getParameter("email");
        Long managerId = Long.parseLong(request.getParameter("did"));

        //user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        user.setManagerId(managerId);

        userService.save(user);

        List<User> userList=userService.list();
        model.addAttribute("LIST",userList);
        response.sendRedirect("/demo/user/list");
    }

    @GetMapping("/query")
    public String query(Model model){
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.isNotNull("manager_id").between("age",20,35)
                .orderByDesc("age").orderByAsc("id");
        List<User> userList=userService.list(queryWrapper);
        model.addAttribute("LIST",userList);
        return "staff_list";
    }

}

