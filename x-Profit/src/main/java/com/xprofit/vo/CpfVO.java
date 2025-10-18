package com.xprofit.vo;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class CpfVO {

    @Pattern(regexp = "\\d{11}", message = "CPF deve ter 11 dígitos numéricos")
    private String cpf;

    public CpfVO() {}

    public CpfVO(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // ✅ Métodos utilitários corrigidos
    public String getValor() {
        return cpf;
    }

    public String getNumero() {
        return cpf;
    }

    @Override
    public String toString() {
        return cpf;
    }
}
