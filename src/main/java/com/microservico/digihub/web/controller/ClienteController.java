package com.microservico.digihub.web.controller;


import com.microservico.digihub.entity.Cliente;
import com.microservico.digihub.entity.Endereco;
import com.microservico.digihub.service.ClienteService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController
{

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){

        Cliente savedCliente =  clienteService.salvar(cliente);
        return  ResponseEntity.status(HttpStatus.CREATED).body(savedCliente);

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAll(){
        List<Cliente> clientes =  clienteService.buscarTodos();
        return ResponseEntity.ok(clientes);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable UUID id) {
        try {
            clienteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com ID " + id + " não encontrado");

        }
    }


    @GetMapping("/buscarPorRepresentante")
    public ResponseEntity<List<Cliente>> buscarPorRepresentante(@RequestParam String representante) {
        List<Cliente> clientes = clienteService.buscarPorRepresentante(representante);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    /*
    @GetMapping("/buscarPorEstado")
    public ResponseEntity<List<Cliente>> buscarPorEstado(@RequestParam String estado) {
        List<Cliente> clientes = clienteService.buscarPorEstado(estado);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

     */

    @GetMapping("/buscarPorNome")
    public ResponseEntity<List<Cliente>> buscarPorNome(@RequestParam String nome) {
        List<Cliente> clientes = clienteService.buscarPorNome(nome);
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }


}
