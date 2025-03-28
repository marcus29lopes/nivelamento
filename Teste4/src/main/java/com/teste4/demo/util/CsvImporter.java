package com.teste4.demo.util;

import com.opencsv.exceptions.CsvException;
import com.teste4.demo.model.Operadora;
import com.teste4.demo.repository.OperadoraRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class CsvImporter {

    @Autowired
    private OperadoraRepository operadoraRepository;

    public void importarCsv(String caminhoCsv) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(caminhoCsv))) {
            List<String[]> registros = reader.readAll();
            for (String[] registro : registros) {
                Operadora operadora = new Operadora(
                        Long.parseLong(registro[0]),
                        registro[1],
                        registro[2],
                        registro[3]);
                operadoraRepository.save(operadora);
            }
        }
    }
}
