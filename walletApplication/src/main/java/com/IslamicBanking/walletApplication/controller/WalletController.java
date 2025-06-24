package com.IslamicBanking.walletApplication.controller;

import com.IslamicBanking.walletApplication.Services.WalletService;
import com.IslamicBanking.walletApplication.dto.LoadFundsRequest;
import com.IslamicBanking.walletApplication.dto.WalletResponseDTO;
import com.IslamicBanking.walletApplication.models.Transaction;
import com.IslamicBanking.walletApplication.models.Wallet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    // GET /wallet/balance?userId=1
    @GetMapping("/balance")
    public ResponseEntity<BigDecimal> getBalance(@RequestParam Long userId) {
        BigDecimal balance = walletService.getWalletBalance(userId);
        return ResponseEntity.ok(balance);
    }

    // POST /wallet/load
    @PostMapping("/load")
    public ResponseEntity<WalletResponseDTO> loadFunds(@RequestBody LoadFundsRequest request) {
        Wallet wallet = walletService.loadFunds(request.getUserId(), request.getAmount(), request.getDescription());

        WalletResponseDTO response = WalletResponseDTO.builder()
                .userId(wallet.getUserId())
                .balance(wallet.getBalance())
                .build();

        return ResponseEntity.ok(response);
    }

    // GET /wallet/transactions?userId=1
    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam Long userId) {
        List<Transaction> transactions = walletService.getTransactionHistory(userId);
        return ResponseEntity.ok(transactions);
    }
}

