package javaprojetoclinicaveterinaria.model;

import java.util.ArrayList;
import javaprojetoclinicaveterinaria.dao.AnimalDao;
import javaprojetoclinicaveterinaria.dao.ExceptionDAO;


public class Animal {
    
    ArrayList<Animal> listaAnimal;
    
    private int id;
    private String raca;
    private String nome;
    private String idade;
    private String ficha_de_vacinacao;
    private String sexo;
    private int id_Cliente;

    public Animal() {
    }

    public Animal(String raca, String nome, String idade, String ficha_de_vacinacao, String sexo,int id_Cliente) {
        this.raca = raca;
        this.nome = nome;
        this.idade = idade;
        this.ficha_de_vacinacao = ficha_de_vacinacao;
        this.sexo = sexo;
        this.id_Cliente = id_Cliente;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getFicha_de_vacinacao() {
        return ficha_de_vacinacao;
    }

    public void setFicha_de_vacinacao(String ficha_de_vacinacao) {
        this.ficha_de_vacinacao = ficha_de_vacinacao;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
    
    public void cadastraAnimal(Animal animal)throws ExceptionDAO{
        new AnimalDao().cadastraAnimal(animal);
    }
    
    public void alterarAnimal(Animal animal)throws ExceptionDAO{
        new AnimalDao().editaAnimal(animal);
    }
    
    public void excluirAnimal(int idAnimal)throws ExceptionDAO{
        new AnimalDao().excluiAnimal(idAnimal);
    }
    
    
    
    
    
    
}
