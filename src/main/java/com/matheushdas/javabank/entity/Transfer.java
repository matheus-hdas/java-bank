package com.matheushdas.javabank.entity;

import com.matheushdas.javabank.filter.IpFilter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_transfer")
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

    public Transfer() {}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Wallet getReceiver() {
        return receiver;
    }

    public void setReceiver(Wallet receiver) {
        this.receiver = receiver;
    }

    public Wallet getSender() {
        return sender;
    }

    public void setSender(Wallet sender) {
        this.sender = sender;
    }

    public BigDecimal getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(BigDecimal transferValue) {
        this.transferValue = transferValue;
    }

    public LocalDateTime getTransferTimestamp() {
        return transferTimestamp;
    }

    public void setTransferTimestamp(LocalDateTime transferTimestamp) {
        this.transferTimestamp = transferTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return Objects.equals(id, transfer.id) &&
                Objects.equals(receiver, transfer.receiver) &&
                Objects.equals(sender, transfer.sender) &&
                Objects.equals(transferValue, transfer.transferValue) &&
                Objects.equals(transferTimestamp, transfer.transferTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, receiver, sender, transferValue, transferTimestamp);
    }
}
