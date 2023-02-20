package lesson20230220.junit;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User getUserById(int id) {
        // connect to db and get date
        return new User(100, "Test user", true);
    }

    @Override
    public void saveUser(User user) {
        // connect to db and save date
    }

    @Override
    public void deleteUser(int id) {
        // connect to db and delete date
    }
}
