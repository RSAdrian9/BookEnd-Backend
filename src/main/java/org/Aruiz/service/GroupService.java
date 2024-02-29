package org.Aruiz.service;

import org.Aruiz.exception.RecordNotFoundException;
import org.Aruiz.model.Book;
import org.Aruiz.model.Group;
import org.Aruiz.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    /**
     * Obtiene todos los grupos.
     *
     * @return La lista de todos los grupos.
     */
    public List<Group> getAllGroups() {
        List<Group> groups = groupRepository.findAll();
        return groups;
    }

    /**
     * Obtiene un grupo por su ID.
     *
     * @param id El ID del grupo a buscar.
     * @return El grupo encontrado.
     * @throws RecordNotFoundException Si no se encuentra el grupo con el ID proporcionado.
     */
    public Group getGroupById(int id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No se encontró el grupo con el ID: " + id));
    }

    /**
     * Guarda o actualiza un grupo.
     *
     * @param group El grupo a guardar o actualizar.
     * @return El grupo guardado o actualizado.
     */
    public Group createOrUpdateGroup(Group group) {
        return groupRepository.save(group);
    }

    /**
     * Elimina un grupo por su ID.
     *
     * @param id El ID del grupo a eliminar.
     * @throws RecordNotFoundException Si no se encuentra el grupo con el ID proporcionado.
     */
    public void deleteGroupById(int id) {
        if (!groupRepository.existsById(id)) {
            throw new RecordNotFoundException("No se encontró el grupo con el ID: " + id);
        }
        groupRepository.deleteById(id);
    }
}
