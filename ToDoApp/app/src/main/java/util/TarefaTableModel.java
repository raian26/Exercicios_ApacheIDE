/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Tarefa;

/**
 *
 * @author raian
 */
public class TarefaTableModel extends AbstractTableModel {
    // colunas que aparecerão no table grafica
    String[] colunas = {"Nome", "Descrição", "Prazo", "Tarefa Concluída",
        "Editar", "Excluir"};
    //Lista que guarda as tarefas 
    List<Tarefa> tarefas = new ArrayList<>();

    @Override
    // vai dizer quantas tarefaas temos
    public int getRowCount() {
      return tarefas.size(); // retorno o número de tarefas
    }
  // vai me dizer quantas colunas temos
    @Override
    public int getColumnCount() {
        return colunas.length; // assim quando necessário retorno quantos números de colunas terão na table
    }
  // vai dizer qual valor deverá ser exibido em determinada linha e coluna
   
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
            return columnIndex == 3;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        if(tarefas.isEmpty()){
            return Object.class;
    }  return this.getValueAt(0, columnIndex).getClass();
}
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       switch(columnIndex) {
           case 0:
               return tarefas.get(rowIndex).getNome();
               
           case 1:
               return tarefas.get(rowIndex).getDescricao();
              
           case 2:
               SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
               return dateFormat.format(tarefas.get(rowIndex).getPrazo());
           case 3:
                 return tarefas.get(rowIndex).isIscompleted();
           case 4:
              return "";
           
           case 5:
               return "";
           default:
               return "Dados não encontrados!";  
       }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
        tarefas.get(rowIndex).setIscompleted((boolean)aValue);
    }
    
    @Override
    public String getColumnName(int columnIdex){
        return colunas[columnIdex];
    }

    public String[] getColunas() {
        return colunas;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }
    
    
}
