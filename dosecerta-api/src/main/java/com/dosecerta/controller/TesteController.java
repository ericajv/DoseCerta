//ARQUIVO TESTA SE O BANCO ESTÁ FUNCIONAL

package com.dosecerta.controller;

import java.sql.Connection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dosecerta.config.DatabaseConnection;

@RestController
@RequestMapping("/teste")
public class TesteController {

    private DatabaseConnection db = new DatabaseConnection();

    @GetMapping
    public String testar() {
        try (Connection conn = db.getConnection()) {
            return "Conectado com sucesso!";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }
}