/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IMCwithClass;

/**
 *
 * @author raian
 */
public class Pessoa {
    
    private double peso;  // private seria o encapsulamento, dessa forma apenas a classe pode modificar esses dados
    private  double altura;
    
    //Metodo constructor 
    public Pessoa(double peso, double altura){
        this.peso = peso;
        this.altura = altura;
        
    }
           
    public double calcularIMC(){
        double imc = peso/(Math.pow(altura, 2.0));
        return imc;
    }
    
    // Metodos acessores 
    
    public void setPeso(double peso){
        this.peso = peso;
    }
    
    public double getPeso(){
        return peso;
    }
    
     public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getAltura(){
        return altura;
    }
}
