package lesson20230220.junit;

import java.util.List;

public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean isActive(int id){
        User user = repository.getUserById(id);
        return user.isActive();
    }

    public void deactivate(int id){
        User user = repository.getUserById(id);
        user.setActive(false);
        repository.saveUser(user);
    }

    public void deleteInactive(List<User> users){
        // todo
    }

}
