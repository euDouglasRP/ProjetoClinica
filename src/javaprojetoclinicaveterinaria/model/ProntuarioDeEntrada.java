package javaprojetoclinicaveterinaria.model;

import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.dao.ProntuarioDeEntradaDao;


public class ProntuarioDeEntrada {
    private int id;
    private String descricao;
    private String data_de_entrada;
    private int id_Animal;
    private int id_Veterinario;

    public ProntuarioDeEntrada(String descricao, String data_de_entrada, int id_Animal, int id_Veterinario) {
        this.descricao = descricao;
        this.data_de_entrada = data_de_entrada;
        this.id_Animal = id_Animal;
        this.id_Veterinario = id_Veterinario;
    }

    public ProntuarioDeEntrada() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_de_entrada() {
        return data_de_entrada;
    }

    public void setData_de_entrada(String data_de_entrada) {
        this.data_de_entrada = data_de_entrada;
    }

    public int getId_Animal() {
        return id_Animal;
    }

    public void setId_Animal(int id_Animal) {
        this.id_Animal = id_Animal;
    }

    public int getId_Veterinario() {
        return id_Veterinario;
    }

    public void setId_Veterinario(int id_Veterinario) {
        this.id_Veterinario = id_Veterinario;
    }
    
    
    public void cadastrarProntuarioDeEntrada(ProntuarioDeEntrada prontuarioDeEntrada)throws ExceptionDAO{
        new ProntuarioDeEntradaDao().cadastrarProntuarioDeEntrada(prontuarioDeEntrada);
    }
    
    public void editarProntuarioDeEntrada(ProntuarioDeEntrada prontuarioDeEntrada)throws ExceptionDAO{
        new ProntuarioDeEntradaDao().editarProntuarioDeEntrada(prontuarioDeEntrada);
    }
    
    public void excluirProntuarioDeEntrada(int idprontuarioDeEntrada)throws ExceptionDAO{
        new ProntuarioDeEntradaDao().excluirProntuarioDeEntrada(idprontuarioDeEntrada);
    }
    
}
