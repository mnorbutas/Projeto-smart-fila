package com.senai.smartfila.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senai.smartfila.entities.Aluno;
import com.senai.smartfila.services.AlunoService;

@RestController
@RequestMapping("/api/alunos")
@CrossOrigin("*")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @GetMapping
    public List<Aluno> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Aluno buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        return service.atualizar(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}