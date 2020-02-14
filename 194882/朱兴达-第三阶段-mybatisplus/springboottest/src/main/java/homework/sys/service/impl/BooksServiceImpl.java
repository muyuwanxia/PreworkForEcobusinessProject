package homework.sys.service.impl;

import homework.sys.entity.Books;
import homework.sys.mapper.BooksMapper;
import homework.sys.service.IBooksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhu
 * @since 2020-02-14
 */
@Service
public class BooksServiceImpl extends ServiceImpl<BooksMapper, Books> implements IBooksService {

}
