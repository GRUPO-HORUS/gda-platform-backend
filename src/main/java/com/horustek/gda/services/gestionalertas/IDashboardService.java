package com.horustek.gda.services.gestionalertas;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.shared.dto.gestionalertas.DashboardDTO;

public interface IDashboardService {

    /**
     * Mostrar los datos que van a ir en la patalla de los dashboard
     */
    DashboardDTO datosDashboard();

}
