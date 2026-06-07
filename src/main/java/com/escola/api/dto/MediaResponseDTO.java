package com.escola.api.dto;

public class MediaResponseDTO {

    private String nome;
    private Double nota1;
    private Double nota2;
    private Double media;
    private String situacao;
    private String mensagem;

    public MediaResponseDTO(String nome, Double nota1, Double nota2, Double media,
                             String situacao, String mensagem) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = media;
        this.situacao = situacao;
        this.mensagem = mensagem;
    }

    public String getNome() { return nome; }
    public Double getNota1() { return nota1; }
    public Double getNota2() { return nota2; }
    public Double getMedia() { return media; }
    public String getSituacao() { return situacao; }
    public String getMensagem() { return mensagem; }
}
