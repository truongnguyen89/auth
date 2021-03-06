package com.football.auth.service.user;

import com.football.common.repository.UserRepository;
import com.football.common.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * UserRepository: Truong Nguyen
 * Date: 26-Nov-18
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public User findById(long id) throws Exception {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findByStatus(int status) throws Exception {
        return userRepository.findByStatus(status);
    }
}
