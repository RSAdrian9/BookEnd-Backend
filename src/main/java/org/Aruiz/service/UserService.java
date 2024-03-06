package org.Aruiz.service;

import org.Aruiz.exception.RecordNotFoundException;
import org.Aruiz.exception.UsernameAlreadyExistsException;
import org.Aruiz.model.User;
import org.Aruiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Obtiene todos los usuarios
     *
     * @return La lista de usuarios
     */
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    /**
     * Obtiene un usuario por su id
     *
     * @param id El id del usuario
     * @return El usuario con el id dado
     */
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById((int) id);
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

    public User createOrUpdateUser(User user) {
        // Verificar si el usuario ya existe por su id
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            // Si el usuario existe, actualizar sus datos
            return userRepository.save(user);
        } else {
            // Si el usuario no existe, verificar si el nombre de usuario ya está en uso
            Optional<User> existingUsername = userRepository.findByUsername(user.getUserName());
            if (existingUsername.isPresent()) {
                throw new UsernameAlreadyExistsException("El nombre de usuario ya está en uso.");
            } else {
                // Si el nombre de usuario no está en uso, crear un nuevo usuario
                return userRepository.save(user);
            }
        }
    }

    /*
    public User createOrUpdateUser(User user) {
        if (user.getId() > 0) { // Actualizar
            Optional<User> result = userRepository.findById(user.getId());
            if (result.isPresent()) {
                User fromDB = result.get();
                fromDB.setUserName(user.getUserName());
                fromDB.setPassword(user.getPassword());
                fromDB.setLatitude(user.getLatitude());
                fromDB.setLongitude(user.getLongitude());
                fromDB.setImageProfile(user.getImageProfile());
                fromDB.setBiography(user.getBiography());
                return userRepository.save(fromDB);
            } else {
                throw new RecordNotFoundException("No se encontró un usuario con el id: " + user.getId());
            }
        } else { // Insertar
            // Verificar si el nombre de usuario ya existe
            Optional<User> existingUser = userRepository.findByUsername(user.getUserName());
            if (existingUser.isPresent()) {
                throw new UsernameAlreadyExistsException("El nombre de usuario ya está en uso.");
            }
            // Si el nombre de usuario no existe, proceder con la inserción
            return userRepository.save(user);
        }
    }

     */

    /*
    public User createOrUpdateUser(User user) {
        return userRepository.save(user);
    }
     */



    /**
     * Elimina un usuario por su id
     *
     * @param id El id del usuario a eliminar
     */
    public void deleteUser(int id) {
        Optional<User> result = userRepository.findById((int) id);
        if (result.isPresent()) {
            userRepository.deleteById((int) id);
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
    public User getUserByName(String username) {
        Optional<User> result = userRepository.findByUsername(username);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RecordNotFoundException("No se encontró un usuario con el nombre de usuario: " + username);
        }
    }
}