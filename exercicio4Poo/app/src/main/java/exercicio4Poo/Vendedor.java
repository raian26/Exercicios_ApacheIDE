/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicio4Poo;

/**
 *
 * @author raian
 */
public class Vendedor {
    String nome;
    float salarioVendedor;
    float totalVendas;
   
    public Vendedor(){
       
   }
    public float calcularSalario(){
        float salarioFinal = salarioVendedor + (totalVendas *0.15f);
        return salarioFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalarioVendedor() {
        return salarioVendedor;
    }

    public void setSalarioVendedor(float salarioVendedor) {
        this.salarioVendedor = salarioVendedor;
    }

    public float getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(float totalVendas) {
        this.totalVendas = totalVendas;
    }
}
