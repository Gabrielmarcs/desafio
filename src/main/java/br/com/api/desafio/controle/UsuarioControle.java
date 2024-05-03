package br.com.api.desafio.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.desafio.modelo.UsuarioComumModelo;
import br.com.api.desafio.modelo.UsuarioLojistaModelo;
import br.com.api.desafio.repositorio.UsuarioComumRepositorio;
import br.com.api.desafio.repositorio.UsuarioLojistaRepositorio;

@RestController
@RequestMapping("/api/usuario")

public class UsuarioControle {

    @Autowired
    private UsuarioComumRepositorio usuarioComumR;

    @Autowired
    private UsuarioLojistaRepositorio usuarioLojistaR;


    @PostMapping("/comum")
    public ResponseEntity<UsuarioComumModelo> addUsuarioComum(@RequestBody UsuarioComumModelo usuarioComum){
        UsuarioComumModelo novoUsuarioComum = usuarioComumR.save(usuarioComum);
        return new ResponseEntity<>(novoUsuarioComum, HttpStatus.CREATED);
    }

    @PostMapping("/lojista")
    public ResponseEntity<UsuarioLojistaModelo> addUsuarioLojista(@RequestBody UsuarioLojistaModelo usuarioLojista){
        UsuarioLojistaModelo novoUsuarioLojista = usuarioLojistaR.save(usuarioLojista);
        return new ResponseEntity<>(novoUsuarioLojista, HttpStatus.CREATED);
    }
}
