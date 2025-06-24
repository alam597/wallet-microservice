package com.IslamicBanking.walletApplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "wallets")
public class Wallet {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private Long userId; // Assuming one wallet per user

        @Column(nullable = false)
        private BigDecimal balance;

        @Column(nullable = false)
        private LocalDateTime createdAt;

        @OneToMany(mappedBy = "wallet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Transaction> transactions;

        @PrePersist
        public void prePersist() {
            this.createdAt = LocalDateTime.now();
            if (this.balance == null) {
                this.balance = BigDecimal.ZERO;
            }
        }
    }


