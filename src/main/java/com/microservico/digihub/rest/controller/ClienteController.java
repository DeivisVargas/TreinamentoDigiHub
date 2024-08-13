package com.microservico.digihub.rest.controller;


import com.microservico.digihub.aplication.dto.ClienteDTO;
import com.microservico.digihub.domain.entity.Cliente;
import com.microservico.digihub.domain.usecase.ClienteUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    private final ClienteUsecase clienteUsecase;

    public ClienteController(ClienteUsecase clienteUsecase) {
        this.clienteUsecase = clienteUsecase;
    }


    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO cliente) {

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteUsecase.salvar(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteUsecase.buscarTodos());

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteUsecase.buscarPorId(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable UUID id) {
        return null;
    }


    @GetMapping("/buscarPorRepresentante")
    public ResponseEntity<List<Cliente>> buscarPorRepresentante(@RequestParam String representante) {
        return null;
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
        return null;
    }


}
