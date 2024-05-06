package com.compass.projectOne.services;

import com.compass.projectOne.entities.User;
import com.compass.projectOne.repositories.UserRepository;
import com.compass.projectOne.services.exceptions.DatabaseException;
import com.compass.projectOne.services.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User>  findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);

        return user.get();
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void deleteId(Long id){
        try{
            userRepository.deleteById(id);
        } catch(EmptyResultDataAccessException exception){
            throw new RecordNotFoundException(id);
        } catch (DataIntegrityViolationException exception){
            throw new DatabaseException(exception.getMessage());
        }
    }

    public User updateUser(Long id, User user){
        User target = userRepository.getReferenceById(id);
        updateData(user, target);
        return userRepository.save(target);
    }

    public void updateData(User source, User target){
        target.setName(source.getName());
        target.setEmail(source.getEmail());
        target.setPhone(source.getPhone());
    }
}
