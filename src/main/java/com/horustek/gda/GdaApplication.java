package com.horustek.gda;

import com.horustek.gda.model.domain.GdaRol;
import com.horustek.gda.model.domain.GdaUsuario;
import com.horustek.gda.repositories.seguridad.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class GdaApplication implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(GdaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


//        GdaRol admin_rol = GdaRol.builder()
//                .nombre("ADMIN").build();
//        List<GdaRol> roles = new ArrayList<>();
//        roles.add(admin_rol);
//
//        GdaRol usuario_rol = GdaRol.builder()
//                .nombre("USER").build();
//        List<GdaRol> roles1 = new ArrayList<>();
//        roles1.add(usuario_rol);
//
//
//
//
//        GdaUsuario usuario = GdaUsuario.builder()
//                .nombreUsuario("alafourcade")
//                .email("alejandro@email.com")
//                .credencial("$2a$10$pFiAD93lq2khbmOl4xBlSOpIxgjEphHmE/PIPQAIN0WlrQR3vBN/6")
//                .enabled(true)
//                .roles(roles).build();
//
//        GdaUsuario usuario1 = GdaUsuario.builder()
//                .nombreUsuario("cmontes")
//                .email("carlos@email.com")
//                .credencial("$2a$10$pFiAD93lq2khbmOl4xBlSOpIxgjEphHmE/PIPQAIN0WlrQR3vBN/6")
//                .enabled(true)
//                .roles(roles1).build();
//
//        usuarioRepository.save(usuario);
//        usuarioRepository.save(usuario1);

//        Optional<GdaUsuario> usuario = usuarioRepository.findById("e17e6941-4937-48bc-b47f-88d881b19ae7");
//        GdaUsuario salva = null;
//
//        if (usuario.isPresent()) {
//            salva = usuario.get();
//            usuarioRepository.delete(salva);
//        }


    }
}
