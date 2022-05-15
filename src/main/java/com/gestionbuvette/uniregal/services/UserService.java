package com.gestionbuvette.uniregal.services;

import com.gestionbuvette.uniregal.models.User;
import com.gestionbuvette.uniregal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //Get All Users
    public List<User> findAll(){
        return userRepository.findAll();
    }
    //Save New User
    public void save(User user){
        userRepository.save(user);
    }
    //Get User by id
    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
    //Delete User
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
