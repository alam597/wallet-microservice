package com.IslamicBanking.walletApplication.Services;

import com.IslamicBanking.walletApplication.models.Transaction;
import com.IslamicBanking.walletApplication.models.Wallet;

import java.math.BigDecimal;
import java.util.List;


public interface WalletService {
    BigDecimal getWalletBalance(Long userId);
    Wallet loadFunds(Long userId, BigDecimal amount, String description);
    List<Transaction> getTransactionHistory(Long userId);
}

