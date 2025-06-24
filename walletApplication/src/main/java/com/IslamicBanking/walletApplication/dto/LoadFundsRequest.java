package com.IslamicBanking.walletApplication.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoadFundsRequest {
        private Long userId;
        private BigDecimal amount;
        private String description;
    }

