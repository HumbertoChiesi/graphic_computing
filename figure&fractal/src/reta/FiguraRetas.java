package reta;
import java.awt.*;


/**
 * Aplicacao para testar primitivos graficos.
 * 
 * @author Humberto Chiesi Neto e Matheus Madureira Fortunato
 * @version 13/09/2021
 */
public class FiguraRetas {
       public static void desenharRetaEq(Graphics g, int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
           RetaGr r = new RetaGr(x1, y1, x2, y2, cor, nome, esp);
            r.desenharRetaEq(g );
        }
       public static void desenharRetaMp(Graphics g, int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
           RetaGr r = new RetaGr(x1, y1, x2, y2, cor, nome, esp);
            r.desenharRetaMp(g );
        }

    public static void desenharRetas(Graphics g, int qtde, int esp){

        for(int i=0; i < qtde; i++) {
            int x1 = (int) (Math.random() * 801);
            int y1 = (int) (Math.random() * 801);
            int x2 = (int) (Math.random() * 801);
            int y2 = (int) (Math.random() * 801);

            // R, G e B aleatorio
            Color cor = new Color((int) (Math.random() * 256),  
                    (int) (Math.random() * 256),  
                    (int) (Math.random() * 256));
            RetaGr r = new RetaGr(x1, y1, x2, y2, cor, "", esp);
            r.desenharRetaMp(g);
        }
    }
}
