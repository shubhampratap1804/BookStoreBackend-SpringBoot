package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ResponseDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserData;
import com.example.demo.services.IUserService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping(value = "/getAllUser")
    public ResponseEntity<ResponseDTO> getUserDetails() {
    	List<UserData> userData = null;
        userData = iUserService.getUserDetails();
        ResponseDTO responseDTO = new ResponseDTO("Showing all user details!", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
    
    @PostMapping(value = "/addUser")
    public ResponseEntity<ResponseDTO> addUserDetails(@RequestBody UserDTO userDTO) {
    	UserData userData =null;
        userData = iUserService.addUser(userDTO);
        ResponseDTO responseDTO = new ResponseDTO("Added new user successfully!", userData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public ResponseEntity<ResponseDTO> deleteUserDetails(@RequestParam(name = "id") int id) {
        iUserService.deleteUser(id);
        ResponseDTO responseDTO = new ResponseDTO("User Details", "Deleted for id: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
