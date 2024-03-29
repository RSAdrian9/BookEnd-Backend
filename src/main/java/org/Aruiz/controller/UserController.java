package org.Aruiz.controller;

import org.Aruiz.model.User;
import org.Aruiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Obtiene todos los usuarios
     *
     * @return Lista de usuarios
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Obtiene un usuario por su id
     *
     * @param id El id del usuario
     * @return El usuario con el id dado
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    /**
     * Obtiene un usuario por su nombre de usuario
     *
     * @param username El nombre de usuario del usuario
     * @return El usuario con el nombre de usuario dado
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        User user = userService.getUserByName(username);
        return ResponseEntity.ok(user);
    }

    /**
     * Crea o actualiza un usuario
     *
     * @param user El usuario a crear o actualizar
     * @return El usuario creado o actualizado
     */
    @PostMapping
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User user){
        User end = userService.createOrUpdateUser(user);
        return ResponseEntity.ok(end);
    }

    /**
     * Elimina un usuario por su id
     *
     * @param id El id del usuario a eliminar
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }
}