package br.com.scrapppingMarcus;

import br.com.scrapppingMarcus.api.scrapping.service.FileService;
import br.com.scrapppingMarcus.api.scrapping.service.Scrapping;
import br.com.scrapppingMarcus.impl.scrapping.service.FileServiceImpl;
import br.com.scrapppingMarcus.impl.scrapping.service.ScrappingService;
import br.com.scrapppingMarcus.constants.UrlConstants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scrapping scrapping = new ScrappingService();
        FileService fileService = new FileServiceImpl();

        try {
            Files.createDirectories(Paths.get("downloads"));

            List<String> pdfLinks = scrapping.getPdfLinks(UrlConstants.BASE_URL);
            System.out.println("Links dos PDFs encontrados:");
            pdfLinks.forEach(System.out::println);

            List<String> pdfFiles = List.of(
                    Paths.get("downloads", "AnexoI.pdf").toString(),
                    Paths.get("downloads", "AnexoII.pdf").toString()
            );

            fileService.downloadFile(pdfLinks.get(0), pdfFiles.get(0));
            System.out.println("Arquivo " + pdfFiles.get(0) + " baixado com sucesso.");

            fileService.downloadFile(pdfLinks.get(1), pdfFiles.get(1));
            System.out.println("Arquivo " + pdfFiles.get(1) + " baixado com sucesso.");


            fileService.zipFiles(pdfFiles, "downloads/arquivos.zip");

            System.out.println("Arquivos compactados com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
