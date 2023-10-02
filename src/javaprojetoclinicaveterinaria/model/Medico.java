package javaprojetoclinicaveterinaria.model;

import java.util.ArrayList;
import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.dao.MedicoDao;

public class Medico {
    
    private ArrayList<Medico> listaMedico; 
    
    private int id ;
    private String nome;
    private String cpf;
    private String crmv;
    private String especializacao;
    private String endereco;

    public Medico() {
    }

    public Medico(String nome, String cpf, String crmv, String especializacao, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.crmv = crmv;
        this.especializacao = especializacao;
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public ArrayList<Medico> getListaMedico() {
        return listaMedico;
    }

    public void setListaMedico(ArrayList<Medico> listaMedico) {
        this.listaMedico = listaMedico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }
    
    public void cadastraMedico(Medico medico) throws ExceptionDAO{
        new MedicoDao().cadastraMedico(medico);
    }
    public void editaMedico(Medico medico)throws ExceptionDAO{
        new MedicoDao().alteraMedico(medico);
    }
    public void excluiMedico(int idMedico)throws ExceptionDAO{
        new MedicoDao().excluiMedico(idMedico);
    }
    
}
