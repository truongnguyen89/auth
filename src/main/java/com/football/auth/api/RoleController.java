package com.football.auth.api;

import com.football.auth.service.role.RoleService;
import com.football.common.constant.Constant;
import com.football.common.model.auth.Role;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 26-Dec-18 4:03 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "role")
public class RoleController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    RoleService roleService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @Valid @RequestBody Role role) throws Exception {
        return new ResponseEntity<Role>(roleService.createRole(role), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable long id,
                                    @Valid @RequestBody Role role) throws Exception {
        return new ResponseEntity<Role>(roleService.updateRole(id, role), HttpStatus.OK);
    }

//    @RequestMapping(path = "/{id}", method = GET)
//    public ResponseEntity<?> findById(
//            @PathVariable long id) throws Exception {
//        return new ResponseEntity<Role>(roleService.findById(id), HttpStatus.OK);
//    }
//
//    @RequestMapping(path = "/status/{status}", method = GET)
//    public ResponseEntity<?> findByStatus(@PathVariable int status) throws Exception {
//        return new ResponseEntity<List<Role>>(roleService.findByStatus(status), HttpStatus.OK);
//    }
//
//    @RequestMapping(method = GET)
//    public ResponseEntity<?> findAll() throws Exception {
//        return new ResponseEntity<Iterable<Role>>(roleService.findAll(), HttpStatus.OK);
//    }

}
