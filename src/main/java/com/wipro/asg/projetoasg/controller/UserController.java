package com.wipro.asg.projetoasg.controller;

import com.wipro.asg.projetoasg.entity.UserDetails;
import com.wipro.asg.projetoasg.repository.UserRepository;
import com.wipro.asg.projetoasg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( value = "/")
public class UserController {

    @Autowired
    private UserRepository repositoryservice;
    @Autowired
    private UserService repository;


     @GetMapping(value = "/login/usurious/{email}/{passcode}")
     public ResponseEntity<UserDetails> login(@PathVariable String email,@PathVariable String passcode){
         return ResponseEntity.ok().body(repository.loginUser(email,passcode));
     }

     @PostMapping("/Registration/Create/novo")
     public ResponseEntity<UserDetails> criar(@RequestBody UserDetails userDetails){
         System.out.println(userDetails);
         return ResponseEntity.ok().body(repository.criarUser(userDetails));
     }
    // PEGAR UM USUARIO PELO ID USER LIST
    @GetMapping(value = "/UserDetail/index/pegar/{id}")
    public ResponseEntity<UserDetails>pegarUmusuario(@PathVariable Long id){
        return ResponseEntity.ok().body(repository.pegarUmUsuario(id));
    }

    // EDITAR USER LIST
    @PutMapping(value = "/UserDetail/index/editaruser/{id}")
    public ResponseEntity<UserDetails> editarUser(@PathVariable Long id,@RequestBody UserDetails userDetails){
        return ResponseEntity.ok().body(repository.editarUser(id,userDetails));
    }


    // TESTE LISTANDO TODOS OS USUARIOS
    @GetMapping(value = "/pegartodos")
    public ResponseEntity<List<UserDetails>> listartodos(){
        return ResponseEntity.ok().body(repositoryservice.findAll());
    }



}
