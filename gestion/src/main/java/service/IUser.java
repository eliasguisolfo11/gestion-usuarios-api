package service;

import java.util.List;

import model.User;

public interface IUser {

    List<User> listar();
    User crear(User user);
    User obtener(Long id);
    User actualizar(Long id, User user);
    void eliminar(Long id);
}
