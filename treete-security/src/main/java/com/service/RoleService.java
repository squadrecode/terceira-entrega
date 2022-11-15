package com.service;

import com.dto.UserRoleDTO;
import com.entity.User;

public interface RoleService {

	User execute(UserRoleDTO userRoleDTO);
}
