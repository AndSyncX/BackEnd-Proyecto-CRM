package com.j_d_solutions.crm.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return userRepository.save(user);
    }

    public UserDto updateUser(UserDto dto, int id) {
        if (!userRepository.existsById(id)){
            throw new RuntimeException("Usuario no encontrado");
        }
        userRepository.UpdateUserParcial(
                dto.getUsername(),
                dto.getPassword(),
                dto.getRole(),
                id
        );
        return dto;
    }
}
