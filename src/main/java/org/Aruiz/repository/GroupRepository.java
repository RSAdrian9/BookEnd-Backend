package org.Aruiz.repository;

import org.Aruiz.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    // Métodos personalizados si es necesario
}
