package homework.sys.mapper;

import homework.sys.entity.Books;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhu
 * @since 2020-02-14
 */
@Mapper
public interface BooksMapper extends BaseMapper<Books> {

}
