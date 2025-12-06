package com.target.challenge.services;

import com.target.challenge.application.dtos.SellerDTO;
import com.target.challenge.model.Sale;
import com.target.challenge.util.JsonReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommissionService {

    private final JsonReader jsonReader;

    public CommissionService(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    public List<SellerDTO> loadSales() throws IOException {

        // 1. Lê todas as vendas do JSON
        List<Sale> sales = jsonReader.readSales();

        // 2. Agrupa o total de vendas por vendedor
        Map<String, BigDecimal> totals = groupSales(sales);

        // 3. Calcula a comissão de cada vendedor e devolve os DTOs
        return calculateCommission(totals);
    }



    private Map<String, BigDecimal> groupSales(List<Sale> sales) {

        Map<String, BigDecimal> groupedSales = new HashMap<>();

        for (Sale sale : sales) {
            String sellerName = sale.getSellerName();
            BigDecimal value = sale.getValue();

            if (groupedSales.get(sellerName) == null) {
                groupedSales.put(sellerName, value);
            } else {
                groupedSales.put(sellerName, groupedSales.get(sellerName).add(value));
            }
        }

        return groupedSales;
    }

    private List<SellerDTO> calculateCommission(Map<String, BigDecimal> totals) {

        List<SellerDTO> result = new ArrayList<>();

        for (Map.Entry<String, BigDecimal> entry : totals.entrySet()) {

            String seller = entry.getKey();
            BigDecimal totalSales = entry.getValue();

            BigDecimal rate;

            if (totalSales.compareTo(BigDecimal.valueOf(100)) < 0) {
                rate = BigDecimal.ZERO;
            } else if (totalSales.compareTo(BigDecimal.valueOf(500)) < 0) {
                rate = BigDecimal.valueOf(0.01);
            } else {
                rate = BigDecimal.valueOf(0.05);
            }

            BigDecimal commission = totalSales.multiply(rate);

            result.add(new SellerDTO(
                    seller,
                    totalSales,
                    commission,
                    rate

            ));
        }

        return result;
    }

}



