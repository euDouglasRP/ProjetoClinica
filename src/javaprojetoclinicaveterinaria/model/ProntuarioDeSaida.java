package javaprojetoclinicaveterinaria.model;

import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.dao.ProntuarioDeSaidaDao;


public class ProntuarioDeSaida {
    private int id;
    private int idProntuarioDeEntrada;
    private String descicao;
    private String data_de_saida;

    public ProntuarioDeSaida() {
    }

    public ProntuarioDeSaida(int idProntuarioDeEntrada, String descicao, String data_de_saida) {
        this.idProntuarioDeEntrada = idProntuarioDeEntrada;
        this.descicao = descicao;
        this.data_de_saida = data_de_saida;
    }

    public String getData_de_saida() {
        return data_de_saida;
    }

    public void setData_de_saida(String data_de_saida) {
        this.data_de_saida = data_de_saida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProntuarioDeEntrada() {
        return idProntuarioDeEntrada;
    }

    public void setIdProntuarioDeEntrada(int idProntuarioDeEntrada) {
        this.idProntuarioDeEntrada = idProntuarioDeEntrada;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }
    
    public void cadastrarProntuarioDeSaida(ProntuarioDeSaida prontuarioDeSaida)throws ExceptionDAO{
        new ProntuarioDeSaidaDao().cadastrarProntuarioDeSaida(prontuarioDeSaida);
    }
    public void editarProntuarioDeEntrada(ProntuarioDeSaida prontuarioDeSaida)throws ExceptionDAO{
        new ProntuarioDeSaidaDao().editarProntuarioDeSaida(prontuarioDeSaida);
    }
     public void excluirProntuarioDeEntrada(int idprontuarioDeSaida)throws ExceptionDAO{
        new ProntuarioDeSaidaDao().excluirProntuarioDeSaida(idprontuarioDeSaida);
    }
}
