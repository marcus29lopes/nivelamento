package br.com.teste2.pdfparser;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PdfExtractor {

    public List<String[]> extractData(String pdfFilePath) throws IOException {
        PDDocument document = PDDocument.load(new File(pdfFilePath));
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        document.close();

        List<String[]> data = new ArrayList<>();
        String[] lines = text.split("\n");
        for (String line : lines) {
            String[] columns = line.split("\\s+");
            data.add(columns);
        }
        return data;
    }
}
