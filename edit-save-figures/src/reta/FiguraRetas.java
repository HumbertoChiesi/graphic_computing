package reta;
import java.awt.*;

/**
 *Classe que cria um objeto da classe RetaGr e chama o metodo que o desenha
 * */
public class FiguraRetas {
       public static void desenharReta(Graphics g, int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
           RetaGr r = new RetaGr(x1, y1, x2, y2, cor, nome, esp);
           r.desenharReta(g);
        }
}
