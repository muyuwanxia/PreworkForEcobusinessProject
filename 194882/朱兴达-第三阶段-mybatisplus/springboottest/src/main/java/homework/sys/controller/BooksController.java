package homework.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import homework.sys.entity.Books;
import homework.sys.mapper.BooksMapper;
import homework.sys.service.IBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhu
 * @since 2020-02-14
 */

@RestController
public class BooksController{
    @Autowired
    IBooksService booksService;
    @Autowired
    BooksMapper mapper;

    @GetMapping("/insert")
    public void insertBook(){
        Books book=new Books("现代软件工程",6,"独墅湖图书馆",1);
        booksService.save(book);
    }

    @GetMapping("/search")
    public List<Map<String, Object>> searchBooks(){
        //条件构造器
        QueryWrapper<Books> querywrapper=new QueryWrapper<>();
        querywrapper
                .between("bid",2,5);
        List<Map<String, Object>> maps = mapper.selectMaps(querywrapper);
        return maps;
    }




}
