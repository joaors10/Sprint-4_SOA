package com.xprofit.dto;

import com.xprofit.model.entity.Investimento;

import java.math.BigDecimal;

public class InvestimentoDTO {
    private Long id;
    private String tipo;
    private BigDecimal valor;
    private Long clienteId; // 🔹 novo campo

    // Construtores
    public InvestimentoDTO() {}

    public InvestimentoDTO(Long id, String tipo, BigDecimal valor, Long clienteId) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.clienteId = clienteId;
    }

    // Conversão Entidade -> DTO
    public static InvestimentoDTO fromEntity(Investimento investimento) {
        return new InvestimentoDTO(
                investimento.getId(),
                investimento.getTipo(),
                investimento.getValor(),
                investimento.getCliente() != null ? investimento.getCliente().getId() : null
        );
    }

    // Conversão DTO -> Entidade
    public Investimento toEntity() {
        Investimento investimento = new Investimento();
        investimento.setId(this.id);
        investimento.setTipo(this.tipo);
        investimento.setValor(this.valor);
        // o cliente será setado no service usando clienteRepository
        return investimento;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
}
