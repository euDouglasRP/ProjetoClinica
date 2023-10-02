package javaprojetoclinicaveterinaria.controller;

import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.model.Cliente;
import javax.swing.JOptionPane;

public class ClienteController {

    public void cadastraCliente(String nome, String cpf, String telefone, String email, String endereco) throws ExceptionDAO {
        
        if (nome != null && nome.length() > 0
                && cpf != null && cpf.length() > 0
                && telefone != null && telefone.length() > 0
                && email != null && email.length() > 0
                && endereco != null && endereco.length() > 0) {

            Cliente cliente = new Cliente(nome, cpf, telefone, email, endereco);
            cliente.cadastraCliente(cliente);
            
        }else{
            JOptionPane.showMessageDialog(null, "Os campos nao foram preenchidos corretamente!");
            
        }
        
    }

    public void alterarCliente(int codCliente, String nome, String cpf, String telefone, String email, String endereco) throws ExceptionDAO {
        if (nome != null && nome.length() > 0
                && cpf != null && cpf.length() > 0
                && telefone != null && telefone.length() > 0
                && email != null && email.length() > 0
                && endereco != null && endereco.length() > 0) {

            Cliente cliente = new Cliente(nome, cpf, telefone, email, endereco);
            cliente.setId(codCliente);
            cliente.alterarCliente(cliente);
           
        }else{
            JOptionPane.showMessageDialog(null, "Os campos nao foram preenchidos corretamente!");
            
        }
        
    }
    
    public void excluiCliente(int idCliente)throws ExceptionDAO{
        if(idCliente == 0){
            JOptionPane.showMessageDialog(null, "Informe um id Valido");
        }else{
            Cliente cliente = new Cliente();
            cliente.setId(idCliente);
            cliente.excluirCliente(idCliente);
            
        }
    }
}
