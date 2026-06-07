package com.escola.api.controller;

import com.escola.api.dto.AlunoNotaRequestDTO;
import com.escola.api.dto.DataHoraResponseDTO;
import com.escola.api.dto.MediaResponseDTO;
import com.escola.api.service.EscolaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/escola")
public class EscolaController {

    private final EscolaService escolaService;

    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @PostMapping("/calcular-media")
    public ResponseEntity<MediaResponseDTO> calcularMedia(
            @Valid @RequestBody AlunoNotaRequestDTO request) {

        MediaResponseDTO response = escolaService.calcularMedia(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/data-hora")
    public ResponseEntity<DataHoraResponseDTO> obterDataHora() {
        DataHoraResponseDTO response = escolaService.obterDataHoraLocal();
        return ResponseEntity.ok(response);
    }
}
