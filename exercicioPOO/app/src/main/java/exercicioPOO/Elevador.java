/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicioPOO;

/**
 *
 * @author raian
 */
public class Elevador {
  private int andarAtual = 0;
    private int totalAndares;
    private int capacidadeTotal;
    private int quantidadePessoas = 0;
    
    public void iniciar(int capacidadeTotal , int totalAndares){
       this.capacidadeTotal = capacidadeTotal;
       this.totalAndares = totalAndares;
    }
       public void entrarElevador(){
           if(quantidadePessoas >= capacidadeTotal){
               System.out.println("Capacidade máxima permitida! Espere");
           }else{
               System.out.println("Ok,entre!");
               this.quantidadePessoas++;
           }
       }
       
              public void sairElevador(){
           if(quantidadePessoas <= 0){
               System.out.println("Não há ninguém no elevador");
           }else{
               System.out.println("Ok, uma pessoa saiu do elevador!");
               this.quantidadePessoas--;
           }
       }
              
              public void subirAndar(){
                  if(andarAtual >= totalAndares){
                      System.out.println("Estamos no último andar!");
                  }
                      else{
                             System.out.println("Ok, subindo um andar!");
                             this.andarAtual++;
                              }
                  }
              
              public void descerAndar(){
                  if(andarAtual <= 0){
                      System.out.println("Estamos no térreo!");
                  }
                      else{
                             System.out.println("Ok, descendo um andar!");
                             this.andarAtual--;
                              }
                  }
              
      
    public Elevador(){
        
    }
    

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        if(andarAtual<0){                                //validações 
            this.andarAtual = 0;
        } else{
        this.andarAtual = andarAtual;
    }
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(int capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }
    
    
}
