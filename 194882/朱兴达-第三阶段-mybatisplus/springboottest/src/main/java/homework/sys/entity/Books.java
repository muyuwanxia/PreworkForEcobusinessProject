package homework.sys.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhu
 * @since 2020-02-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Books{

    private static final long serialVersionUID = 1L;

    private String bname;

    private Integer bid;

    private String blocation;

    private Integer bborrowed;

    public Books(String bname, Integer bid, String blocation, Integer bborrowed) {
        this.bname = bname;
        this.bid = bid;
        this.blocation = blocation;
        this.bborrowed = bborrowed;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bname='" + bname + '\'' +
                ", bid=" + bid +
                ", blocation='" + blocation + '\'' +
                ", bborrowed=" + bborrowed +
                '}';
    }
}
