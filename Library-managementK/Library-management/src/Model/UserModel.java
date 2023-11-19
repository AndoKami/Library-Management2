package Model;

public class UserModel {
    private String id;
    private String name;
    private String sex;

    public UserModel(String id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public UserModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}
