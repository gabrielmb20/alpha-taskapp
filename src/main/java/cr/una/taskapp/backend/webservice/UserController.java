package cr.una.taskapp.backend.webservice;

import cr.una.taskapp.backend.dto.UserDto;
import cr.una.taskapp.backend.model.User;
import cr.una.taskapp.backend.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Webservice Controller for User
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    private IUserService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Find all Users
     * @return List of DTO User
     */
    @GetMapping()
    @ResponseBody
    public List<UserDto> findAll() {
        List<User> userList = service.findAll();
        return userList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Save the new User
     * @param userDto the User saved
     * @return
     */
    @PostMapping(path = "/sign-up", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto signUp(@Valid @RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return convertToDto(service.create(user));
    }

    /**
     * Find the user by id
     * Endpoint: /api/v1/users/1
     * @return A user found
     */
    @GetMapping("{id}")
    @ResponseBody
    public UserDto findById(@PathVariable Long id) {
        User user = service.findById(id);
        return convertToDto(user);
    }

    /**
     * Save the new User
     * @param userDto the user saved
     * @return
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToDto(service.create(user));

    }

    /**
     * Update the existing user
     * @param userdto the user saved
     * @return the user updated
     */
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto update(@Valid @RequestBody UserDto userdto) {
        User user = convertToEntity(userdto);
        return convertToDto(service.update(user));
    }

    /**
     * Delete user by id
     * @param id the id of the entity
     */
    @DeleteMapping("{id}")
    @ResponseBody
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    /**
     * Convert from Entity to DTO
     * @param user entity
     * @return the DTO
     */
    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    /**
     * Convert from DTO to Entity
     * @param userdto the DTO
     * @return the entity
     */
    private User convertToEntity(UserDto userdto) {
        User user = modelMapper.map(userdto, User.class);
        return user;
    }
}
