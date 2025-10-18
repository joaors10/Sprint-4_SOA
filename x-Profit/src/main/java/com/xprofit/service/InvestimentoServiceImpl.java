package com.xprofit.service;

import com.xprofit.dto.InvestimentoDTO;
import com.xprofit.model.entity.Cliente;
import com.xprofit.model.entity.Investimento;
import com.xprofit.repository.ClienteRepository;
import com.xprofit.repository.InvestimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvestimentoServiceImpl implements InvestimentoService {

    private final InvestimentoRepository investimentoRepository;
    private final ClienteRepository clienteRepository;

    public InvestimentoServiceImpl(InvestimentoRepository investimentoRepository, ClienteRepository clienteRepository) {
        this.investimentoRepository = investimentoRepository;
        this.clienteRepository = clienteRepository;
    }

    private InvestimentoDTO toDTO(Investimento entity) {
        return InvestimentoDTO.fromEntity(entity);
    }

    private Investimento toEntity(InvestimentoDTO dto) {
        Investimento investimento = dto.toEntity();
        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(dto.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + dto.getClienteId()));
            investimento.setCliente(cliente);
        }
        return investimento;
    }

    @Override
    public InvestimentoDTO salvar(InvestimentoDTO dto) {
        Investimento entity = toEntity(dto);
        Investimento salvo = investimentoRepository.save(entity);
        return toDTO(salvo);
    }

    @Override
    public InvestimentoDTO buscarPorId(Long id) {
        return investimentoRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado com id: " + id));
    }

    @Override
    public List<InvestimentoDTO> listarTodos() {
        return investimentoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InvestimentoDTO atualizar(Long id, InvestimentoDTO dto) {
        Investimento investimento = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado com id: " + id));

        investimento.setTipo(dto.getTipo());
        investimento.setValor(dto.getValor());

        if (dto.getClienteId() != null) {
            Cliente cliente = clienteRepository.findById(dto.getClienteId())
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado com id: " + dto.getClienteId()));
            investimento.setCliente(cliente);
        }

        Investimento atualizado = investimentoRepository.save(investimento);
        return toDTO(atualizado);
    }

    @Override
    public void deletar(Long id) {
        Investimento investimento = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado com id: " + id));
        investimentoRepository.delete(investimento);
    }
}
