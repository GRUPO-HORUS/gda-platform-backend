package com.horustek.gda;

import com.horustek.gda.model.domain.Gda_Rol;
import com.horustek.gda.model.domain.Gda_Usuario;
import com.horustek.gda.repositories.security.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GdaApplication implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    public static void main(String[] args) {
        SpringApplication.run(GdaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Gda_Rol admin_rol = Gda_Rol.builder()
//                .nombre("ADMIN").build();
//        List<Gda_Rol> roles = new ArrayList<>();
//        roles.add(admin_rol);
//
//        Gda_Rol usuario_rol = Gda_Rol.builder()
//                .nombre("USER").build();
//        List<Gda_Rol> roles1 = new ArrayList<>();
//        roles1.add(usuario_rol);
//
//
//
//
//        Gda_Usuario usuario = Gda_Usuario.builder()
//                .usuario("Alejandro")
//                .email("alejandro@email.com")
//                .password("12345")
//                .enabled(true)
//                .roles(roles).build();
//
//        Gda_Usuario usuario1 = Gda_Usuario.builder()
//                .usuario("CArlos")
//                .email("carlos@email.com")
//                .password("12345")
//                .enabled(true)
//                .roles(roles1).build();
//
//        usuarioRepository.save(usuario);
//        usuarioRepository.save(usuario1);

        Optional<Gda_Usuario> usuario = usuarioRepository.findById("f70c86ef-5b6f-4fe2-8cdf-d46560d7ad4d");
        Gda_Usuario salva = null;

        if (usuario.isPresent()) {
            salva = usuario.get();
            usuarioRepository.delete(salva);
        }


    }
}
