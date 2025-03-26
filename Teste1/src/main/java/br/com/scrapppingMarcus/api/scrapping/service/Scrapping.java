package br.com.scrapppingMarcus.api.scrapping.service;

import java.io.IOException;
import java.util.List;

public interface Scrapping {

    List<String> getPdfLinks(String url) throws IOException;
}
