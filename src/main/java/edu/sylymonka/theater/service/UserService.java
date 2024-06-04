package edu.sylymonka.theater.service;/*
  @author   silim
  @project   theater
  @class  UserService
  @version  1.0.0 
  @since 03.06.2024 - 17.43
*/

import edu.sylymonka.theater.dto.credentials.CredentialsDto;
import edu.sylymonka.theater.dto.user.SignUpDto;
import edu.sylymonka.theater.dto.user.UserDto;
import edu.sylymonka.theater.exceptions.AppException;
import edu.sylymonka.theater.mapper.UserMapper;
import edu.sylymonka.theater.model.User;
import edu.sylymonka.theater.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login).orElseThrow(()-> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toDto(user);
    }

    public UserDto login(CredentialsDto credentials){
        User user = userRepository.findByLogin(credentials.getLogin())
                .orElseThrow(()-> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if(passwordEncoder.matches(CharBuffer.wrap(credentials.getPassword()),user.getPassword())){
            return userMapper.toDto(user);
        }
        throw new AppException("Wrong password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto){
        Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());
        if (optionalUser.isPresent()){
            throw new AppException("User already exists", HttpStatus.CONFLICT);
        }
        User user = userMapper.toUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));
        return userMapper.toDto(userRepository.save(user));
    }
}
