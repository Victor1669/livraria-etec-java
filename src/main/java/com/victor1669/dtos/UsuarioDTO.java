package com.victor1669.dtos;

public class UsuarioDTO {

    private int id;
    private String nome;
    private String role;

    public UsuarioDTO() {
    }

    public UsuarioDTO(int id, String nome, String role) {
        this.id = id;
        this.nome = nome;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "id=" + id + ", nome=" + nome + ", role=" + role + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
