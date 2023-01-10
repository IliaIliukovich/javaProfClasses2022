package lesson20221219.mocks;

public class UserRepositoryImpl implements UserRepository {

    @Override
    public User getUserById(int id) {
        // code to get user from db
        return new User("Some user from db", id, true);
    }

    @Override
    public void saveUser(User user) {
        // add or update user to db
    }

}
