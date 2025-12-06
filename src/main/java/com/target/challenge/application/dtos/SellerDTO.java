package com.target.challenge.application.dtos;

import java.math.BigDecimal;

public record SellerDTO(
        String sellerName,
        BigDecimal totalSales,
        BigDecimal commission,
        BigDecimal commissionRate

) {}
