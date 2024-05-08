package com.ucb.product.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class LoginController {

    @PostMapping("/login")
    @Operation(summary = "Inicio de sesión", description = "Permite a un usuario iniciar sesión")
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Inicio de sesión exitoso"),
        @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
        @ApiResponse(responseCode = "401", description = "No autorizado")
    })
    public ResponseEntity<String> login(@RequestBody Login login) {
        if (login.getEmail().isEmpty() || login.getPassword().isEmpty()) {

            return ResponseEntity.badRequest().body("La solicitud de inicio de sesión es incorrecta");
        } else {

            String token = "token_de_prueba";
            return ResponseEntity.ok(token);
        }
    }
}
