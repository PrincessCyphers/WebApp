// interface for the user

package com.PrincessCyphers.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.PrincessCyphers.user.User;

@Repository

public interface UserRepository extends CrudRepository<User, Integer> {
}
