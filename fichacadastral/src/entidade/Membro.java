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
    private int id_dados_pessoais;
    private String endereco;
    private String cargo;
    private String data_afiliacao;
    private String dizimo;
    private String observacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_dados_pessoais() {
        return id_dados_pessoais;
    }

    public void setId_dados_pessoais(int id_dados_pessoais) {
        this.id_dados_pessoais = id_dados_pessoais;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getData_afiliacao() {
        return data_afiliacao;
    }

    public void setData_afiliacao(String data_afiliacao) {
        this.data_afiliacao = data_afiliacao;
    }

    public String getDizimo() {
        return dizimo;
    }

    public void setDizimo(String dizimo) {
        this.dizimo = dizimo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}