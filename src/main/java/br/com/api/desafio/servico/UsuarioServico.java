package br.com.api.desafio.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.api.desafio.modelo.UsuarioModelo;
import br.com.api.desafio.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServico {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioModelo salvarUsuario(UsuarioModelo usuario) {
        return usuarioRepositorio.save(usuario);
    }

    // Outros métodos de serviço aqui
}
