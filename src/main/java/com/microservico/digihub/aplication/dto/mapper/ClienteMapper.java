package com.microservico.digihub.aplication.dto.mapper;

//import com.microservico.digihub.web.dto.ClienteCreateDto;

import com.microservico.digihub.aplication.dto.ClienteDTO;
import com.microservico.digihub.aplication.dto.EnderecoDTO;
import com.microservico.digihub.domain.entity.Cliente;
import com.microservico.digihub.domain.entity.Endereco;
import com.microservico.digihub.domain.entity.enums.Status;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteMapper {

    public Cliente toCliente(ClienteDTO createDto){

        Cliente cliente = Cliente.builder()
                .id(createDto.id().isEmpty() ? null : UUID.fromString(createDto.id()))
                .nome(createDto.nome())
                .documento(createDto.documento())
                .razao_social(createDto.razao_social())
                .representante(createDto.representante())
                .status(Status.valueOf(createDto.status()))
                .build();
        cliente.setEndereco(
                createDto.endereco()
                        .stream()
                        .map(endereco -> toEndereco(endereco, cliente)).toList());

        return  cliente;
    }

    public ClienteDTO toClienteDTO(Cliente cliente){
        return new ClienteDTO(
                cliente.getId().toString(),
                cliente.getNome(),
                cliente.getDocumento(),
                cliente.getRazao_social(),
                cliente.getRepresentante(),
                cliente.getStatus().name(),
                cliente.getEndereco().stream().map(this::toEnderecoDTO).toList());
    }

    private Endereco toEndereco(EnderecoDTO endereco, Cliente cliente){
        return Endereco.builder()
                .id(endereco.id().isEmpty() ? null : UUID.fromString(endereco.id()))
                .endereco(endereco.endereco())
                .estado(endereco.estado())
                .cliente(cliente)
                .build();
    }

    private EnderecoDTO toEnderecoDTO(Endereco endereco){
        return new EnderecoDTO(endereco.getId().toString(), endereco.getEndereco(), endereco.getEstado());
    }

    /*
    public static Cliente toCliente(ClienteCreateDto createDto){
        return  new ModelMapper().map(createDto , Cliente.class);

    }

     */

    /*
    //modelo de resposta
    public static ClienteResponseDto toDto(Cliente usuario){



        //convertendo o "ROLE_ADMIN" EM APENAS "ADMIN" E SETANDO ELE NA CLASSE DTO NA sTRING role
        String role = usuario.getRole().name().substring("ROLE_".length());
        PropertyMap<Cliente , ClienteResponseDto> props = new PropertyMap<Cliente, ClienteResponseDto>() {
            @Override
            protected void configure() {
                map().setRole(role);
            }
        };



        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(props);
        return mapper.map(usuario , ClienteResponseDto.class);



    }
    */


    /*
    public static List<ClienteResponseDto> toListDto(List<Cliente> clientes){

        //assim a ide fala que é a forma correta
        //return usuarios.stream().map(ClienteMapper::toDto).collect(Collectors.toList());
        return clientes.stream().map().collect(Collectors.toList());
    }

     */


}
