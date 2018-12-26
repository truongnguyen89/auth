package com.football.auth.service.role;

import com.football.auth.repository.*;
import com.football.common.model.auth.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
