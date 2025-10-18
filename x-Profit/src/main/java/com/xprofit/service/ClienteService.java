package com.xprofit.service;

import com.xprofit.dto.ClienteDTO;
import java.util.List;

public interface ClienteService {
    ClienteDTO salvar(ClienteDTO dto);
    ClienteDTO buscarPorId(Long id);
    List<ClienteDTO> listarTodos();
    ClienteDTO atualizar(Long id, ClienteDTO dto);
    void deletar(Long id);
}
