package com.matheushdas.javabank.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_deposit")
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

    public Deposit() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public BigDecimal getDepositValue() {
        return depositValue;
    }

    public void setDepositValue(BigDecimal depositValue) {
        this.depositValue = depositValue;
    }

    public LocalDateTime getDepositTimestamp() {
        return depositTimestamp;
    }

    public void setDepositTimestamp(LocalDateTime depositTimestamp) {
        this.depositTimestamp = depositTimestamp;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deposit deposit = (Deposit) o;
        return Objects.equals(id, deposit.id) &&
                Objects.equals(wallet, deposit.wallet) &&
                Objects.equals(depositValue, deposit.depositValue) &&
                Objects.equals(depositTimestamp, deposit.depositTimestamp) &&
                Objects.equals(ipAddress, deposit.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wallet, depositValue, depositTimestamp, ipAddress);
    }
}
