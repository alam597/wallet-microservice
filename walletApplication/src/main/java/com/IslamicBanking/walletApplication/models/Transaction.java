package com.IslamicBanking.walletApplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String type; // e.g., "CREDIT", "DEBIT"

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime transactionTime;

    @PrePersist
    public void prePersist() {
        this.transactionTime = LocalDateTime.now();
    }
}
