package com.project.kursachv3;

//import com.project.kursachv3.Group.GroupService;
//import com.project.kursachv3.Organization.OrganizationService;
//import com.project.kursachv3.Student.ReportService;
//import com.project.kursachv3.Role.RoleService;
//import com.project.kursachv3.User.UserService;
import com.project.kursachv3.Group.GroupService;
import com.project.kursachv3.Organization.OrganizationService;
import com.project.kursachv3.Role.Role;
import com.project.kursachv3.Role.RolePostDTO;
import com.project.kursachv3.Role.RoleService;
import com.project.kursachv3.Student.StudentService;
import com.project.kursachv3.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private StudentService studentService;


    @Override
    public void run(String... args) throws Exception {
        if (roleService.getRoleByRole("ROLE_USER") == null) {
            RolePostDTO roleUser = new RolePostDTO();
            roleUser.setRole("ROLE_USER");
            roleService.postRole(roleUser);
        }
        if (roleService.getRoleByRole("ROLE_ADMIN") == null) {
            RolePostDTO roleAdmin = new RolePostDTO();
            roleAdmin.setRole("ROLE_ADMIN");
            roleService.postRole(roleAdmin);
        }

    }
}