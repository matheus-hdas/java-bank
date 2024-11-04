package com.matheushdas.javabank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_deposit")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @Column(name = "deposit_value")
    private BigDecimal depositValue;

    @Column(name = "deposit_timestamp")
    private LocalDateTime depositTimestamp;

    @Column(name = "ip_address")
    private String ipAddress;
}
