package com.project.kursachv3.Role;

import com.project.kursachv3.Organization.OrganizationShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping
    public List<RoleGetDTO> getAllRole() {
        List<Role> rawResult = roleService.getAllRoles();
        List<RoleGetDTO> result = rawResult.stream()
                .map(RoleGetDTO::convertToDTO)
                .collect(Collectors.toList());
        return result;
    }
    @GetMapping("/{id}")
    public RoleGetDTO getRoleById(@PathVariable long id) {
        Role rawResult = roleService.getRoleById(id);
        RoleGetDTO result = RoleGetDTO.convertToDTO(rawResult);
        return result;
    }
    @DeleteMapping("/{id}")
    public String deleteRoleById(@PathVariable long id) {
        String role = roleService.deleteRoleById(id);
        return String.format("Роль %s удален",role);
    }
    @PostMapping
    public RoleGetDTO postRole(@RequestBody RolePostDTO rolePostDTO) {
        Role rawResult = roleService.postRole(rolePostDTO);
        RoleGetDTO result = RoleGetDTO.convertToDTO(rawResult);
        return result;
    }
}
