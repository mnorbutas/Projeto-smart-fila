package com.senai.smartfila.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.senai.smartfila.entities.Documentos;
import com.senai.smartfila.services.DocumentosService;

@RestController
@RequestMapping("/api/documentos")
@CrossOrigin("*")
public class DocumentosController {

    @Autowired
    private DocumentosService service;

    @GetMapping
    public List<Documentos> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Documentos buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Documentos criar(@RequestBody Documentos documentos) {
        return service.salvar(documentos);
    }

    @PutMapping("/{id}")
    public Documentos atualizar(@PathVariable Long id, @RequestBody Documentos documentos) {
        return service.atualizar(id, documentos);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}