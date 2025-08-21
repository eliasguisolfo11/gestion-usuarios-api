package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dto.UserDTO;
import model.User;
import repository.UserRepository;

@Service
public class  UserService implements IUser{

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return repository.findAll()
        .stream()
        .map(user -> new UserDTO(user.getName(), user.getEmail()))
        .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        User saved = repository.save(user);
        return new UserDTO(saved.getName(), saved.getEmail(), saved.getId());
    }

    @Override
    public UserDTO getById(Long id) {
        User u = repository.findById(id)
        .orElseThrow();
        return new UserDTO(u.getName(),u.getEmail(),u.getId());
    }

    @Override
    public UserDTO update(Long id, UserDTO data) {
        User u = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User " + id + " no encontrado"));
        u.setName(data.getName());
        u.setEmail(data.getEmail());
        User saved = repository.save(u);
        return new UserDTO(saved.getName(), saved.getEmail(), saved.getId());
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("User " + id + " no encontrado");
        }
        repository.deleteById(id);
    } 


}
