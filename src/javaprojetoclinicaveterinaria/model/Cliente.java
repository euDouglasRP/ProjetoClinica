package javaprojetoclinicaveterinaria.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import javaprojetoclinicaveterinaria.dao.ClienteDao;
import javaprojetoclinicaveterinaria.dao.Conexao;
import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javax.swing.JOptionPane;

public class Cliente {

    ArrayList<Cliente> listaCliente;
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;

    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente() {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void cadastraCliente(Cliente cliente) throws ExceptionDAO{
        new ClienteDao().cadastraCliente(cliente);
    }
    
    public void alterarCliente(Cliente cliente )throws ExceptionDAO{
        new ClienteDao().alteraCliente(cliente);
    }
    public void excluirCliente(int idCliente )throws ExceptionDAO{
        new ClienteDao().excluiCliente(idCliente);
    }
}
