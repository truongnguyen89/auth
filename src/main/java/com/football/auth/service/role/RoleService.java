package com.football.auth.service.role;

import com.football.common.model.auth.*;
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
public interface RoleService {
    Role createRole(Role role) throws Exception;

    Role findRoleById(long id) throws Exception;

    Role updateRole(long id, Role role) throws Exception;

    UserRole createUserRole(UserRole userRole) throws Exception;

    UserRole findUserRoleById(long id) throws Exception;

    UserRole updateUserRole(long id, UserRole userRole) throws Exception;

    UserGroupRole createUserGroupRole(UserGroupRole userGroupRole) throws Exception;

    UserGroupRole findUserGroupRoleById(long id) throws Exception;

    UserGroupRole updateUserGroupRole(long id, UserGroupRole userGroupRole) throws Exception;

    GroupRole createGroupRole(GroupRole groupRole) throws Exception;

    GroupRole findGroupRoleById(long id) throws Exception;

    GroupRole updateGroupRole(long id, GroupRole groupRole) throws Exception;

    GroupRoleMap createGroupRoleMap(GroupRoleMap groupRoleMap) throws Exception;

    GroupRoleMap findGroupRoleMapById(long id) throws Exception;

    GroupRoleMap updateGroupRoleMap(long id, GroupRoleMap groupRoleMap) throws Exception;

    List<Role> findRoleByStatus(int status) throws Exception;

    List<UserRole> findUserRoleByStatus(int status) throws Exception;

    List<UserGroupRole> findUserGroupRoleByStatus(int status) throws Exception;

    List<GroupRole> findGroupRoleByStatus(int status) throws Exception;

    List<GroupRoleMap> findGroupRoleMapByStatus(int status) throws Exception;

    Iterable<Role> findRoleAll() throws Exception;

    Iterable<UserRole> findUserRoleAll() throws Exception;

    Iterable<UserGroupRole> findUserGroupRoleAll() throws Exception;

    Iterable<GroupRole> findGroupRoleAll() throws Exception;

    Iterable<GroupRoleMap> findGroupRoleMapAll() throws Exception;
}
