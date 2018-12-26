package com.football.auth.service.role;

import com.football.common.model.auth.*;
import org.springframework.stereotype.Service;

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

    Role updateRole(long id, Role role) throws Exception;

    UserRole createUserRole(UserRole userRole) throws Exception;

    UserRole updateUserRole(long id, UserRole userRole) throws Exception;

    UserGroupRole createUserGroupRole(UserGroupRole userGroupRole) throws Exception;

    UserGroupRole updateUserGroupRole(long id, UserGroupRole userGroupRole) throws Exception;

    GroupRole createGroupRole(GroupRole groupRole) throws Exception;

    GroupRole updateGroupRole(long id, GroupRole groupRole) throws Exception;

    GroupRoleMap createGroupRoleMap(GroupRoleMap groupRoleMap) throws Exception;

    GroupRoleMap updateGroupRoleMap(long id, GroupRoleMap groupRoleMap) throws Exception;
}
