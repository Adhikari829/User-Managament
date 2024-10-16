package org.jp.service;

import org.jp.dto.Resetrequest;
import org.jp.dto.UserDto;




public interface UserService {
    UserDto createUserDto(UserDto userDto);
    
    String login(UserDto dto);
    
    String passwordreset(Resetrequest resetrequest);
}
