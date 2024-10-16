package org.jp.service;
import org.jp.dto.Resetrequest;


import org.jp.dto.UserDto;


import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto createUserDto(UserDto userDto);


    UserDto updateUserById(Long id, UserDto userDto);

    
    String login(UserDto dto);
    
    String passwordreset(Resetrequest resetrequest);
}
