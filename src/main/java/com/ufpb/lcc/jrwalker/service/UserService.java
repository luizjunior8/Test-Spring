package com.ufpb.lcc.jrwalker.service;

import com.ufpb.lcc.jrwalker.model.User;
import com.ufpb.lcc.jrwalker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User create (User user) {
        return this.userRepository.save(user);
    }

    public User findOne (Integer id) {
        return this.userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    public User update (User user, Integer id) {
        User userTemporary = findOne(id);
        userTemporary.setName(user.getName() == null ? userTemporary.getName() : user.getName());
        userTemporary.setAge(user.getAge() == null ? userTemporary.getAge() : user.getAge());
        userTemporary.setEmail(user.getEmail() == null ? userTemporary.getEmail() : user.getEmail());
        return this.userRepository.save(userTemporary);
    }

    public void delete (Integer id) {
        this.userRepository.deleteById(id);
    }
}
