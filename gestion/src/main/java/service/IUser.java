package service;

import java.util.List;

import dto.UserDTO;
import model.User;

public interface IUser {

    List<UserDTO> getAllUsers();
    UserDTO createUser(User user);
    UserDTO getById(Long id);
    UserDTO update(Long id, UserDTO user);
    void delete(Long id);
}
