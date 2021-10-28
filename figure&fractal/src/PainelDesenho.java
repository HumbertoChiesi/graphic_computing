import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ponto.FiguraPontos;
import reta.FiguraRetas;
import circulo.FiguraCirculos;

/**
 * Escreva a descricao da classe PainelDesenho aqui.
 * 
 * @author (seu nome) 
 * @version (numero de versao ou data)
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {

    JLabel msg;           // Label para mensagens
    TipoPrimitivo tipo; // Tipo do primitivo
    Color corAtual;       // Cor atual do primitivo
    int esp;              // Diametro do ponto
    int raio;
    int quantidade =0;

    // Para ponto
    int x, y;

    // Para reta
    int x1, y1, x2, y2;

    // selecionar primeiro click do mouse
    boolean primeiraVez = true;

    /**
     * COnstrutor para objetos da classe PainelDesenho
     */
    public PainelDesenho(JLabel msg, TipoPrimitivo tipo, Color corAtual, int esp){
        setTipo(tipo);
        setMsg(msg);
        setCorAtual(corAtual);
        setEsp(esp);

        // Adiciona "ouvidor" de eventos de mouse
        this.addMouseListener(this); 
        this.addMouseMotionListener(this);

    }

    public void setTipo(TipoPrimitivo tipo){
        this.tipo = tipo;
    }

    public TipoPrimitivo getTipo(){
        return this.tipo;
    }

    public void setEsp(int esp){
        this.esp = esp;
    }

    public int getEsp(){
        return this.esp;
    }

    public void setCorAtual(Color corAtual){
        this.corAtual = corAtual;
    }

    public Color getCorAtual(){
        return this.corAtual;
    }

    public void setMsg(JLabel msg){
        this.msg = msg;
    }

    public JLabel getMsg(){
        return this.msg;
    }

    /**
     * @return the raio
     */
    public int getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(int raio) {
        this.raio = raio;
    }

    public void paintComponent(Graphics g) {   
        desenharPrimitivos(g);
    }

    // Capturando os Eventos com o mouse
    public void mousePressed(MouseEvent e) { 
        Graphics g = getGraphics();  
        if(tipo == TipoPrimitivo.CURVA_DRAGAO){
            paint(g);
        }else if (tipo == TipoPrimitivo.CURVA){
            paint(g);
        }
    }


    public void mouseReleased(MouseEvent e) { 
    }           

    public void mouseClicked(MouseEvent e) {
        //        this.msg.setText("CLICOU: "+e.getButton());
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {

        this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());

    }

    public void desenharPrimitivos(Graphics g){
        if (tipo ==TipoPrimitivo.CURVA_DRAGAO){
            
            new CurvaoDragao(getEsp()-1,g, (int)this.getSize().getWidth()/2, (int) this.getSize().getHeight()/2).desenha();
        }else if (tipo ==TipoPrimitivo.CURVA){
            new linesAndCircles(getEsp()*50, g, (int) this.getSize().getWidth()/2, (int) this.getSize().getHeight()/2).drawFigure();;
        }
    }
}
