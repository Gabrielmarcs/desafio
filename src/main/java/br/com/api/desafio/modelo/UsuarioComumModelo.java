package br.com.api.desafio.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UsuarioComumModelo extends UsuarioModelo{
    @Column(unique = true)
    private String cpf;
}
