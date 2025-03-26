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

            for (int i = 0; i < pdfLinks.size(); i++) {
                String outputPath = Paths.get("downloads", "Anexo" + (i+1) + ".pdf").toString();
                fileService.downloadFile(pdfLinks.get(i), outputPath);
                System.out.println("Arquivo " + outputPath + " baixado com sucesso.");
            }

            List<String> pdfFiles = List.of(
                    Paths.get("downloads", "anexo1.pdf").toString(),
                    Paths.get("downloads", "anexo2.pdf").toString()
            );
            fileService.zipFiles(pdfFiles, "downloads/arquivos.zip");

            System.out.println("Arquivos compactados com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
