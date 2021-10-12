package com.flightapp.user.service;

import com.flightapp.user.exception.UserNotFoundException;
import com.flightapp.user.modal.User;
import com.flightapp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartRequest;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //retrive all the Users

    //retrive User
    public List<User> retriveAllUser() throws UserNotFoundException,RuntimeException{
        return userRepository.findAll();
    }


    //retrive User
    public User retriveUser(long id) throws UserNotFoundException,RuntimeException{
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "ID ", id));
    }

    //update the User Details
    public User retriveUser(User user,long id) throws UserNotFoundException,RuntimeException{
        User retriveUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "ID ", id));
        if (retriveUser != null)
            user.setUserId(retriveUser.getUserId());

        return userRepository.save(user);
    }

    //Delete the User
    public ResponseEntity<?> removeUser(long id) throws UserNotFoundException,RuntimeException{
        User retriveUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User", "ID ", id));
        userRepository.delete(retriveUser);
        return ResponseEntity.ok("User Deleted Successfully!!");
    }

    //upload img the User
    public String uploadUserImg(MultipartRequest multipartRequest) throws UserNotFoundException,RuntimeException{
        byte[] imgByte = multipartRequest.getMultipartContentType("img").getBytes();
        return new String("User Profile uploaded Successfully!!");
    }

}
