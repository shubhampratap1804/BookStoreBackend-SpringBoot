package com.example.demo.services;

import java.util.List;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserData;


public interface IUserService {
	
	 List<UserData> getUserDetails();
	
    UserData addUser(UserDTO userDTO);

    void deleteUser(int id);
    
    UserData registerUser(UserDTO userDTO);
    
    public boolean checkIfUserExist(String email);

}
