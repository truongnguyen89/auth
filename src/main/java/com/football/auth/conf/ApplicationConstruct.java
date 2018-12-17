package com.football.auth.conf;

import com.football.auth.service.token.TokenService;
import com.football.auth.service.user.UserService;
import com.football.common.cache.Cache;
import com.football.common.constant.Constant;
import com.football.common.model.auth.Token;
import com.football.common.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 17-Dec-18 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ApplicationConstruct {
    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    @PostConstruct
    public void init() throws Exception {
        List<User> userList = userService.findByStatus(Constant.STATUS_OBJECT.ACTIVE);
        Cache.setUserCache(userList);
        List<Token> tokenList = tokenService.findByStatus(Constant.STATUS_OBJECT.ACTIVE);
        Cache.setTokenCache(tokenList);
    }

}
