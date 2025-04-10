package com.project.kursachv3.Organization;

import com.project.kursachv3.Group.GroupShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<OrganizationShowDTO> getAllOrganization() {
        List<Organization> rawResult = organizationService.getAllOrganization();
        List<OrganizationShowDTO> result = rawResult.stream()
                .map(OrganizationShowDTO::convertToDTO)
                .collect(Collectors.toList());
        return result;
    }
    @GetMapping("/{id}")
    public OrganizationGetDTO getOrganizationById(@PathVariable long id) {
        Organization rawResult = organizationService.getOrganizationById(id);
        OrganizationGetDTO result = OrganizationGetDTO.convertToDTO(rawResult);
        return result;
    }
    @PostMapping
    public OrganizationGetDTO postOrganization(@RequestBody OrganizationPostDTO organizationPostDTO) {
        Organization rawResult = organizationService.postOrganization(organizationPostDTO);
        OrganizationGetDTO result = OrganizationGetDTO.convertToDTO(rawResult);
        return result;
    }
}
