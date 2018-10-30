import lombok.extern.slf4j.Slf4j;
import pojo.GenericModel;

/**
 * @Auther: yule
 * @Date: 2018/10/30
 * @Description:
 */
@Slf4j
public abstract class GenericDao<E extends GenericModel, PK> {

    private GenericMapper<E> mapper;

    public GenericDao (GenericMapper<E> mapper) {
        this.mapper = mapper;
    }

    public int deleteByPrimaryKey(PK pk) {
        try {
            return mapper.deleteByPrimaryKey(pk);
        } catch (Exception e) {
            log.info("GenericDao-->deleteByPrimaryKey--->{}" , e.getMessage());
            throw new RuntimeException("根据主键删除失败");
        }
    }

    public int delete(E entity) {
        try {
            return mapper.delete(entity);
        } catch (Exception e) {
            log.info("GenericDao-->delete--->{}", e.getMessage());
            throw new RuntimeException("删除失败");
        }
    }

    public int insert(E entity) {
        try {
            setInsertDefault(entity);
            return mapper.insert(entity);
        } catch (Exception e) {
            log.info("GenericDao-->insert--->{}", e.getMessage());
            throw new RuntimeException("新增失败");
        }
    }

    protected void setInsertDefault(E entity) {
        entity.init();
        //TODO 获取当前用户
        entity.setInsertUser("123456");
    }

}
