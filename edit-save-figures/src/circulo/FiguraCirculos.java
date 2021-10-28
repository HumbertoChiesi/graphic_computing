package circulo;
import java.awt.Color;
import java.awt.Graphics;

/**
 *Classe que cria um objeto da classe CirculoGr e chama o metodo que o desenha
 * */
public class FiguraCirculos {
       public static void desenharCirculo(Graphics g, int xc, int yc, int raio, String nome, int esp, Color cor){
            CirculoGr c = new CirculoGr(xc, yc, raio, cor, nome, esp);
            c.desenharCirculo(g);
        }
}
