/*
 * This Java source file was generated by the Gradle 'init' task.

4. Crie uma classe denominada Elevador para armazenar as informações de um elevador dentro de um 
prédio. A classe deve armazenar o andar atual (térreo = 0), total de andares no prédio (desconsiderando o 
térreo), capacidade do elevador e quantas pessoas estão presentes nele. A classe deve também 
disponibilizar os seguintes métodos: 
a. Inicializa: que deve receber como parâmetros a capacidade do elevador e o total de andares no 
prédio (os elevadores sempre começam no térreo e vazio);
b. Entra: para acrescentar uma pessoa no elevador (só deve acrescentar se ainda houver espaço);
c. Sai: para remover uma pessoa do elevador (só deve remover se houver alguém dentro dele);
d. Sobe: para subir um andar (não deve subir se já estiver no último andar);
e. Desce: para descer um andar (não deve descer se já estiver no térreo);
 */
package exercicioPOO;
import java.util.Scanner;
public class App {
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
    Elevador elevador1 = new Elevador();
    
        System.out.println("Olá primeiro me informe quantos andares o elevador"
                + " tem, sem contar o térreo:");
        elevador1.setTotalAndares(leitor.nextInt());
        
        System.out.println("Agora me informe qual a capacidade de pessoas:");
        elevador1.setCapacidadeTotal(leitor.nextInt());
        int aux = 1;
        while(aux !=6){
            System.out.println("***MENU***");
            System.out.println("""
                               Digite a opção: 
                               1-Inicializar 
                               2-Entrar uma pessoa no elevador 
                               3-Sair uma pessoa do elevador 
                               4-Subir um andar
                               5-Descer um andar 
                               6-Sair do Menu""");
            aux = leitor.nextInt();
            switch(aux){
                case (1)->{ elevador1.iniciar(elevador1.getCapacidadeTotal(), elevador1.getTotalAndares());
                System.out.println("Elevador inicializado");
                break;
                }
                case (2) ->{ elevador1.entrarElevador();
                break;
                }
                case (3) ->{ elevador1.sairElevador();
                break;
                }
                case (4) -> {elevador1.subirAndar();
                break;
                }
                case (5) -> {elevador1.descerAndar();
                break;
                }
                case (6) -> {System.out.println("Até mais!");
                break;
                }
                default -> {System.out.println("Opção inválida!");
                break;
                }
            }
        }
        
        
    }
    
    
}
