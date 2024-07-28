package com.microservico.digihub.web.dto.mapper;

import com.microservico.digihub.entity.Cliente;
//import com.microservico.digihub.web.dto.ClienteCreateDto;
import com.microservico.digihub.web.dto.ClienteResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

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
