package javaprojetoclinicaveterinaria.controller;
import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.model.Medico;
import javax.swing.JOptionPane;

public class MedicoController {
    
    public void cadastraMedico(String nome,String cpf,String crmv,String especializacao,String endereco) throws ExceptionDAO{
        if (nome!= null && nome.length() > 0 
                && cpf != null && cpf.length() > 0  
                && crmv  != null && crmv.length() > 0 
                && especializacao != null && especializacao.length() > 0 
                && endereco != null && endereco.length() > 0) {
            
            Medico medico = new Medico(nome, cpf, crmv, especializacao, endereco);
            medico.cadastraMedico(medico);
            
        }else{
            JOptionPane.showMessageDialog(null, "Os campos nao foram preencidos corretamentes");
        }
    }
    
    public void editaMedico(int codMedico,String nome,String cpf,String crmv,String especializacao,String endereco)throws ExceptionDAO{
        if (codMedico > 0
                &&nome!= null && nome.length() > 0 
                && cpf != null && cpf.length() > 0  
                && crmv  != null && crmv.length() > 0 
                && especializacao != null && especializacao.length() > 0 
                && endereco != null && endereco.length() > 0) {
            
            Medico medico = new Medico(nome, cpf, crmv, especializacao, endereco);
            medico.setId(codMedico);
            medico.editaMedico(medico);
            
        }else{
            JOptionPane.showMessageDialog(null, "Os campos nao foram preencidos corretamentes");
        }
    }
    
    public void excluiMedico(int codMedico)throws ExceptionDAO{
        if (codMedico == 0) {
            JOptionPane.showMessageDialog(null, "Informe um codigo valido.");
        }else{
            Medico medico = new Medico();
            medico.setId(codMedico);
            medico.excluiMedico(codMedico);
        }
    }
    
}
