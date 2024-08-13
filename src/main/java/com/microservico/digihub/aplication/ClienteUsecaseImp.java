package com.microservico.digihub.aplication;

import com.microservico.digihub.aplication.dto.ClienteDTO;
import com.microservico.digihub.aplication.dto.mapper.ClienteMapper;
import com.microservico.digihub.domain.entity.Cliente;
import com.microservico.digihub.domain.usecase.ClienteUsecase;
import com.microservico.digihub.repository.ClienteRepository;
import com.microservico.digihub.domain.exception.ClienteNaoEncontradoException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public ClienteDTO buscarPorId(String id) {

        Optional<Cliente> cliente = clienteRepository.findById(UUID.fromString(id));

        //TODO implementar tratamento de erro
        /*
        Não usar try catch
        * */
        return cliente.map(clienteMapper::toClienteDTO)
                .orElseThrow(() -> new ClienteNaoEncontradoException("Cliente com ID " + id + " não encontrado"));

    }

    @Override
    public List<ClienteDTO> buscarTodos() {

        List<Cliente> clientes = clienteRepository.findAll();

        return clientes.stream()
                .map(clienteMapper::toClienteDTO) // Mapeia cada Cliente para ClienteDTO
                .collect(Collectors.toList());
    }

    @Override
    public void deletarPorId(String id) {

    }

    @Override
    public ClienteDTO atualizar(Cliente cliente) {
        return null;
    }

    @Override
    public ClienteDTO buscarPorNome(String nome) {
        return null;
    }

    @Override
    public ClienteDTO buscarPorRepresentante(String representante) {
        return null;
    }
}
