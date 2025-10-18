package com.xprofit.service;

import com.xprofit.dto.ClienteDTO;
import com.xprofit.exception.ClienteNotFoundException;
import com.xprofit.model.entity.Cliente;
import com.xprofit.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = dto.toEntity();
        Cliente salvo = clienteRepository.save(cliente);
        return ClienteDTO.fromEntity(salvo);
    }

    @Override
    public ClienteDTO buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(ClienteDTO::fromEntity)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com id: " + id));
    }

    @Override
    public List<ClienteDTO> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(ClienteDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com id: " + id));

        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setCpf(new com.xprofit.vo.CpfVO(dto.getCpf()));
        cliente.setSaldo(dto.getSaldo() != null ? BigDecimal.valueOf(dto.getSaldo()) : null); // ✅ conversão aqui

        Cliente atualizado = clienteRepository.save(cliente);
        return ClienteDTO.fromEntity(atualizado);
    }


    @Override
    public void deletar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado com id: " + id));
        clienteRepository.delete(cliente);
    }
}
