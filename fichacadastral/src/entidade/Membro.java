/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

/**
 *
 * @author felip
 */
public class Membro {
    private int id;
    private String nome;
    private String nascimento;
    private String bairro;
    private String cidade;
    private String estado;
    private int telefone;
    private String estado_civil;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }
}
