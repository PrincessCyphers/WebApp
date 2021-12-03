package com.PrincessCyphers.repository;

import com.PrincessCyphers.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)            //test will be against real db
@Rollback(false)                 // Keeps data committed to db
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void testAddNew() {
        final User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("123abc");
        user.setFirstName("Test");
        user.setLastName("User");

        final User savedUser = repository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll() {
        Iterable<User> users = repository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        int userId = 1;
        Optional<User> optionalUser = repository.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hey2021");
        repository.save(user);

        User updatedUser = repository.findById(userId).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hey2021");
    }

    @Test
    public void testGet(){
        Integer userId = 2;
        Optional<User> optionalUser = repository.findById(userId);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());

    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        repository.deleteById(userId);
        Optional<User> optionalUser = repository.findById(userId);
        Assertions.assertThat(optionalUser).isNotPresent();
    }

}
