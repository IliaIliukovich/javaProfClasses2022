package lesson19122022.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void testIsActive() {
//        UserRepository repository = new UserRepositoryImpl();
        UserRepository repository = mock(UserRepository.class);
        UserService service = new UserService(repository);
        User user1 = new User("Test user 1", 10, false);
        User user2 = new User("Test user 2", 11, true);
        when(repository.getUserById(10)).thenReturn(user1);
        when(repository.getUserById(11)).thenReturn(user2);

        assertFalse(service.isActive(10));
        assertTrue(service.isActive(11));
//        assertTrue(service.isActive(12));
    }

    @Test
    void testDeactivate() {
        UserRepository repository = mock(UserRepository.class);
        UserService service = new UserService(repository);
        User user1 = new User("Test user 1", 10, false);
        User user2 = new User("Test user 2", 11, true);
        when(repository.getUserById(10)).thenReturn(user1);
        when(repository.getUserById(11)).thenReturn(user2);
        service.deactivate(10);
        service.deactivate(11);

        assertFalse(user1.isActive());
        assertFalse(user2.isActive());
        verify(repository, times(2)).saveUser(any());
        verify(repository).saveUser(user1);
        verify(repository).saveUser(user2);
    }
}