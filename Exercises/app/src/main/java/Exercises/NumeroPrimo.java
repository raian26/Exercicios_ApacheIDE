/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercises;
import java.util.Scanner;
/**
 *
 * @author raian
 */
public class NumeroPrimo {
    
     public static void numeroPrimo() {
        Scanner leitor = new Scanner(System.in);
        int numero;
        String res;
        System.out.println("Olá digite um número para verificarmos se ele é primo");
        numero = leitor.nextInt();
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) {
                    res = "O número " + numero + " não é primo!";
                    System.out.println(res);
                    break;
     
                }
            else{   res = "O número " + numero + " é primo!";
            System.out.println(res);
            break;}             
        } 
            
        }
    }
