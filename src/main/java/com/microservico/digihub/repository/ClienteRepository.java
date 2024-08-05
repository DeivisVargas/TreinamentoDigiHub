package com.microservico.digihub.repository;

import com.microservico.digihub.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository; //fornece os metodos prontos para manipular banco de dados
import java.util.UUID;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {


    List<Cliente> findByrepresentante(String representante);

    //List<Cliente> findByestado(String estado);

    List<Cliente> findByNomeContaining(String nome);
}