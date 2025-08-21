
package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.UserDTO;
import model.User;
import service.IUser;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUser userService;


    public UserController(IUser userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getAll() {return userService.getAllUsers();}


    @PostMapping
    public UserDTO create(@RequestBody User user) {return userService.createUser(user);}
    

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {return userService.getById(id);}
        

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO user) { return userService.update(id, user);}
    

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {userService.delete(id);}
    
}