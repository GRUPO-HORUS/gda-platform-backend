package com.horustek.gda.services.gestionalertas.impl;

import com.horustek.gda.model.domain.GdaBien;
import com.horustek.gda.model.domain.enumeradores.BienEstadoEnum;
import com.horustek.gda.repositories.gestionbienes.BienRepository;
import com.horustek.gda.services.gestionalertas.IDashboardService;
import com.horustek.gda.shared.dto.gestionalertas.DashboardDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DashboardServiceImpl implements IDashboardService {
    private final BienRepository bienRepository;

    //TODO poner readonly
    @Override
    public DashboardDTO datosDashboard() {

        long countPendienteEtiquetado = 0;
        long countPendienteAprobacion = 0;
        long bienesCount = bienRepository.count();


        List<BienEstadoEnum> bienEstados = new ArrayList<>();
        bienEstados.add(BienEstadoEnum.PENDIENTE_ETIQUETADO);
        bienEstados.add(BienEstadoEnum.PENDIENTE_APROBACION);


        // Buscar los bienes por estados para mostrar  la cantidad en el dashboard
        List<GdaBien> listadoBienDB = bienRepository.findGdaBienByBienEstadoIn(bienEstados);
        for (GdaBien bien : listadoBienDB) {
            switch (bien.getBienEstado()) {
                case PENDIENTE_ETIQUETADO:
                    countPendienteEtiquetado++;
                    break;
                case PENDIENTE_APROBACION:
                    countPendienteAprobacion++;
                    break;
            }
        }

        return DashboardDTO.builder()
                .totalElementos(bienesCount)
                .pendientesAprobacion(countPendienteAprobacion)
                .pendientesEtiquetado(countPendienteEtiquetado)
                .build();

    }
}
