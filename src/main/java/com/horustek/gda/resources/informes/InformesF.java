package com.horustek.gda.resources.informes;

import com.horustek.gda.infra.exceptions.BusinessException;
import com.horustek.gda.infra.utils.reports.ExportFormat;
import com.horustek.gda.infra.utils.reports.ReportService;
import com.horustek.gda.shared.dto.gestioninformes.GDAInformesDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.commons.io.IOUtils;
import org.springframework.boot.autoconfigure.web.servlet.DefaultJerseyApplicationPath;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/informes")
public class InformesF {

    private final ReportService reportService;

    @GetMapping(value = "/FC04/public", produces = "application/pdf")
    public ResponseEntity<byte[]> report(/*@PathVariable String username,*/
            @RequestParam(defaultValue = "pdf") ExportFormat format) {
        Map<String, Object> params = new HashMap<>();
        params.put("nombre", "Alejandro");



        String contentType = null;
        if (format == ExportFormat.PDF) contentType = "application/pdf";
        else if (format == ExportFormat.XLSX)
            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        byte[] bytes = reportService.generatePDFReport(format, "user",params);
        ContentDisposition contentDisposition = ContentDisposition.builder("inline")
                .filename("fc04" + "." + "pdf").build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(contentDisposition);


        return ResponseEntity //
                .ok() //
                .header("Content-Type", contentType + "; charset=UTF-8") //
                .headers(headers)
                .body(bytes);
    }


    @PostMapping(value = "/FC03/public")
    public void obtenerReporteJasper(HttpServletResponse response, HttpServletRequest request,
                                     @RequestParam(defaultValue = "pdf") ExportFormat format) {
        InputStream myStream;

        Map<String, Object> params = new HashMap<>();
        params.put("nombre", "Alejandro");

        List<GDAInformesDTO> dtos = new ArrayList<>();

        GDAInformesDTO dto = GDAInformesDTO.builder()
                .nombre("Alejandor")
                .apellidos("asd")
                .correo("asdas")
                .cedula("sda")
                .usuario("asd").build();
        dtos.add(dto);

        JRDataSource dataSource = new JRBeanCollectionDataSource(dtos);



        String contentType = null;
        if (format == ExportFormat.PDF) contentType = "application/pdf";
        else if (format == ExportFormat.XLSX)
            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        byte[] bytes = reportService.generatePDFReport(format, "user", params, dataSource);

        myStream = new ByteArrayInputStream(bytes);

        response.addHeader("Content-disposition", String.format("attachment;filename=%s.pdf", "ejemplo"));
        response.setContentType("application/pdf");
        try {
            IOUtils.copy(myStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            throw new RuntimeException("Error generando la respuesta http.");
        }
    }


}
