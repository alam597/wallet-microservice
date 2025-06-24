package com.IslamicBanking.walletApplication.repositories;


import com.IslamicBanking.walletApplication.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    // Find wallet by userId (assuming one wallet per user)
    Optional<Wallet> findByUserId(Long userId);
}

