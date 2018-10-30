package pojo;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 通用实体模型类
 *
 * <p>如果是与业务相关的实体模型请使用{@link }</p>
 *
 * <p>
 *     由于使用了泛型主键，在运行时id的类型将被擦除为{@link Object}，因此使用{@link }
 *     将实体类的值复制到dto对象时将无法正常复制id，解决方案有二：
 *     <ul>
 *         <li>在实际代码中手动赋值：{@code dto.setId(entity.getId())}</li>
 *         <li>将dto中的id类型更改为{@link Object}</li>
 *     </ul>
 * </p>
 *
 * @Auther: yule
 * @Date: 2018/10/30
 */
@Data
public abstract class GenericModel<PK> implements Serializable {
    @Id
    private PK id;

    private String insertUser;

    private Date insertTime;

    private String updateUser;

    private Date updateTime;

    public final void init() {
        Date currentDate = new Date();
        setId(generateId());
        setInsertTime(currentDate);
        setUpdateUser(null);
        setUpdateTime(null);
    }

    protected void setDefault(){

    }

    protected abstract PK generateId();
}
