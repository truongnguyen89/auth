package com.football.auth.service.user;

import com.football.common.model.user.User;
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
public interface UserService {
    User findById(long id) throws Exception;

    Iterable<User> findAll() throws Exception;

    List<User> findByStatus(int status) throws Exception;

}
