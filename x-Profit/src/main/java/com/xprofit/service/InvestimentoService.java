package com.xprofit.service;

import com.xprofit.dto.InvestimentoDTO;
import java.util.List;

public interface InvestimentoService {
    InvestimentoDTO salvar(InvestimentoDTO dto);
    InvestimentoDTO buscarPorId(Long id);
    List<InvestimentoDTO> listarTodos();
    InvestimentoDTO atualizar(Long id, InvestimentoDTO dto);
    void deletar(Long id);
}
