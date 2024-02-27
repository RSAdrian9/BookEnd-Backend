package org.Aruiz.repository;


import org.Aruiz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Método para buscar un usuario por su nombre de usuario (único)
    Optional<User> findByUsername(String username);

    // Método para eliminar un usuario por su id de usuario
    void deleteById(Integer id);


}