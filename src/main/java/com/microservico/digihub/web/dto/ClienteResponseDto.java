package com.microservico.digihub.web.dto;


import lombok.*;

//gerando metodos com lombok
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class ClienteResponseDto {

    private Long id ;
    private String name;
    private String documento;
    private String endereco;
    private boolean status;

}
