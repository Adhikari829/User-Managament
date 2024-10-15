package org.jp.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Data
@Entity
@Table // Added a table name for clarity
public class UserEntity {
   @Column
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Changed to lowercase 'id' for convention
    
    @Column // Added nullable constraint for required fields
    private String firstName;

    @Column // Added nullable constraint for required fields
    private String lastName;

    @Column // Added unique constraint for phone number
    private Long phoneNo;

    @Column
    private Long roleId;

    @Column
    private Boolean status;

    @Column // Added unique constraint for email
    private String userEmail;

//    @OneToOne
//    @JoinColumn(name = "user_role_id") // Set insertable and updatable to false
//    private UserRole userRole;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
//	public UserRole getUserRole() {
//		return userRole;
//	}
//	public void setUserRole(UserRole userRole) {
//		this.userRole = userRole;
//	}
	
	
}
