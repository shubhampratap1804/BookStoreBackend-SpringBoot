package com.example.demo.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.BookCustomException;
import com.example.demo.model.UserData;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<UserData> getUserDetails() {
		return userRepository.findAll();
	}

	@Override
	public UserData addUser(UserDTO userDTO) {
		UserData userData = null;
		userData = new UserData(userDTO);
		return userRepository.save(userData);
	}

	@Override
	public void deleteUser(int id) {
		UserData userData = this.getUserById(id);
		userRepository.delete(userData);
	}

	public UserData getUserById(int id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new BookCustomException("USer with this id " + id + "doest not exists!"));
	}


	@Override
	public UserData registerUser(UserDTO userDTO) {
		if (checkIfUserExist(userDTO.getEmail())) {
			throw new BookCustomException("User already exists for this Id");
		}
		UserData userData = new UserData();
		BeanUtils.copyProperties(userDTO, userData);
		return userRepository.save(userData);
	}

	@Override
	public boolean checkIfUserExist(String email) {
		return userRepository.findByEmail(email)!= null ? true : false;
	}
}
