package com.football.auth.conf;

import com.football.auth.service.user.UserService;
import com.football.common.cache.Cache;
import com.football.common.constant.Constant;
import com.football.common.util.ArrayListCommon;
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
        try {
            //get user from cache
            List<com.football.common.model.user.User> userDbList = Cache.userList;
            if (ArrayListCommon.isNullOrEmpty(userDbList)) {
                System.out.println("Cache.userList is null");
                //get user from db
                userDbList = userService.findByStatus(Constant.STATUS_OBJECT.ACTIVE);
            }
            final List<com.football.common.model.user.User> userList = userDbList;
            for (com.football.common.model.user.User user : userList) {
                if (user.getUsername().equals(username)) {
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
            // If user not found. Throw this exception.
            throw new UsernameNotFoundException("Username: " + username + " not found");
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException("Exception " + e.getMessage());
        }
    }
}
