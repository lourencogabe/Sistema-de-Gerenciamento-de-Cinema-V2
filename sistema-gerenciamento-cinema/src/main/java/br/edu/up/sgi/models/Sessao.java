package br.edu.up.sgi.models;

public class Sessao {
    private int codigoSessao;
    private int quantidadeSessao;
    private String dataSessao;

    public Sessao() {
    }

    public int getCodigoSessao() {
        return codigoSessao;
    }

    public void setCodigoSessao(int codigoSessao) {
        this.codigoSessao = codigoSessao;
    }

    public int getQuantidadeSessao() {
        return quantidadeSessao;
    }

    public void setQuantidadeSessao(int quantidadeSessao) {
        this.quantidadeSessao = quantidadeSessao;
    }

    public String getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(String dataSessao) {
        this.dataSessao = dataSessao;
    }

    @Override
    public String toString() {
        return "Sessao{" +
                "codigoSessao=" + codigoSessao +
                ", quantidadeSessao=" + quantidadeSessao +
                ", dataSessao='" + dataSessao + '\'' +
                '}';
    }
}
