package com.horustek.gda.services.gestionbien.bien;

import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienTipoDTO;
import com.horustek.gda.shared.dto.gestionbienes.GdaDetalleBienDTO;
import com.horustek.gda.shared.dto.gestionbienes.RegistroBienDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBienDatosContablesService {

    /**
     * Este metodo permite insertar un coeficiente de revaluo
     */
    void insertarCoeficienteRevaluo(double valorCoeficiente);


}
