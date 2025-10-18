package com.xprofit.dto;

import com.xprofit.model.entity.Cliente;
import com.xprofit.vo.CpfVO;

import java.math.BigDecimal;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private Double saldo; // ✅ Mantemos Double

    public ClienteDTO() {}

    public ClienteDTO(Long id, String nome, String email, String cpf, Double saldo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }

    // Conversão entidade -> DTO
    public static ClienteDTO fromEntity(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getCpf().getCpf(),
                cliente.getSaldo() != null ? cliente.getSaldo().doubleValue() : null // BigDecimal -> Double
        );
    }

    // Conversão DTO -> entidade
    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setCpf(new CpfVO(this.cpf));
        cliente.setSaldo(this.saldo != null ? BigDecimal.valueOf(this.saldo) : null); // Double -> BigDecimal
        return cliente;
    }
}
