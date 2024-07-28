package com.microservico.digihub.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "endereco")

public class Endereco

{
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "endereco" , nullable = false , length = 200)
    private String endereco ;

    @OneToOne
    @JoinColumn(name = "cliente_id", unique = true, nullable = false)
    private Cliente cliente;
}
