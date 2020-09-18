package com.horustek.gda.resources.gestionalertas;

import com.horustek.gda.services.gestionalertas.IDashboardService;
import com.horustek.gda.services.gestionbien.bien.IBienService;
import com.horustek.gda.shared.dto.gestionalertas.DashboardDTO;
import com.horustek.gda.shared.dto.gestionbienes.GDABienDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/dashboard")
public class DashboardRestController {

    private final IDashboardService dashboardService;

    @GetMapping
    public ResponseEntity<?> getDashboardData() {
        DashboardDTO dashboardDTO = dashboardService.datosDashboard();
        return new ResponseEntity<>(dashboardDTO, HttpStatus.OK);
    }

}
