// interface for the user

package com.PrincessCyphers.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
