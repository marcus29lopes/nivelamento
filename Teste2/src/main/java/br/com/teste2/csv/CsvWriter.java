package br.com.teste2.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvWriter {

    public void writeDataToCsv(List<String[]> data, String csvFilePath, Map<String, String> abbreviationsMap) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath));

        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                if (abbreviationsMap.containsKey(row[i])) {
                    row[i] = abbreviationsMap.get(row[i]);
                }
            }
            writer.write(String.join(",", row));
            writer.newLine();
        }
        writer.close();
    }
}
