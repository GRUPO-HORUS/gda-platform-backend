package com.horustek.gda.shared.dto.seguridad;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.horustek.gda.model.domain.GdaRol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistroDTO {

    @NotBlank
    //Pattern for only numbers and letters
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "GDA_ERR_01")
    private String nombreUsuario;
    @Email
    private String email;
    @Length(min = 6, max = 60, message = "GDA_ERR_02")
    private String credencial;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String telefono;
    private String celular;
    private boolean enabled;
    private List<GdaRol> roles;
}

