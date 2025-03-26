package br.com.scrapppingMarcus.api.scrapping.service;

import java.io.IOException;
import java.util.List;

public interface FileService {
    void downloadFile(String fileUrl, String outputPath) throws IOException;

    void zipFiles(List<String> filePaths, String zipFilePath) throws IOException;
}