package com.learning.repository;

import com.learning.user.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)            //test will be against real db
//@Rollback(false)                 // Keeps data committed to db
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    public void testAddNew() {
        final User user = new User();
        user.setEmail("newuser@example.com");
        user.setPassword("1234");
        user.setFirstName("New");
        user.setLastName("User");

        final User savedUser = repository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
}
