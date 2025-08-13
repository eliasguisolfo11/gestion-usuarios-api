package service;

import java.util.List;

import model.User;
import repository.UserRepository;

public class  UserImpl implements IUser{

    private final UserRepository repository;

    public UserImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> listar() {
        return repository.findAll();
    }

    @Override
    public User crear(User user) {
        return repository.save(user);
    }

    @Override
    public User obtener(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public User actualizar(Long id, User data) {
        User user = obtener(id);
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        return repository.save(user);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    } 


}
