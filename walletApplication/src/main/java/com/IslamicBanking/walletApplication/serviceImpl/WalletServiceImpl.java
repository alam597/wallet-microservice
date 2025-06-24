package com.IslamicBanking.walletApplication.serviceImpl;

import com.IslamicBanking.walletApplication.Services.WalletService;
import com.IslamicBanking.walletApplication.models.Transaction;
import com.IslamicBanking.walletApplication.models.Wallet;
import com.IslamicBanking.walletApplication.repositories.TransactionRepository;
import com.IslamicBanking.walletApplication.repositories.WalletRepository;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public BigDecimal getWalletBalance(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found for userId: " + userId));
        return wallet.getBalance();
    }

    @Override
    @Transactional
    public Wallet loadFunds(Long userId, BigDecimal amount, String description) {
        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found for userId: " + userId));

        wallet.setBalance(wallet.getBalance().add(amount));
        walletRepository.save(wallet);

        Transaction txn = Transaction.builder()
                .wallet(wallet)
                .amount(amount)
                .type("CREDIT")
                .description(description != null ? description : "Funds Loaded")
                .build();

        transactionRepository.save(txn);

        return wallet;
    }

    @Override
    public List<Transaction> getTransactionHistory(Long userId) {
        Wallet wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Wallet not found for userId: " + userId));
        return transactionRepository.findByWallet(wallet);
    }
}
