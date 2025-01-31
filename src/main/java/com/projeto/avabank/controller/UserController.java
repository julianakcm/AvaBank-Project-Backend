package com.projeto.avabank.controller;

import com.projeto.avabank.Dto.UserDTO;
import com.projeto.avabank.model.User;
import com.projeto.avabank.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Criar usuário (necessita de DTO)
    @PostMapping ("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = userService.createUser(userDTO);
        return ResponseEntity.ok(createdUserDTO);
    }

    // Buscar todos os usuários (não precisa de DTO)
    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    // Buscar usuário por CPF (não precisa de DTO)
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<User> findByCpf(@PathVariable String cpf) {
        User user = userService.findByCpf(cpf);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Deletar usuário por ID (não precisa de DTO)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Deletar todos os usuários (não precisa de DTO)
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        userService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    // Atualizar usuário (não precisa de DTO, usa a entidade diretamente)
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = userService.updateUser(user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
