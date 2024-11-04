package com.matheushdas.javabank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_wallet")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;
    private String name;
    private BigDecimal balance;
}
