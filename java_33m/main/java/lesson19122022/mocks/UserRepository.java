package lesson19122022.mocks;

public interface UserRepository {

    User getUserById(int id);

    void saveUser(User user);

}
