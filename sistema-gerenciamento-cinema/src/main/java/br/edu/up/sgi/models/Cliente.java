package br.edu.up.sgi.models;

public class Cliente {
    private String nomeCliente;
    private String documentoCliente;
    public int idadeCliente;
    public String contatoCliente;

    public Cliente() {
    }

    public Cliente(String nomeCliente, String documentoCliente, int idadeCliente, String contatoCliente) {
        this.nomeCliente = nomeCliente;
        this.documentoCliente = documentoCliente;
        this.idadeCliente = idadeCliente;
        this.contatoCliente = contatoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public int getIdadeCliente() {
        return idadeCliente;
    }

    public void setIdadeCliente(int idadeCliente) {
        this.idadeCliente = idadeCliente;
    }

    public String getContatoCliente() {
        return contatoCliente;
    }

    public void setContatoCliente(String contatoCliente) {
        this.contatoCliente = contatoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", documentoCliente='" + documentoCliente + '\'' +
                ", idadeCliente=" + idadeCliente +
                ", contatoCliente='" + contatoCliente + '\'' +
                '}';
    }
}
