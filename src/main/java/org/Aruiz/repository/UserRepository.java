package org.Aruiz.repository;


import org.Aruiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Método para buscar un usuario por su nombre de usuario (único)
    @Query("SELECT username FROM User WHERE username = ?1")
    Optional<User> findByUsername(String username);

    // Método para buscar un usuario por su id de usuario
    @Query("SELECT id FROM User WHERE id = ?1")
    Optional<User> findById(int id);

    // Método para eliminar un usuario por su id de usuario
    void deleteById(int id);

}