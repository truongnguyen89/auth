package com.football.auth.service.role;

import com.football.common.repository.*;
import com.football.common.model.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 26-Dec-18 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    GroupRoleMapRepository groupRoleMapRepository;

    @Autowired
    GroupRoleRepository groupRoleRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Autowired
    UserGroupRoleRepository userGroupRoleRepository;

    @Override
    public Role createRole(Role role) throws Exception {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(long id, Role role) throws Exception {
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    public UserRole createUserRole(UserRole userRole) throws Exception {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole updateUserRole(long id, UserRole userRole) throws Exception {
        userRole.setId(id);
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserGroupRole createUserGroupRole(UserGroupRole userGroupRole) throws Exception {
        return userGroupRoleRepository.save(userGroupRole);
    }

    @Override
    public UserGroupRole updateUserGroupRole(long id, UserGroupRole userGroupRole) throws Exception {
        userGroupRole.setId(id);
        return userGroupRoleRepository.save(userGroupRole);
    }

    @Override
    public GroupRole createGroupRole(GroupRole groupRole) throws Exception {
        return groupRoleRepository.save(groupRole);
    }

    @Override
    public GroupRole updateGroupRole(long id, GroupRole groupRole) throws Exception {
        groupRole.setId(id);
        return groupRoleRepository.save(groupRole);
    }

    @Override
    public GroupRoleMap createGroupRoleMap(GroupRoleMap groupRoleMap) throws Exception {
        return groupRoleMapRepository.save(groupRoleMap);
    }

    @Override
    public GroupRoleMap updateGroupRoleMap(long id, GroupRoleMap groupRoleMap) throws Exception {
        groupRoleMap.setId(id);
        return groupRoleMapRepository.save(groupRoleMap);
    }

    @Override
    public Role findRoleById(long id) throws Exception {
        return roleRepository.findOne(id);
    }

    @Override
    public UserRole findUserRoleById(long id) throws Exception {
        return userRoleRepository.findOne(id);
    }

    @Override
    public UserGroupRole findUserGroupRoleById(long id) throws Exception {
        return userGroupRoleRepository.findOne(id);
    }

    @Override
    public GroupRole findGroupRoleById(long id) throws Exception {
        return groupRoleRepository.findOne(id);
    }

    @Override
    public GroupRoleMap findGroupRoleMapById(long id) throws Exception {
        return groupRoleMapRepository.findOne(id);
    }

    @Override
    public List<Role> findRoleByStatus(int status) throws Exception {
        return roleRepository.findByStatus(status);
    }

    @Override
    public List<UserRole> findUserRoleByStatus(int status) throws Exception {
        return userRoleRepository.findByStatus(status);
    }

    @Override
    public List<UserGroupRole> findUserGroupRoleByStatus(int status) throws Exception {
        return userGroupRoleRepository.findByStatus(status);
    }

    @Override
    public List<GroupRole> findGroupRoleByStatus(int status) throws Exception {
        return groupRoleRepository.findByStatus(status);
    }

    @Override
    public List<GroupRoleMap> findGroupRoleMapByStatus(int status) throws Exception {
        return groupRoleMapRepository.findByStatus(status);
    }

    @Override
    public Iterable<Role> findRoleAll() throws Exception {
        return roleRepository.findAll();
    }

    @Override
    public Iterable<UserRole> findUserRoleAll() throws Exception {
        return userRoleRepository.findAll();
    }

    @Override
    public Iterable<UserGroupRole> findUserGroupRoleAll() throws Exception {
        return userGroupRoleRepository.findAll();
    }

    @Override
    public Iterable<GroupRole> findGroupRoleAll() throws Exception {
        return groupRoleRepository.findAll();
    }

    @Override
    public Iterable<GroupRoleMap> findGroupRoleMapAll() throws Exception {
        return groupRoleMapRepository.findAll();
    }
}
