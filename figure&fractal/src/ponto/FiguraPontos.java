package ponto;
import java.awt.*;


/**
 * Aplicacao para testar primitivos graficos.
 * 
 * @author Humberto Chiesi Neto e Matheus Madureira Fortunato
 * @version 13/09/2021
 */
public class FiguraPontos {
    
    public static void desenharPonto(Graphics g, int x, int y, String nome, int diametro, Color cor){
            // Color cor = new Color((int) (Math.random() * 256),  
                    // (int) (Math.random() * 256),  
                    // (int) (Math.random() * 256));
            PontoGr p = new PontoGr(x, y, cor, nome, diametro);
            p.desenharPonto(g);
    }
    
   public static void desenharPontos(Graphics g, int qtde, int larg){

        for(int i=0; i < qtde; i++) {
            int x = (int) (Math.random() * 801);
            int y = (int) (Math.random() * 801);

            // R, G e B aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            PontoGr p = new PontoGr(x, y, cor, larg);
            p.desenharPonto(g);
        }
    }
}
