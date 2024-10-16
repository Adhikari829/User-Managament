package org.jp.service;

import java.util.List;

import java.util.Optional;
import org.jp.dto.UserDtoReq;
import org.jp.dto.UserDtoRes;
import org.jp.entity.UserRole;
import org.jp.repository.RoleRepo;
import org.jp.translater.RoleTranslater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleServiceInterface {

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private RoleTranslater roleTranslater;

	//for role create and save
	public UserDtoReq saveRole(UserDtoReq userDtoReq) {

		UserRole userRole = roleTranslater.translateRole(userDtoReq);
		UserRole savedRole = roleRepo.save(userRole);
		return roleTranslater.translateRoleDto(savedRole);
	}

	
	//for fetching the list of all user including role
	public List<UserDtoRes> getDetails() {
		return roleTranslater.translateRoleDto(roleRepo.findAll());

	}

	
	//for update user role and save it in same id's
	public UserDtoRes updateRoleByid(Long id, UserDtoReq req) {

		Optional<UserRole> role = roleRepo.findById(id);
		if (role.isPresent()) {
			UserRole resp = role.get();

			UserRole user = roleTranslater.translateRole(req);
			user.setId(id);
			UserRole saverole = roleRepo.save(user);
			return roleTranslater.translateRoleToRes(saverole);
		}
		return null;
	}
}
