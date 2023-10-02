package javaprojetoclinicaveterinaria;

import javaprojetoclinicaveterinaria.view.JanelaPrincipal;
import javax.swing.JFrame;

public class JavaProjetoClinicaVeterinaria {

    
    public static void main(String[] args) {
        JanelaPrincipal jan = new JanelaPrincipal();
        jan.setVisible(true);
        jan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
