package com.PrincessCyphers.Service;

import com.PrincessCyphers.repository.UserRepository;
import com.PrincessCyphers.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listAll(){
        return (List<User>) repository.findAll();
    }
    public void save(User user) {
        repository.save(user);
    }

}
