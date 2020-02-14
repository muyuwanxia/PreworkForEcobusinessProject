package com.timi;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.timi.test.MPDemoApplication;
import com.timi.test.entity.User;
import com.timi.test.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MPDemoApplication.class)
class MybatisplusDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //测试条件构造器

    /**
     * 查询name为弥豆子的记录
     */
    @Test
    public void selectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "弥豆子");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

     //根据 Wrapper 条件，查询全部记录
    @Test
    public void selectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

    //根据 whereEntity 条件，更新记录
    @Test
    public void update() {
        User user = new User();
        user.setName("炭治郎");
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("name", "王大锤");
        int update = userMapper.update(user, userUpdateWrapper);
        System.out.println(update);
    }

    //分页测试
    @Test
    public void testSelectPage(){
        //构建分页条件第二页每页显示2条
        Page<User> page=new Page<>(2,2);
        //使用分页条件查询，不使用其他条件
        userMapper.selectPage(page, null);
        //获取分页后查询出的记录
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println("是否有下一页："+page.hasNext());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("总记录数："+page.getTotal());
    }
}
