package ponto;
import java.awt.*;

/**
*Classe que cria um objeto da classe PontoGr e chama o metodo que o desenha
 * */
public class FiguraPontos {
    
    public static void desenharPonto(Graphics g, int x, int y, String nome, int diametro, Color cor){
            PontoGr p = new PontoGr(x, y, cor, nome, diametro);
            p.desenharPonto(g);
    }
}
