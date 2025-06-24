package com.IslamicBanking.walletApplication.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class WalletResponseDTO {
    private Long userId;
    private BigDecimal balance;
}
