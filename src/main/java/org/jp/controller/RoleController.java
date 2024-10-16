package org.jp.controller;

import java.util.List;

import org.jp.dto.UserDtoReq;
import org.jp.dto.UserDtoRes;

import org.jp.service.RoleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rolePermission")
public class RoleController {

	@Autowired
	private RoleServiceInterface roleService;

	@PostMapping("/createRole")
	public ResponseEntity<UserDtoReq> saveRole(@RequestBody UserDtoReq userDtoReq) {
		return new ResponseEntity<UserDtoReq>(roleService.saveRole(userDtoReq), HttpStatus.OK);

	}

	@GetMapping("/list")
	public ResponseEntity<List<UserDtoRes>> getDetails() {
		List<UserDtoRes> userList = (List<UserDtoRes>) roleService.getDetails();
		if (userList != null) {
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping("updaterole/{id}")
	public ResponseEntity<UserDtoRes> updateRoleById(@PathVariable Long id, @RequestBody UserDtoReq userDtoReq) {
		UserDtoRes updatedRole = roleService.updateRoleByid(id, userDtoReq);

		if (updatedRole != null) {
			return new ResponseEntity<>(updatedRole, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
