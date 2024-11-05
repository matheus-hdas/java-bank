package com.matheushdas.javabank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CreateWalletDTO(@CPF @NotBlank String cpf,
                              @Email @NotBlank String email,
                              @NotBlank String name) {
}
