package org.jp.translator;

import org.jp.dto.UserDto;
import org.jp.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserTranslator {

	@Autowired
	private  ModelMapper modelMapper;
	
	public  UserDto translateUserEntityToUserDto(UserEntity userEntity) {
		return modelMapper.map(userEntity, UserDto.class);
		
	}
	
	public UserEntity translateUserDtoToUserEntity(UserDto userDto) {
		return modelMapper.map(userDto, UserEntity.class);
	}
}