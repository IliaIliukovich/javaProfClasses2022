package lesson19122022.mocks;

public class User {

    private String name;
    private int id;
    private boolean isActive;

    public User(String name, int id, boolean isActive) {
        this.name = name;
        this.id = id;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
