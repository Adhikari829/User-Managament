package org.jp.dto;

import org.jp.entity.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private Long phoneNo;
    private Long roleId;
    private Boolean status;
    private String userEmail;
    private String password;
    private UserRole userRole;
}
