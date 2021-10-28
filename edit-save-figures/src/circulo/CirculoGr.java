package circulo;
import java.awt.Color;
import java.awt.Graphics;

import ponto.PontoGr;

/**
 * Escreva a descri��o da classe CirculoGr aqui.
 * 
 * @author (seu nome) 
 * @version (n�mero de vers�o ou data)
 */

public class CirculoGr extends Circulo {
    // Atributos do circulo grafico
    Color corCirculo = Color.BLACK;   // cor da Circulo
    String nomeCirculo = ""; // nome da Circulo
    Color corNomeCirculo  = Color.BLACK;
    int espCirculo = 1; // espessura da Circulo

    public CirculoGr(double x, double y, double raio) {
        super(x, y, raio);
        // cor, nome e espessura sao defaults
    }

    public CirculoGr(int xc, int yc, int raio, Color cor, String nome, int esp) {
        super((double) xc, (double) yc, (double) raio);
        setCorCirculo(cor);
        setNomeCirculo(nome);
        setEspCirculo(esp);
    }

    /**
     * @return the corCirculo
     */
    public Color getCorCirculo() {
        return corCirculo;
    }

    /**
     * @param corCirculo the corCirculo to set
     */
    public void setCorCirculo(Color corCirculo) {
        this.corCirculo = corCirculo;
    }

    /**
     * @return the nomeCirculo
     */
    public String getNomeCirculo() {
        return nomeCirculo;
    }

    /**
     * @param nomeCirculo the nomeCirculo to set
     */
    public void setNomeCirculo(String nomeCirculo) {
        this.nomeCirculo = nomeCirculo;
    }

    /**
     * @return the corNomeCirculo
     */
    public Color getCorNomeCirculo() {
        return corNomeCirculo;
    }

    /**
     * @param corNomeCirculo the corNomeCirculo to set
     */
    public void setCorNomeCirculo(Color corNomeCirculo) {
        this.corNomeCirculo = corNomeCirculo;
    }

    /**
     * @return the espCirculo
     */
    public int getEspCirculo() {
        return espCirculo;
    }

    /**
     * @param espCirculo the espCirculo to set
     */
    public void setEspCirculo(int espCirculo) {
        this.espCirculo = espCirculo;
    }

    /**
     * Desenha circulo utilizando algoritmo MidPoint (Bresenham)
     * @param g
     */
    void desenharCirculo(Graphics g) {

        if (getRaio() != 0) {
        // Variaveis auxiliares
        PontoGr ponto = new PontoGr(); 

            double x = 0;
            double y = getRaio();
            double d = 5 / 4 - getRaio();

            desenharPontosSimetricos (g, (int)x, (int)y, ponto);

            while (y > x) {
                if (d < 0) {
                    d = d + 2 * x + 3;
                    x++;
                }

                else {
                    d = d + 2 * (x - y) + 5;
                    x++;
                    y--;
                }
                desenharPontosSimetricos (g, (int)x, (int)y, ponto);
            }
        }       
    }

    /**
     * Desenha os pontos simetricos do circulo. Um em cada octante
     * @param g - componente para acessar modo gr�fico
     * @param x - coordenada x de um ponto do primeiro octante do circulo
     * @param y - coordenada y de um ponto do primeiro octante do circulo
     * @param ponto - objeto utilizado para "acender" (desenhar) um ponto
     */
    private void desenharPontosSimetricos(Graphics g, int x, int y, PontoGr ponto){
        // pega o centro do circulo
        int cx = (int)getCentro().getX();
        int cy = (int)getCentro().getY();

        // seta cor e espessura
        ponto.setCorPto(getCorCirculo());
        ponto.setDiametro(getEspCirculo());

        // desenha nome do circulo
        g.setColor(getCorNomeCirculo());
        g.drawString(getNomeCirculo(), cx, cy);

        // desenha os 8 pontos simetricos. Inclui o centro do circulo
        // (1) (cx+x, cy+y)
        desenharPontoSimetrico(cx + x, cy + y, ponto, g);
        // (2) (cx+y, cy+x)
        desenharPontoSimetrico(cx + y, cy + x, ponto, g);
        // (3) (cx-y, cy+x)
        desenharPontoSimetrico(cx - y, cy + x, ponto, g);
        // (4) (cx-x, cy+y)
        desenharPontoSimetrico(cx - x, cy + y, ponto, g);
        // (5) (cx-x, cy-y)
        desenharPontoSimetrico(cx - x, cy - y, ponto, g);
        // (6) (cx-y, cy-x)
        desenharPontoSimetrico(cx - y, cy - x, ponto, g);
        // (7) (cx+y, cy-x)
        desenharPontoSimetrico(cx + y, cy - x, ponto, g);
        // (8) (cx+x, cy-y)
        desenharPontoSimetrico(cx + x, cy - y, ponto, g);
    }

    /**
     * M�todo desenharPontoSimetrico
     *
     * @param x Um par�metro
     * @param y Um par�metro
     * @param ponto Um par�metro
     * @param g Um par�metro
     */
    private void desenharPontoSimetrico(int x, int y, PontoGr ponto, Graphics g){
        ponto.setX(x);
        ponto.setY(y);
        ponto.desenharPonto(g);
    }
}
