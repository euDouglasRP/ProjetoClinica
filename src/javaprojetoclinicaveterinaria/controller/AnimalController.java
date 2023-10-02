package javaprojetoclinicaveterinaria.controller;

import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.model.Animal;
import javax.swing.JOptionPane;

public class AnimalController {

    public void cadastraAnimal(String raca, String nome, String idade, String ficha_de_vacinacao, String sexo, int id_Cliente) throws ExceptionDAO {
        if (raca != null && raca.length() > 0
                && nome != null && nome.length() > 0
                && idade != null && idade.length() > 0
                && ficha_de_vacinacao != null && ficha_de_vacinacao.length() > 0
                && sexo != null && sexo.length() > 0
                && id_Cliente > 0) {
            
            Animal animal = new Animal(raca, nome, idade, ficha_de_vacinacao, sexo, id_Cliente);
            animal.cadastraAnimal(animal);
        }else{
            JOptionPane.showMessageDialog(null, "Preencha os campos corretamente");
        }
        
    }
    
    public void alteraAnimal(int codAnimal, String raca, String nome, String idade, String ficha_de_vacinacao, String sexo, int id_Cliente) throws ExceptionDAO{
        if (raca != null && raca.length() > 0
                && nome != null && nome.length() > 0
                && idade != null && idade.length() > 0
                && ficha_de_vacinacao != null && ficha_de_vacinacao.length() > 0
                && sexo != null && sexo.length() > 0
                && id_Cliente > 0) {
            
            Animal animal = new Animal(raca, nome, idade, ficha_de_vacinacao, sexo, id_Cliente);
            animal.setId(codAnimal);
            animal.alterarAnimal(animal);
            
        }else{
            JOptionPane.showMessageDialog(null, "Os campos nao foram preenchidos corretamente!");
            
        }
    }
    public void excluiAnimal(int idAnimal)throws ExceptionDAO{
        if(idAnimal == 0){
            JOptionPane.showMessageDialog(null, "Informe um id valido");
        }else{
            Animal animal = new Animal();
            animal.setId(idAnimal);
            animal.excluirAnimal(idAnimal);
        }
    }
  
}

