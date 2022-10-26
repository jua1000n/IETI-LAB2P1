package escuelaing.ieti.lab2p1.controller;

import escuelaing.ieti.lab2p1.dto.UserDTO;
import escuelaing.ieti.lab2p1.entities.User;
import escuelaing.ieti.lab2p1.service.UserService;
import escuelaing.ieti.lab2p1.utils.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/v1/user")
public class UserController {


    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    private final AtomicLong counter = new AtomicLong(0);

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        try {
            System.out.println();
            return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        try {
            return new ResponseEntity<>(userService.findById(id), HttpStatus.ACCEPTED);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        try{
            User user = new User(userDTO);
            user.setRoles(Collections.singletonList(RoleEnum.USER));
            return new ResponseEntity<>(userService.create(user) ,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
        try{
            User user = userService.findById(id);
            user.setEmail(userDTO.getEmail());
            user.setName(userDTO.getName());
            user.setLastName(userDTO.getLastName());
            user.setCreatedAt(userDTO.getCreatedAt());
            if (userDTO.getPassword() != null) {
                user.setPasswordHash(BCrypt.hashpw(userDTO.getPassword(), BCrypt.gensalt()));
            }
            return new ResponseEntity<>(userService.update(user, id), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ADMIN")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        try{
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
}
