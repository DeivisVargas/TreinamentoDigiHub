package com.microservico.digihub.repository;

import com.microservico.digihub.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
