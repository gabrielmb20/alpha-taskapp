package cr.una.taskapp.backend.webservice;

import cr.una.taskapp.backend.dto.RoleDto;
import cr.una.taskapp.backend.model.Role;
import cr.una.taskapp.backend.service.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for Role
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/api/v1/roles")
public class RoleController {
    @Autowired
    private IRoleService service;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Find all Departments
     * @return List of DTO Department
     */
    @GetMapping()
    @ResponseBody
    public List<RoleDto> findAll() {
        List<Role> roleList = service.findAll();
        return roleList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Find the role by id
     * Endpoint: /api/v1/roles/1
     * @return A department found
     */
    @GetMapping("{id}")
    @ResponseBody
    public RoleDto findById(@PathVariable Long id) {
        Role role = service.findById(id);
        return convertToDto(role);
    }

    /**
     * Save the new Role
     * @param roleDto role saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoleDto save(@Valid @RequestBody RoleDto roleDto) {
        Role role = convertToEntity(roleDto);
        return convertToDto(service.create(role));

    }

    /**
     * Update the existing role
     * @param roleDto the role saved
     * @return the role updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RoleDto update(@Valid @RequestBody RoleDto roleDto) {
        Role role = convertToEntity(roleDto);
        return convertToDto(service.update(role));
    }

    /**
     * Delete role by id
     * @param id the id of the entity
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    /**
     * Convert from Entity to DTO
     * @param role entity
     * @return the DTO
     */
    private RoleDto convertToDto(Role role) {
        RoleDto roleDto = modelMapper.map(role, RoleDto.class);
        return roleDto;
    }

    /**
     * Convert from DTO to Entity
     * @param roleDto the DTO
     * @return the entity
     */
    private Role convertToEntity(RoleDto roleDto) {
        Role role = modelMapper.map(roleDto, Role.class);
        return role;
    }
}
