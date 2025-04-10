package com.project.kursachv3.Organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> getAllOrganization() {
        List<Organization> result = organizationRepository.findAll();
        return result;
    }

    public Organization getOrganizationById(long id) {
        Organization result = organizationRepository.findById(id).orElse(null);
        return result;
    }
    public Organization getOrganizationByName(String name) {
        Organization result = organizationRepository.findByName(name).orElse(null);
        return result;
    }

    public Organization postOrganization(OrganizationPostDTO organizationPostDTO) {
        if (getOrganizationByName(organizationPostDTO.getName()) != null) {
            throw new DataIntegrityViolationException(String.format("Организация с именем = %s уже существует", organizationPostDTO.getName()));
        }
        return organizationRepository.save(OrganizationPostDTO.convertFromDTO(organizationPostDTO));
    }
}
