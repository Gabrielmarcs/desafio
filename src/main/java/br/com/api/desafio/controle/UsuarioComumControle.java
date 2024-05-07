package br.com.api.desafio.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.desafio.repositorio.UsuarioComumRepositorio;
import br.com.api.desafio.repositorio.UsuarioLojistaRepositorio;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api.desafio.modelo.UsuarioComumModelo;
import br.com.api.desafio.modelo.UsuarioLojistaModelo;

@RestController
@RequestMapping("/api/usuarioComum")

public class UsuarioComumControle {
    @Autowired
    private UsuarioComumRepositorio ucr;
    
    @Autowired
    private UsuarioLojistaRepositorio ulr;

    @PostMapping("/transferir/{idUsuarioComum}/{idUsuarioLojista}/{valor}")
    public String transferir(@PathVariable Long idUsuarioComum, @PathVariable Long idUsuarioLojista, @PathVariable Double valor) {
        UsuarioComumModelo uc = ucr.findById(idUsuarioComum).get();
        UsuarioLojistaModelo ul = ulr.findById(idUsuarioLojista).get();
        if (uc.getSaldo() >= valor) {
            uc.setSaldo(uc.getSaldo() - valor);
            ul.setSaldo(ul.getSaldo() + valor);
            ucr.save(uc);
            ulr.save(ul);
            return "Transferência realizada com sucesso!";
        } else {
            return "Saldo insuficiente!";
        }
    }
    
    //depositar
    @PostMapping("/depositar/{idUsuarioComum}/{valor}")
    public String depositar(@PathVariable Long idUsuarioComum, @PathVariable Double valor) {
        UsuarioComumModelo uc = ucr.findById(idUsuarioComum).get();
        uc.setSaldo(uc.getSaldo() + valor);
        ucr.save(uc);
        return "Depósito realizado com sucesso!";
    }


}
