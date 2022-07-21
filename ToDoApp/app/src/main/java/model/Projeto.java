/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
import java.util.List;
/**
 *
 * @author raian
 */
public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private List<Tarefa> tarefas;
    private Date criacaodata;
    private Date atualizacaodata;    

    public Projeto(int id, String nome, String descricao, List<Tarefa> tarefas, Date criacaodata, Date atualizacaodata) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.tarefas = tarefas;
        this.criacaodata = criacaodata;
        this.atualizacaodata = atualizacaodata;
    }
      public Projeto() {
        this.criacaodata = new Date();
        this.atualizacaodata = new Date();
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        return this.nome;
    }
    
    
}
