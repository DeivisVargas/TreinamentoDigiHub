package com.microservico.digihub.domain.usecase;

import com.microservico.digihub.aplication.dto.ClienteDTO;
import com.microservico.digihub.domain.entity.Cliente;

import java.util.List;

public interface ClienteUsecase {

    ClienteDTO salvar(ClienteDTO cliente);

    ClienteDTO buscarPorId(String id);

    List<ClienteDTO> buscarTodos();

    void deletarPorId(String id);

    ClienteDTO atualizar(Cliente cliente);

    ClienteDTO buscarPorNome(String nome);

    ClienteDTO buscarPorRepresentante(String representante);
}
