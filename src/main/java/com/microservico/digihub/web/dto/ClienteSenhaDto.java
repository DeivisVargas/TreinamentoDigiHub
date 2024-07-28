package com.microservico.digihub.web.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClienteSenhaDto {
    private  String senhaAtual ;
    private  String novaSenha ;
    private  String confirmaSenha ;
}
