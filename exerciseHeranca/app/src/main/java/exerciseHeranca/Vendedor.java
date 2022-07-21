/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exerciseHeranca;

import java.util.Date;

/**
 *
 * @author raian
 */
public class Vendedor extends Funcionario{
    private int totalitensvendidos;
    private float comissaoporvenda;
    
    
    public Vendedor(){  
        super();
    }
    
    public float calcularSalario(){
        return super.getSalario() + 
                (this.comissaoporvenda * this.totalitensvendidos);
    }

    public int getTotalitensvendidos() {
        return totalitensvendidos;
    }

    public void setTotalitensvendidos(int totalitensvendidos) {
        this.totalitensvendidos = totalitensvendidos;
    }

    public float getComissaoporvenda() {
        return comissaoporvenda;
    }

    public void setComissaoporvenda(float comissaoporvenda) {
        this.comissaoporvenda = comissaoporvenda;
    }
}
