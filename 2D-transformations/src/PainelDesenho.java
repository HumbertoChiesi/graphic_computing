import CalculosPontos.CalculoPontos;
import triangulo.FigurasTriangulo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

/**
 * Implementa os eventos de mouse para desenhar primitivos.
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {

    JLabel msg;         // Label para mensagens
    TipoPrimitivo tipo; // Tipo do primitivo

    //ponto que o usuario clicou na tela
    int x1, y1;

    CalculoPontos calcular;

    /**
     * Construtor para objetos da classe PainelDesenho
     */
    public PainelDesenho(JLabel msg, TipoPrimitivo tipo){
        setTipo(tipo);
        setMsg(msg);

        // Adiciona "ouvidor" de eventos de mouse
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    /**
     */
    public void setTipo(TipoPrimitivo tipo){
        this.tipo = tipo;
    }

    /**
     * @return this.tipo
     */
    public TipoPrimitivo getTipo(){
        return this.tipo;
    }

    /**
     * @param msg
     */
    public void setMsg(JLabel msg){
        this.msg = msg;
    }

    /**
     * @return this.msg
     */
    public JLabel getMsg(){
        return this.msg;
    }

    // ---------------------------------------------------------------------------
    // Eventos implementados das interfaces MouseListener e MouseMotionListener
    // Capturando os Eventos com o mouse
    //
    /**
     * Trata o evento de pressionar botao do mouse
     */
    public void mousePressed(MouseEvent e) {
        Graphics g = getGraphics();
        if (tipo == TipoPrimitivo.TRANSLACAO){
            x1 = e.getX(); y1 = e.getY();
            calcular.calcularTranslacao(x1, y1);
            paint(g);
        } else if (tipo == TipoPrimitivo.ROTACAO){
            x1 = e.getX(); y1 = e.getY();
            try {
                int angulo = Integer.parseInt(JOptionPane.showInputDialog(
                        null,"Digite o angula da rotacao", "Rotacao", JOptionPane.QUESTION_MESSAGE
                ));
                calcular.calcularRotacao(x1, y1, angulo*-1);
                paint(g);
            }catch (Exception err){
                JOptionPane.showMessageDialog(null, "insira um numero valido", "ERRO", JOptionPane.WARNING_MESSAGE);
            }
        } else if(tipo == TipoPrimitivo.ESCALA){
            x1 = e.getX(); y1 = e.getY();
            try {
                float escala = Float.parseFloat(JOptionPane.showInputDialog(
                        null,"Digite o multiplicador para escalar", "Rotacao", JOptionPane.QUESTION_MESSAGE
                ));
                if (escala != 0){
                    System.out.println(" isso = " + escala);
                    calcular.calcularEscala(x1, y1, escala);
                    paint(g);
                }
            }catch (NumberFormatException err){
                JOptionPane.showMessageDialog(null, "insira um numero valido", "ERRO", JOptionPane.WARNING_MESSAGE);
            }
        } else if (tipo == TipoPrimitivo.CARREGAR){
        } else {
        }
    }

    public void mouseReleased(MouseEvent e) { }

    public void mouseClicked(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) { }

    public void mouseExited(MouseEvent e) {  }

    public void mouseDragged(MouseEvent e) { }

    public void mouseMoved(MouseEvent e) {
        this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());
    }

    //desenha o triangulo quando a janela é aberta
    public void desenharAbriu(Graphics g){
        int x = this.getWidth()/2; int y = this.getHeight()/2;
        calcular = new CalculoPontos(x, y);
        setTipo(TipoPrimitivo.CARREGAR);
        paint(g);
    }

    //limpa a tela, pega o ponto central e desenha o triangulo
    public void reset(Graphics g){
        int x = getWidth()/2; int y = this.getHeight()/2;
        calcular = new CalculoPontos(x, y);
        setTipo(TipoPrimitivo.RESET);
        paint(g);
    }
    //
    // ---------------------------------------------------------------------------

    /**
     * Metodo reimplementado para desenhar os primitivos na area de desenho
     */
    public void paintComponent(Graphics g) {fazerTransformacoes(g);}

    /**
     * Desenha o triangulo depois das transformações
     * @param g
     */
    public void fazerTransformacoes(Graphics g){
        if (tipo == TipoPrimitivo.TRANSLACAO || tipo == TipoPrimitivo.ROTACAO || tipo == TipoPrimitivo.ESCALA || tipo==TipoPrimitivo.RESET){
            this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
            FigurasTriangulo.desenharTriangulo(
                    g, calcular.getX1(), calcular.getY1(), calcular.getX2(), calcular.getY2(), calcular.getX3(), calcular.getY3(),
                    "", 5, Color.BLUE
            );
        } else if (tipo == TipoPrimitivo.CARREGAR){
            if (calcular != null && calcular.gettPontos() != null){
                FigurasTriangulo.desenharTriangulo(
                        g, calcular.getX1(), calcular.getY1(), calcular.getX2(), calcular.getY2(), calcular.getX3(), calcular.getY3(),
                        "", 5, Color.BLUE
                );
            }
        }
    }
}


