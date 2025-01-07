package com.example.BAMS.service;

import com.example.BAMS.dto.UserDTO;
import com.example.BAMS.model.User;
import com.example.BAMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
        private final UserRepository userRepository;

        @Autowired
    public UserService(UserRepository userRepository){
            this.userRepository= userRepository;
        }

    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        return userDTO;
    }

        public User createUser(User user){
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
