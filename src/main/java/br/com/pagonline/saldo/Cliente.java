package br.com.pagonline.saldo;

import java.util.List;

public class Cliente {

    private String id;
    private String nome;
    private List<String> url;
    private String status;

    public Cliente() {
    }

    public Cliente(String id, String nome, List<String> url, String status) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
