package br.com.scrapppingMarcus.impl.scrapping.service;

import br.com.scrapppingMarcus.api.scrapping.service.Scraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ScrappingService implements Scraper {

    @Override
    public List<String> getPdfLinks(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        List<String> selectors = Arrays.asList(
                "#cfec435d-6921-461f-b85a-b425bc3cb4a5 > div > ol > li:nth-child(1) > a:nth-child(1)",
                "#cfec435d-6921-461f-b85a-b425bc3cb4a5 > div > ol > li:nth-child(2) > a"
        );

        return selectors.stream()
                .map(doc::select)
                .map(elements -> elements.first())
                .filter(Objects::nonNull)
                .map(element -> element.attr("href"))
                .collect(Collectors.toList());
    }
}
