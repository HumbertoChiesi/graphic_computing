package retangulo;

import java.awt.*;

/**
 *Classe que cria um objeto da classe RetanguloGr e chama o metodo que o desenha
 * */
public class FigurasRetangulo {
    public static void desenharRetangulo(Graphics g, int x1, int y1, int x2, int y2, String nome, int esp, Color cor){
        RetanguloGr r = new RetanguloGr(x1, y1, x2, y2, cor, nome, esp);
        r.desenharRetangulo(g);
    }
}
