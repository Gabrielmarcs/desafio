package br.com.api.desafio.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.desafio.modelo.UsuarioLojistaModelo;

@Repository
public interface UsuarioLojistaRepositorio  extends CrudRepository<UsuarioLojistaModelo, Long> {
    
}
