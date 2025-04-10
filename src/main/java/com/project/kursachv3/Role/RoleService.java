package com.project.kursachv3.Role;

import com.project.kursachv3.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        List<Role> result = roleRepository.findAll();
        return result;
    }


    public Role getRoleById(long id) {
        Role result = roleRepository.findById(id).orElse(null);
        return result;
    }
    // дописать запрет на удаление ролей если есть юзеры привязанные к ней
    public String deleteRoleById(long id) {
        Role role = getRoleById(id);
        if (role != null) {
            roleRepository.deleteById(id);
            return role.getAuthority();
        }
        throw new DataIntegrityViolationException(String.format("Роли с id=%d не существует", id));
    }

    public Role getRoleByRole(String role) {
        Role result = roleRepository.findByRole(role).orElse(null);
        return result;
    }

    public Role postRole(RolePostDTO rolePostDTO) {
        if (getRoleByRole(rolePostDTO.getRole()) == null) {
            Role result = roleRepository.save(RolePostDTO.convertFromDTO(rolePostDTO));
            return result;
        }
        throw new DataIntegrityViolationException(String.format("Роль %s уже существует", rolePostDTO.getRole()));
    }
}
