package com.example.BAMS.service;

import com.example.BAMS.dto.UserDTO;
import com.example.BAMS.exception.UserNotFoundException;
import com.example.BAMS.model.User;
import com.example.BAMS.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
        private final UserRepository userRepository;
        private final ModelMapper modelMapper;

        @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper){

            this.userRepository= userRepository;
            this.modelMapper=modelMapper;
        }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with ID"+ id + "not found!"));
    }

    public UserDTO convertToDTO(User user) {
       return modelMapper.map(user,UserDTO.class);
    }

        public User createUser(UserDTO userDTO){
            User user =modelMapper.map(userDTO,User.class);
            return userRepository.save(user);
    }
    public List<User> getAllUsers(){
            return userRepository.findAll();
    }

    public User updateUser(Long id,User updatedUser){
            User existingUser = getUserById(id);
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
    }
    public void deleteUser(Long id){
            userRepository.deleteById(id);
    }
}
