package com.horustek.gda.infra.utils.reports;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Configuration
@PropertySource("classpath:reports.properties")
@ConfigurationProperties("report")
@Validated
public class ReportsProperties {

    /**
     * The base path where reports will be stored after compilation
     */
    @NotNull
    private Resource storageLocation;
    /**
     * The location of JasperReports source files
     */
    @NotNull
    private Resource reportLocation;
}
