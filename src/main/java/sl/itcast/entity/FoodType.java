package sl.itcast.entity;

/**
 * 1. 菜系模块，实体类设计
 *
 * @author Jie.Yuan
 *
 */
public class FoodType {

    private String id;
    private String typeName;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}