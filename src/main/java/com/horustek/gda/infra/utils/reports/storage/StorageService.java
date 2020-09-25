package com.horustek.gda.infra.utils.reports.storage;

import java.io.File;

public interface StorageService {
    void init();

    void deleteAll();

    boolean jrxmlFileExists(String file);

    boolean jasperFileExists(String file);

    String loadJrxmlFile(String file);

    File loadJasperFile(String file);

}