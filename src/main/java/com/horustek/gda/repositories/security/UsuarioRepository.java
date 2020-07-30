package com.horustek.gda.repositories.security;

import com.horustek.gda.model.domain.Gda_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UsuarioRepository extends JpaRepository<Gda_Usuario, String> {

}
