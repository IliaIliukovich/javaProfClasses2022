package lesson20221219.mocks;

public interface UserRepository {

    User getUserById(int id);

    void saveUser(User user);

}
