package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.DTO.UserDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "user_registration")
public class UserData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String email;
	private String userName;
	private String password;
	private String number;

	public UserData() {
	}

	public UserData(int id, String email, String userName, String password) {

		this.id = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}

	public UserData(UserDTO userDTO) {
		this.updateUser(userDTO);
	}

	public void updateUser(UserDTO userDTO) {
		this.email = userDTO.email;
		this.userName = userDTO.userName;
		this.number = userDTO.number;
		this.password = userDTO.password;
	}
}
