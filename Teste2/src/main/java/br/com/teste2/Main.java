package br.com.teste2;

import br.com.teste2.pdfparser.PdfExtractor;
import br.com.teste2.csv.CsvWriter;
import br.com.teste2.zip.ZipCompressor;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            String pdfFilePath = "C:\\Users\\Usuario\\Desktop\\nivelamento\\downloads\\AnexoI.pdf";
            String csvFilePath = "C:\\Users\\Usuario\\Desktop\\nivelamento\\Teste2\\extraction\\Rol_Procedimentos.csv";
            String zipFilePath = "C:\\Users\\Usuario\\Desktop\\nivelamento\\Teste2\\extraction\\Teste_Marcus.zip";

            PdfExtractor pdfExtractor = new PdfExtractor();
            List<String[]> data = pdfExtractor.extractData(pdfFilePath);

            Map<String, String> abbreviationsMap = new HashMap<>();
            abbreviationsMap.put("OD", "Outros Diagnósticos");
            abbreviationsMap.put("AMB", "Ambulatorial");

            CsvWriter csvWriter = new CsvWriter();
            csvWriter.writeDataToCsv(data, csvFilePath, abbreviationsMap);

            ZipCompressor zipCompressor = new ZipCompressor();
            zipCompressor.compressToZip(csvFilePath, zipFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
