package com.football.auth.conf;

import com.football.auth.service.user.UserService;
import com.football.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 05-Dec-18
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
@Service   // It has to be annotated with @Service.
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //get user from cache
        com.football.common.model.user.User user = com.football.common.cache.Cache.userMap.get(username);
        if (user == null)
            // If user not found. Throw this exception.
            throw new UsernameNotFoundException("Username: " + username + " not found");
        else {
            String role = "USER";
            if (user.getType() == Constant.USER.TYPE.ADMIN)
                role = "ADMIN";
            // Remember that Spring needs roles to be in this format: "ROLE_" + userRole (i.e. "ROLE_ADMIN")
            // So, we need to set it to that format, so we can verify and compare roles (i.e. hasRole("ADMIN")).
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList("ROLE_" + role);

            // The "User" class is provided by Spring and represents a model class for user to be returned by UserDetailsService
            // And used by auth manager to verify and check user authentication.
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
    }
}
