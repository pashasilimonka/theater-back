package edu.sylymonka.theater.controller;/*
  @author   silim
  @project   theater
  @class  UserController
  @version  1.0.0 
  @since 03.06.2024 - 18.50
*/

import edu.sylymonka.theater.config.UserAuthProvider;
import edu.sylymonka.theater.dto.credentials.CredentialsDto;
import edu.sylymonka.theater.dto.user.SignUpDto;
import edu.sylymonka.theater.dto.user.UserDto;
import edu.sylymonka.theater.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RequestMapping("api/v1/users")
@RestController
public class UserController {
    private final UserService userService;
    private final UserAuthProvider userAuthProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody CredentialsDto userDto) {
        UserDto user = userService.login(userDto);
        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.ok(user);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody SignUpDto userDto) {
        UserDto user = userService.register(userDto);
        user.setToken(userAuthProvider.createToken(user.getLogin()));
        return ResponseEntity.created(URI.create("/users/" + user.getId())).body(user);
    }
}
