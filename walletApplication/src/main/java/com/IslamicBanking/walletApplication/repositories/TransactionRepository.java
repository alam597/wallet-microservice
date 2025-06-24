package com.IslamicBanking.walletApplication.repositories;


import com.IslamicBanking.walletApplication.models.Transaction;
import com.IslamicBanking.walletApplication.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Find all transactions for a specific wallet
    List<Transaction> findByWallet(Wallet wallet);
}
