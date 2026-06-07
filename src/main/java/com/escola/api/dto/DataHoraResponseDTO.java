package com.escola.api.dto;

public class DataHoraResponseDTO {

    private String dataHoraLocal;
    private String fuso;
    private String diaSemana;

    public DataHoraResponseDTO(String dataHoraLocal, String fuso, String diaSemana) {
        this.dataHoraLocal = dataHoraLocal;
        this.fuso = fuso;
        this.diaSemana = diaSemana;
    }

    public String getDataHoraLocal() { return dataHoraLocal; }
    public String getFuso() { return fuso; }
    public String getDiaSemana() { return diaSemana; }
}
