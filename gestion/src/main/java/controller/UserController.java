
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
    public List<User> listar() {
        return userService.listar();
    }

    @PostMapping
    public User crear(@RequestBody User user) {
        return userService.crear(user);
    }

    @GetMapping("/{id}")
    public User obtener(@PathVariable Long id) {
        return userService.obtener(id);
    }

    @PutMapping("/{id}")
    public User actualizar(@PathVariable Long id, @RequestBody User user) {
        return userService.actualizar(id, user);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        userService.eliminar(id);
    }
}