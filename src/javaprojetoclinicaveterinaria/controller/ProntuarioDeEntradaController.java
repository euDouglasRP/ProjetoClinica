package javaprojetoclinicaveterinaria.controller;

import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.model.ProntuarioDeEntrada;
import javax.swing.JOptionPane;

public class ProntuarioDeEntradaController {
    
    
    public void cadastrarProntuarioDeEntrada(String descricao,String data_de_entrada,int id_Animal,int id_Veterinario)throws ExceptionDAO{
        if (descricao != null && descricao.length() > 0 &&
                data_de_entrada != null && data_de_entrada.length() > 0 &&
                 id_Animal > 0 && id_Veterinario > 0) {
            
            ProntuarioDeEntrada prtEntrada = new ProntuarioDeEntrada(descricao, data_de_entrada, id_Animal, id_Veterinario);
            prtEntrada.cadastrarProntuarioDeEntrada(prtEntrada);
        }
    }
    
    public void editarProntuarioDeEntrada(int id_ProntuariaDeEntrada,String descricao,String data_de_entrada,int id_Animal,int id_Veterinario)throws ExceptionDAO{
        if (descricao != null && descricao.length() > 0 &&
                data_de_entrada != null && data_de_entrada.length() > 0 &&
                 id_Animal > 0 && id_Veterinario > 0 && id_ProntuariaDeEntrada > 0 ) {
            
            ProntuarioDeEntrada prtEntrada = new ProntuarioDeEntrada(descricao, data_de_entrada, id_Animal, id_Veterinario);
            prtEntrada.setId(id_ProntuariaDeEntrada);
            prtEntrada.editarProntuarioDeEntrada(prtEntrada);
        }
    }
    
    public void excluirProntuarioDeEntrada(int id_ProntuariaDeEntrada)throws ExceptionDAO{
        if(id_ProntuariaDeEntrada == 0 ){
            JOptionPane.showMessageDialog(null, "Informe um codigo correto!");
        }else{
            ProntuarioDeEntrada prtEntrada = new ProntuarioDeEntrada();
            prtEntrada.setId(id_ProntuariaDeEntrada);
            prtEntrada.excluirProntuarioDeEntrada(id_ProntuariaDeEntrada);
        }
    }
    
    
}
