package com.football.auth.api;

import com.football.auth.service.role.RoleService;
import com.football.common.constant.Constant;
import com.football.common.model.auth.UserRole;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 26-Dec-18 4:08 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "userRole")
public class UserRoleController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    RoleService roleService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @Valid @RequestBody UserRole userRole) throws Exception {
        return new ResponseEntity<UserRole>(roleService.createUserRole(userRole), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable long id,
                                    @Valid @RequestBody UserRole userRole) throws Exception {
        return new ResponseEntity<UserRole>(roleService.updateUserRole(id, userRole), HttpStatus.OK);
    }
}
