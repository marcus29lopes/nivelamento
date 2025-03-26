package br.com.scrapppingMarcus.impl.scrapping.service;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.*;
import java.util.List;

public class FileServiceImpl implements br.com.scrapppingMarcus.api.scrapping.service.FileService {

    @Override
    public void downloadFile(String fileUrl, String outputPath) throws IOException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(fileUrl))
                .build();

        try (InputStream in = client.send(request, HttpResponse.BodyHandlers.ofInputStream()).body()) {
            Files.copy(in, Paths.get(outputPath), StandardCopyOption.REPLACE_EXISTING);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void zipFiles(List<String> filePaths, String zipFilePath) throws IOException {
        try (ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(Paths.get(zipFilePath).toFile())) {
            for (String filePath : filePaths) {
                Path path = Paths.get(filePath);
                try (InputStream fileIn = Files.newInputStream(path)) {
                    ZipArchiveEntry entry = new ZipArchiveEntry(path.toFile(), path.getFileName().toString());
                    zipOut.putArchiveEntry(entry);
                    fileIn.transferTo(zipOut);
                    zipOut.closeArchiveEntry();
                }
            }
            zipOut.finish();
        }
    }
}