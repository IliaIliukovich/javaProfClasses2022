package lesson20221219.mocks;

public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean isActive(int id){
        User user = repository.getUserById(id);
        return user.isActive();
    }

    public void deactivate(int id) {
        User user = repository.getUserById(id);
        user.setActive(false);
        repository.saveUser(user);
    }

}
