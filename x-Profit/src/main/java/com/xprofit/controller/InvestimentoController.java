package com.xprofit.controller;

import com.xprofit.dto.InvestimentoDTO;
import com.xprofit.service.InvestimentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
public class InvestimentoController {

    private final InvestimentoService investimentoService;

    public InvestimentoController(InvestimentoService investimentoService) {
        this.investimentoService = investimentoService;
    }

    @Operation(summary = "Criar novo investimento", description = "Registra um novo investimento no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Investimento criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "401", description = "Acesso não autorizado")
    })
    @PostMapping
    public ResponseEntity<InvestimentoDTO> criar(@Valid @RequestBody InvestimentoDTO dto) {
        return ResponseEntity.ok(investimentoService.salvar(dto));
    }

    @Operation(summary = "Buscar investimento por ID", description = "Retorna os detalhes de um investimento específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Investimento encontrado"),
            @ApiResponse(responseCode = "404", description = "Investimento não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<InvestimentoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(investimentoService.buscarPorId(id));
    }

    @Operation(summary = "Listar todos os investimentos", description = "Retorna uma lista de todos os investimentos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    public ResponseEntity<List<InvestimentoDTO>> listarTodos() {
        return ResponseEntity.ok(investimentoService.listarTodos());
    }

    @Operation(summary = "Atualizar investimento", description = "Atualiza os dados de um investimento existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Investimento atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Investimento não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<InvestimentoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody InvestimentoDTO dto) {
        return ResponseEntity.ok(investimentoService.atualizar(id, dto));
    }

    @Operation(summary = "Deletar investimento", description = "Remove um investimento com base em seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Investimento removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Investimento não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        investimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
