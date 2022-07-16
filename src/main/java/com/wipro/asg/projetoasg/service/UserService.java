package com.wipro.asg.projetoasg.service;



import com.wipro.asg.projetoasg.entity.UserDetails;
import com.wipro.asg.projetoasg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Transactional
    public UserDetails loginUser(String email,String passcode){
        UserDetails userDetails = repository.findUserByUsernameAndPassword(email,passcode);
        if(userDetails!=null){
            return userDetails;
        }
        return null;
    }
    @Transactional
    public UserDetails criarUser(UserDetails userDetails){
        UserDetails user = repository.save(userDetails);
        if(user!=null){
            return user;
        }
        return null;
    }
    @Transactional(readOnly = true)
    public UserDetails pegarUmUsuario(Long id){
        Optional<UserDetails> userDetails = repository.findById(id);
        UserDetails user = userDetails.orElse(null);
        return user;
    }
    @Transactional
    public UserDetails editarUser(Long id,UserDetails userDetails){
        UserDetails user = repository.getOne(id);
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmailId(userDetails.getEmailId());
        user.setPasscode(user.getPasscode());
        user.setContactNumber(userDetails.getContactNumber());
        UserDetails usuarioUpdate = repository.save(user);
        if(usuarioUpdate!=null){
            return  usuarioUpdate;
        }
        return null;
    }

}
