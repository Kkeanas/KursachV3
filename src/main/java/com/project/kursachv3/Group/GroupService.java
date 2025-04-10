package com.project.kursachv3.Group;

import com.project.kursachv3.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }
    public boolean existsGroupByName(String name) {
        return groupRepository.existsByName(name);
    }
    public Group getGroupByName(String name) {
        return groupRepository.findByName(name).orElse(null);
    }

    public Group getGroupById(long id) {
        return groupRepository.findById(id).orElse(null);
    }

    public Group postGroup(GroupPostDTO groupPostDTO) {
        if (getGroupByName(groupPostDTO.getName()) != null) {
            throw new DataIntegrityViolationException(String.format("Группа с именем = %s уже существует", groupPostDTO.getName()));
        }
        return groupRepository.save(GroupPostDTO.convertFromDTO(groupPostDTO));
    }

    public String deleteGroupById(long id) {
        Group group = getGroupById(id);
        if (group != null) {
            groupRepository.deleteById(id);
            return group.getName();
        }
        throw new DataIntegrityViolationException(String.format("Группы с id=%d не существует", id));
    }

    public Group updateGroupById(GroupPostDTO groupPostDTO, long id) {
        Group group = getGroupById(id);
        if (group != null) {
            group.setName(groupPostDTO.getName());
            Group result = groupRepository.save(group);
            return result;
        }
        throw new DataIntegrityViolationException(String.format("Группы с id=%d не существует", id));
    }
}
