package br.com.api.desafio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.desafio.modelo.UsuarioModelo;

@Repository
public interface UsuarioComumRepositorio  extends JpaRepository<UsuarioModelo, Integer> {
   
}
