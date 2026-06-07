package com.escola.api.service;

import com.escola.api.dto.AlunoNotaRequestDTO;
import com.escola.api.dto.DataHoraResponseDTO;
import com.escola.api.dto.MediaResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@Service
public class EscolaService {

    private static final double NOTA_CORTE = 5.0;

    public MediaResponseDTO calcularMedia(AlunoNotaRequestDTO request) {
        String nome = request.getNome();
        double nota1 = request.getNota1();
        double nota2 = request.getNota2();

        double media = (nota1 + nota2) / 2.0;

        String situacao;
        String mensagem;

        if (media > NOTA_CORTE) {
            situacao = "APROVADO";
            mensagem = "Parabéns " + nome + ", você foi aprovado.";
        } else if (media < NOTA_CORTE) {
            situacao = "REPROVADO";
            mensagem = nome + ", você foi reprovado.";
        } else {
            situacao = "REPROVADO";
            mensagem = nome + ", você não atingiu a nota de corte e foi reprovado.";
        }

        return new MediaResponseDTO(nome, nota1, nota2, media, situacao, mensagem);
    }

    public DataHoraResponseDTO obterDataHoraLocal() {
        ZoneId zonaLocal = ZoneId.systemDefault();
        LocalDateTime agora = LocalDateTime.now(zonaLocal);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);

        String diaSemana = agora.getDayOfWeek()
                .getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));

        return new DataHoraResponseDTO(dataHoraFormatada, zonaLocal.toString(), diaSemana);
    }
}
