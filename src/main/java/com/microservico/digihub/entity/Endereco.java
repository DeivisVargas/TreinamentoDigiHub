package com.microservico.digihub.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "enderecos")

public class Endereco

{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //para gerar um id automaticamente
    @Column(name = "id")
    private UUID id;

    @Column(name = "endereco" , nullable = false , length = 200)
    private String endereco ;

    @Column(name = "estado" , length = 2)
    private String estado ;

    @OneToOne()
    @JoinColumn(name = "cliente_id" , nullable = false)
    private Cliente cliente;


}
