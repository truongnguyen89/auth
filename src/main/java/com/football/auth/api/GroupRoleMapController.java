package com.football.auth.api;

import com.football.auth.service.role.RoleService;
import com.football.common.constant.Constant;
import com.football.common.model.auth.GroupRoleMap;
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
 * @date: 26-Dec-18 4:16 PM
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping(value = "groupRoleMap")
public class GroupRoleMapController {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CATEGORY);
    @Autowired
    RoleService roleService;

    @RequestMapping(method = POST)
    @ResponseBody
    public ResponseEntity<?> create(
            @Valid @RequestBody GroupRoleMap groupRoleMap) throws Exception {
        return new ResponseEntity<GroupRoleMap>(roleService.createGroupRoleMap(groupRoleMap), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    @ResponseBody
    public ResponseEntity<?> update(@PathVariable long id,
                                    @Valid @RequestBody GroupRoleMap groupRoleMap) throws Exception {
        return new ResponseEntity<GroupRoleMap>(roleService.updateGroupRoleMap(id, groupRoleMap), HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public ResponseEntity<?> findById(
            @PathVariable long id) throws Exception {
        return new ResponseEntity<GroupRoleMap>(roleService.findGroupRoleMapById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/status/{status}", method = GET)
    public ResponseEntity<?> findByStatus(@PathVariable int status) throws Exception {
        return new ResponseEntity<List<GroupRoleMap>>(roleService.findGroupRoleMapByStatus(status), HttpStatus.OK);
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAll() throws Exception {
        return new ResponseEntity<Iterable<GroupRoleMap>>(roleService.findGroupRoleMapAll(), HttpStatus.OK);
    }
}

