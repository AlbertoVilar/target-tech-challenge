package com.target.challenge.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.challenge.model.Sale;
import com.target.challenge.model.SalesWrapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    public static List<Sale> readSales(String filePath) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        SalesWrapper wrapper = objectMapper.readValue(
                new File(filePath), SalesWrapper.class);

        return wrapper.getVendas();
    }
}
