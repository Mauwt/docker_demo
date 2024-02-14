package org.example.demo_api.domain;

import org.example.demo_api.dto.UserDto;
import org.example.demo_api.infrastructure.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    //endregion

    public UserDto findUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));


        return modelMapper.map(user, UserDto.class);
    }

    public List<UserDto> findAllUsers(){
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    public void saveUser(UserDto req) {
        User user = new User();
        user.setName(req.getName());
        user.setAge(req.getAge());

        userRepository.save(user);
    }

}
