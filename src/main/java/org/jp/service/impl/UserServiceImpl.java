package org.jp.service.impl;

import java.util.Optional;

import org.jp.dto.Resetrequest;
import org.jp.dto.UserDto;
import org.jp.entity.UserEntity;
import org.jp.repository.UserRepo;
import org.jp.service.UserService;
import org.jp.translator.UserTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserTranslator userTranslator;


	
	@Override
	public UserDto createUserDto(UserDto userDto) {
		
		UserEntity saveEntity = userRepo.save(userTranslator.translateUserDtoToUserEntity(userDto));
		
		return userTranslator.translateUserEntityToUserDto(saveEntity);
	}
	
	public String login(UserDto dto) {
		return null;
	}
	
	
	
	//reset password
	public String passwordreset(Resetrequest reset) {
		Optional<UserEntity> user = userRepo.findByuserEmail(reset.getUserEmail());
		if(user.isPresent()) {
			UserEntity ur = user.get();
			if(!reset.getNewpassword().equals(reset.getConfirmpassword())) {
				return "password didn't match";
			}
			else {
				ur.setPassword(reset.getNewpassword());
				userRepo.save(ur);
				return"password reset sucessfully";
				
			}
		}
		else {
			return "user not found";
		}
	}
	
}
