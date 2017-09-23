package mode;

/**
 * @author shanglei
 * @date 2017/9/23.
 */
public class User {

    private Integer id;
    private String name;
    private Integer age;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age='" + age + '\'' +
            '}';
    }
}
