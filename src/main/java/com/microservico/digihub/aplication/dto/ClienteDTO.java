package com.microservico.digihub.aplication.dto;

import java.util.List;

public record ClienteDTO(String id, String nome, String documento, String razao_social, String representante,
                         String status, List<EnderecoDTO> endereco) {
}