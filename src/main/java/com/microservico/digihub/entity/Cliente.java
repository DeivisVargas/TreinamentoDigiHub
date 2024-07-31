package com.microservico.digihub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
import java.util.Objects;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome" , nullable = false , unique = true , length = 100)
    private String nome ;

    @Column(name = "documento" , nullable = false , length = 200)
    private String documento ;

    @Column(name = "razao_social" , nullable = false , length = 200)
    private String razao_social ;

    @Column(name = "representante" , nullable = false , length = 200)
    private String representante ;


    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable = false , length = 25)
    private Status status = Status.ATIVO;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", orphanRemoval = true, optional = true)
    @JsonIgnore
    private Endereco endereco;

    //Gerando um Id
    @PrePersist
    protected void onCreate() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }

    public enum Status{
        ATIVO,
        INATIVO
    }

}
