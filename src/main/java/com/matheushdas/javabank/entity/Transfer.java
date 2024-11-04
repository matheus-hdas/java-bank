package com.matheushdas.javabank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet receiver;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet sender;

    @Column(name = "transfer_value")
    private BigDecimal transferValue;

    @Column(name = "transfer_timestamp")
    private LocalDateTime transferTimestamp;
}
