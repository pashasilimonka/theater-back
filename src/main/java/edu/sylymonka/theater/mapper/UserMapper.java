package edu.sylymonka.theater.mapper;/*
  @author   silim
  @project   theater
  @class  UserMapper
  @version  1.0.0 
  @since 03.06.2024 - 17.51
*/

import edu.sylymonka.theater.dto.user.SignUpDto;
import edu.sylymonka.theater.dto.user.UserDto;
import edu.sylymonka.theater.model.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserMapper {
    private final ModelMapper modelMapper;
    private void configureModelMapper() {
        modelMapper.addMappings(new PropertyMap<SignUpDto, User>() {
            @Override
            protected void configure() {
                skip(destination.getPassword());
            }
        });
    }

    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User toUser(SignUpDto userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
