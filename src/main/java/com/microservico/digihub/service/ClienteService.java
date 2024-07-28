package com.microservico.digihub.service;

import com.microservico.digihub.entity.Cliente;
import com.microservico.digihub.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteById(UUID id){
        boolean existe = clienteRepository.existsById(id);
        if (existe) {
            clienteRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Cliente com ID " + id + " não encontrado");
        }

    }

    @Transactional
    public Cliente updateCliente(UUID id, Cliente alteraCliente) {
        Optional<Cliente> existeCliente = clienteRepository.findById(id);

        if (existeCliente.isPresent()) {
            Cliente cliente = existeCliente.get();
            cliente.setNome(alteraCliente.getNome());
            cliente.setDocumento(alteraCliente.getDocumento());
            cliente.setRazao_social(alteraCliente.getRazao_social());
            cliente.setRepresentante(alteraCliente.getRepresentante());
            cliente.setEndereco(alteraCliente.getEndereco());
            cliente.setStatus(alteraCliente.getStatus());

            return clienteRepository.save(cliente);
        } else {
            throw new EntityNotFoundException("Cliente com ID " + id + " não encontrado");
        }
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }


    @Transactional(readOnly = true)
    public List<Cliente> buscarPorRepresentante(String representante) {
        return clienteRepository.findByrepresentante(representante);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorEstado(String estado) {
        return clienteRepository.findByestado(estado);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }


}