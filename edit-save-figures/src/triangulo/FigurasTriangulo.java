package triangulo;

import java.awt.*;

/**
 *Classe que cria um objeto da classe TrianguloGr e chama o metodo que o desenha
 * */
public class FigurasTriangulo {
    public static void desenharTriangulo(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, String nome, int esp, Color cor){
        TrianguloGr t = new TrianguloGr(x1, y1, x2, y2, x3, y3, cor, nome, esp);
        t.desenharTriangulo(g);
    }
}
