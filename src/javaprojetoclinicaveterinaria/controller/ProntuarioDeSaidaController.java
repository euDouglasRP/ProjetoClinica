package javaprojetoclinicaveterinaria.controller;

import javaprojetoclinicaveterinaria.dao.ExceptionDAO;
import javaprojetoclinicaveterinaria.model.ProntuarioDeSaida;
import javax.swing.JOptionPane;

public class ProntuarioDeSaidaController {
 
    public void cadastrarProntuarioDeSaida(int id_prontuarioDeEntrada,String descricao,String data_de_saida)throws ExceptionDAO{
        if (descricao != null && descricao.length() > 0 &&
                data_de_saida != null && data_de_saida.length() > 0 &&
                 id_prontuarioDeEntrada > 0) {
            
            ProntuarioDeSaida prtSaida = new ProntuarioDeSaida(id_prontuarioDeEntrada, descricao, data_de_saida);
            prtSaida.cadastrarProntuarioDeSaida(prtSaida);
        }
    }
    
     public void editarProntuarioDeSaida(int id_prontuarioDeSaida,int id_prontuarioDeEntrada,String descricao,String data_de_saida)throws ExceptionDAO{
        if (descricao != null && descricao.length() > 0 &&
                data_de_saida != null && data_de_saida.length() > 0 &&
                 id_prontuarioDeEntrada > 0 && id_prontuarioDeSaida >0) {
            
            ProntuarioDeSaida prtSaida = new ProntuarioDeSaida(id_prontuarioDeEntrada, descricao, data_de_saida);
            prtSaida.setId(id_prontuarioDeSaida);
            prtSaida.editarProntuarioDeEntrada(prtSaida);
        }
    }
    
    public void excluirProntuarioDeSaida(int id_ProntuariaDeSaida)throws ExceptionDAO{
        if(id_ProntuariaDeSaida == 0 ){
            JOptionPane.showMessageDialog(null, "Informe um codigo correto!");
        }else{
            ProntuarioDeSaida prtEntrada = new ProntuarioDeSaida();
            prtEntrada.setId(id_ProntuariaDeSaida);
            prtEntrada.excluirProntuarioDeEntrada(id_ProntuariaDeSaida);
        }
    }
    
    
}
