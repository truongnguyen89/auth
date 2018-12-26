package com.football.auth.repository;

import com.football.common.model.auth.GroupRoleMap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: truongnq
 * @date: 26-Dec-18 3:31 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface GroupRoleMapRepository extends CrudRepository<GroupRoleMap, Long> {
}
