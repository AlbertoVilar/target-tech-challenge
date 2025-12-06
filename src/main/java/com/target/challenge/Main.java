package com.target.challenge;

import com.target.challenge.application.dtos.SellerDTO;
import com.target.challenge.services.CommissionService;
import com.target.challenge.util.JsonReader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        JsonReader reader = new JsonReader();
        CommissionService service = new CommissionService(reader);

        List<SellerDTO> result = service.loadSales();

        for (SellerDTO dto : result) {
            System.out.println("Vendedor: " + dto.sellerName());
            System.out.println("Total de vendas: R$ " + dto.totalSales());
            System.out.println("Taxa de comissão: " + dto.commissionRate());
            System.out.println("Comissão gerada: R$ " + dto.commission());
            System.out.println("------------------------------");
        }
    }
}
