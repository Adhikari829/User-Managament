package org.jp.service.impl;

import java.util.Optional;

<<<<<<< HEAD
import org.jp.dto.Resetrequest;
=======
>>>>>>> f22f33fd60d5f8b47cb979d1dd007c2b4a62e450
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

	public UserDto createUserDto(UserDto userDto) {

		UserEntity saveEntity = userRepo.save(userTranslator.translateUserDtoToUserEntity(userDto));

		return userTranslator.translateUserEntityToUserDto(saveEntity);
	}

	// -------------------- UPDATE USER -------------------------------

	public UserDto updateUserById(Long id, UserDto userDto) {
		Optional<UserEntity> existingUserOptional = userRepo.findById(id);

		if (existingUserOptional.isPresent()) {
			UserEntity existingUser = existingUserOptional.get();

			existingUser.setFirstName(userDto.getFirstName());
			existingUser.setLastName(userDto.getLastName());
			existingUser.setPhoneNo(userDto.getPhoneNo());
			existingUser.setRoleId(userDto.getRoleId());
			existingUser.setStatus(userDto.getStatus());
			existingUser.setUserEmail(userDto.getUserEmail());

			UserEntity updatedEntity = userRepo.save(existingUser);

			return userTranslator.translateUserEntityToUserDto(updatedEntity);

		} else {
			throw new RuntimeException("User not found with id: " + id);
		}
	}

	

	
	public String login(UserDto req){
		Optional<UserEntity> user = userRepo.findByuserEmail(req.getUserEmail());
		if(user.isPresent()) {
			UserEntity ur = user.get();
			if(ur.getPassword().equals(req.getPassword())) {
				return "sucessfully login";
			}
			else {
				return "login not sucessfully";

			}
		}
		else {
			return "user not found";
    }
	}


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
