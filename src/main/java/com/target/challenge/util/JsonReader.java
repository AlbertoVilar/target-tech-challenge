package com.target.challenge.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.challenge.model.Sale;
import com.target.challenge.model.SalesWrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    private final File filePath = new File("C:\\Desafio Tecnicos\\alberto\\target-tech-challenge\\src\\main\\resources\\sales.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Sale> readSales() throws IOException {
        SalesWrapper wrapper = objectMapper.readValue(filePath, SalesWrapper.class);
        return wrapper.getVendas();
    }
}
