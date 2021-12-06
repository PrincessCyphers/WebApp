package com.PrincessCyphers.repository;

import com.PrincessCyphers.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    public long countById(Integer id);                  // custom method using conventional syntax. IDE auto recognises.
}
