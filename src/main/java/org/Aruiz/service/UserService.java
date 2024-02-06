package org.Aruiz.service;

import org.Aruiz.exception.RecordNotFoundException;
import org.Aruiz.model.User;
import org.Aruiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    static UserRepository userRepository;

    /**
     * Obtiene todos los usuarios
     *
     * @return La lista de usuarios
     */
    public static List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    /**
     * Obtiene un usuario por su id
     *
     * @param id El id del usuario
     * @return El usuario con el id dado
     */
    public static User getUserById(int id) {
        Optional<User> user = userRepository.findById((long) id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RecordNotFoundException("No se encontró un usuario con el id: " + id);
        }
    }

    /**
     * Crea o actualiza un usuario
     *
     * @param user El usuario a crear o actualizar
     * @return El usuario creado o actualizado
     */
    public static User createOrUpdateUser(User user) {
        User end;
        if (user.getId() >0) {// Actualizar
            Optional<User> result = userRepository.findById(user.getId());
            if (result.isPresent()) {
                User fromDB = result.get();
                fromDB.setUserName(user.getUserName());
                fromDB.setPassword(user.getPassword());
                fromDB.setLatitude(user.getLatitude());
                fromDB.setLongitude(user.getLongitude());
                fromDB.setImageProfile(user.getImageProfile());
                fromDB.setBiography(user.getBiography());
                end = userRepository.save(fromDB);
            } else {
                throw new RecordNotFoundException("No se encontró un usuario con el id: " + user.getId());
            }
        } else {// Insertar
            end= userRepository.save(user);
        }
        return end;
    }

    /**
     * Elimina un usuario por su id
     *
     * @param id El id del usuario a eliminar
     */
    public static void deleteUser(int id) {
        Optional<User> result = userRepository.findById((long) id);
        if (result.isPresent()) {
            userRepository.deleteById((long) id);
        } else {
            throw new RecordNotFoundException("No se encontró un usuario con el id: " + id);
        }
    }

    /**
     * Obtiene un usuario por su nombre de usuario
     *
     * @param username El nombre de usuario del usuario
     * @return El usuario con el nombre de usuario dado
     */
    public static User getUserByName(String username) {
        Optional<User> result = userRepository.findByUsername(username);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RecordNotFoundException("No se encontró un usuario con el nombre de usuario: " + username);
        }
    }
}