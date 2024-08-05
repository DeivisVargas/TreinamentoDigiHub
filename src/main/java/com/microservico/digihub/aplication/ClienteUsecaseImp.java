package com.microservico.digihub.aplication;

import com.microservico.digihub.aplication.dto.ClienteDTO;
import com.microservico.digihub.aplication.dto.mapper.ClienteMapper;
import com.microservico.digihub.domain.entity.Cliente;
import com.microservico.digihub.domain.usecase.ClienteUsecase;
import com.microservico.digihub.repository.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteUsecaseImp implements ClienteUsecase {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    public ClienteUsecaseImp(ClienteMapper clienteMapper, ClienteRepository clienteRepository) {
        this.clienteMapper = clienteMapper;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO salvar(ClienteDTO clienteDTO) {

        Cliente cliente = clienteMapper.toCliente(clienteDTO);

        return clienteMapper.toClienteDTO(
                clienteRepository.save(
                        clienteMapper.toCliente(clienteDTO)));
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Cliente> buscarTodos() {
        return List.of();
    }

    @Override
    public void deletarPorId(Long id) {

    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return null;
    }

    @Override
    public Cliente buscarPorNome(String nome) {
        return null;
    }

    @Override
    public Cliente buscarPorRepresentante(String representante) {
        return null;
    }
}
