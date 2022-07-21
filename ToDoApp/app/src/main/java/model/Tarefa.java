/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author raian
 */
public class Tarefa {
    private int id;
    private int idprojeto;
    private String nome;
    private String descricao;
    private String observacao;
    private Date prazo;
    private boolean iscompleted;
    private Date criacaodata;
    private Date atualizacaodata;

    public Tarefa(int id, int idprojeto, String nome,  String descricao,  String obersevacao, Date prazo, boolean iscompleted, Date criacaodata, Date atualizacaodata) {
        this.id = id;
        this.idprojeto = idprojeto;
        this.nome = nome;
        this.descricao = descricao;
        this.observacao = obersevacao;
        this.prazo = prazo;
        this.iscompleted = iscompleted;
        this.criacaodata = criacaodata;
        this.atualizacaodata = atualizacaodata;
    }
    // segundo construtor onde indicar que a data de criação será quando a tarefa foi criado 
    public Tarefa(){
        this.criacaodata = new Date();
        this.atualizacaodata = new Date();
        this.iscompleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdprojeto() {
        return idprojeto;
    }

    public void setIdprojeto(int idprojeto) {
        this.idprojeto = idprojeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getPrazo() {
        return prazo;
    }

    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }



    public Date getCriacaodata() {
        return criacaodata;
    }

    public void setCriacaodata(Date criacaodata) {
        this.criacaodata = criacaodata;
    }

    public Date getAtualizacaodata() {
        return atualizacaodata;
    }

    public void setAtualizacaodata(Date atualizacaodata) {
        this.atualizacaodata = atualizacaodata;
    }

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", idprojeto=" + idprojeto + 
                ", nome=" + nome + ", descricao=" + descricao + 
                ", iscompleted" + iscompleted + ", obersevacao=" + observacao + 
                ", prazo=" + prazo + ", criacaodata=" + criacaodata + 
                ", atualizacaodata=" + atualizacaodata + '}';
    }

  
}
