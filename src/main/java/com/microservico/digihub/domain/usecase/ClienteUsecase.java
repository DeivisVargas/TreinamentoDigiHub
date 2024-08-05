package com.microservico.digihub.domain.usecase;

import com.microservico.digihub.aplication.dto.ClienteDTO;
import com.microservico.digihub.domain.entity.Cliente;

import java.util.List;

public interface ClienteUsecase {

    ClienteDTO salvar(ClienteDTO cliente);

    Cliente buscarPorId(Long id);

    List<Cliente> buscarTodos();

    void deletarPorId(Long id);

    Cliente atualizar(Cliente cliente);

    Cliente buscarPorNome(String nome);

    Cliente buscarPorRepresentante(String representante);
}
