import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

import modelos.*;
import poligono.PoligonoGr;
import ponto.FiguraPontos;
import reta.FiguraRetas;
import circulo.FiguraCirculos;
import retangulo.FigurasRetangulo;
import triangulo.FigurasTriangulo;

/**
 * Escreva a descricao da classe PainelDesenho aqui.
 * 
 * @author (seu nome) 
 * @version (numero de versao ou data)
 */
public class PainelDesenho extends JPanel implements MouseListener, MouseMotionListener {

    JLabel msg;             // Label para mensagens
    TipoPrimitivo tipo;     // Tipo do primitivo
    Color corAtual;         // Cor atual do primitivo
    int esp;                // Diametro do ponto
    int raio;

    ModeloJson modelo;      //contem todos os primitivos na representação json
    PoligonoGr poligono;    //utilizada para o desenho do poligono

    // Para ponto
    int x, y;

    // Para reta
    int x1, y1, x2, y2;

    //Para triangulo
    int x3, y3;

    // selecionar primeiro click do mouse
    boolean primeiraVez = true;

    // selecionar segundo click do mouse
    boolean segundaVez = false;

    //selecionar ultimo click do mouse (utilizado para o desenho do poligono)
    boolean ultimaVez = false;

    /**
     * COnstrutor para objetos da classe PainelDesenho
     */
    public PainelDesenho(JLabel msg, TipoPrimitivo tipo, Color corAtual, int esp){
        setTipo(tipo);
        setMsg(msg);
        setCorAtual(corAtual);
        setEsp(esp);
        setModelo(new ModeloJson());

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

    public void setCorAtual(Color corAtual){this.corAtual = corAtual;}

    public Color getCorAtual(){
        return this.corAtual;
    }

    public void setMsg(JLabel msg){
        this.msg = msg;
    }

    public JLabel getMsg(){
        return this.msg;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }

    public void setModelo(ModeloJson modelo) {this.modelo = modelo;}

    public ModeloJson getModelo() {return modelo;}

    public void setPoligono(PoligonoGr poligono) {this.poligono = poligono;}

    public PoligonoGr getPoligono() {return poligono;}

    public void paintComponent(Graphics g) {
        desenharPrimitivos(g);
    }

    // Capturando os Eventos com o mouse
    public void mousePressed(MouseEvent e) { 
        Graphics g = getGraphics();
        //verifica se foi um click com o botão esquerdo do mouse
        if (SwingUtilities.isLeftMouseButton(e)){
            if (tipo == TipoPrimitivo.PONTO){
                x = e.getX();
                y = e.getY();
                paint(g);
            } else if (tipo == TipoPrimitivo.RETA){
                if (primeiraVez == true) {
                    x1 = e.getX();
                    y1 = e.getY();
                    primeiraVez = false;
                } else {
                    x2 = e.getX();
                    y2 = e.getY();
                    primeiraVez = true;
                    paint(g);
                }
            }else if (tipo == TipoPrimitivo.CIRCULO){
                if (primeiraVez == true) {
                    x1 = e.getX();
                    y1 = e.getY();
                    primeiraVez = false;
                } else {
                    x2 = e.getX();
                    y2 = e.getY();
                    primeiraVez = true;

                    // calcula o raio
                    raio = (int)Math.sqrt(Math.pow((y2-y1), 2) + Math.pow((x2-x1), 2));
                    setRaio(raio);
                    paint(g);
                }
            } else if (tipo == TipoPrimitivo.TRIANGULO){
                if (primeiraVez == true) {
                    x1 = e.getX();
                    y1 = e.getY();
                    primeiraVez = false;
                    segundaVez = true;
                } else if (segundaVez == true){
                    x2 = e.getX();
                    y2 = e.getY();
                    segundaVez = false;
                } else {
                    x3 = e.getX();
                    y3 = e.getY();
                    primeiraVez = true;
                    segundaVez = false;
                    paint(g);
                }
            } else if (tipo == TipoPrimitivo.RETANGULO){
                if (primeiraVez == true) {
                    x1 = e.getX();
                    y1 = e.getY();
                    primeiraVez = false;
                } else {
                    x2 = e.getX();
                    y2 = e.getY();
                    primeiraVez = true;
                    paint(g);
                }
            } else if (tipo == TipoPrimitivo.POLIGONO){
                if (primeiraVez == true){
                    x1 = e.getX();
                    y1 = e.getY();
                    //cria um novo poligono com ponto inicial (x1, y1)
                    this.poligono = new PoligonoGr(x1, y1, "", getCorAtual(), getEsp());
                    primeiraVez = false;
                } else {
                    x1 = e.getX();
                    y1 = e.getY();
                    paint(g);
                }
            }
            //verifica se foi um click com o botão esquerdo do direito
        } else if (SwingUtilities.isRightMouseButton(e)){
            //se for um poligono e não for a primeira vez(primeiro ponto), desenha o ultimo ponto
            if (tipo == TipoPrimitivo.POLIGONO && !primeiraVez){
                x1 = e.getX();
                y1 = e.getY();
                ultimaVez = true;
                paint(g);
            }
        }

    }


    public void mouseReleased(MouseEvent e) { 
    }           

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {this.msg.setText("("+e.getX() + ", " + e.getY() + ") - " + getTipo());}

    //desenha todos os primitivos e guarda todos os primitivos no objeto modelo para salvar em json posteriormente
    public void desenharPrimitivos(Graphics g){
        if (tipo == TipoPrimitivo.PONTO){
            FiguraPontos.desenharPonto(g, x, y, "", getEsp(), getCorAtual());
            getModelo().addPonto(nX(x), nY(y), getCorAtual(), getEsp());
        } else if (tipo == TipoPrimitivo.RETA){
            FiguraRetas.desenharReta(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            getModelo().addReta(nX(x1), nY(y1), nX(x2), nY(y2), getCorAtual(), getEsp());
        } else if (tipo==TipoPrimitivo.CIRCULO){
            FiguraCirculos.desenharCirculo(g, x1, y1, getRaio(), "", getEsp(), getCorAtual());
            getModelo().addCirculo(nX(x1), nY(y1), nX(getRaio()), getCorAtual(), getEsp());
        } else if (tipo==TipoPrimitivo.TRIANGULO){
            FigurasTriangulo.desenharTriangulo(g, x1, y1, x2, y2, x3, y3, "", getEsp(), getCorAtual());
            getModelo().addTriangulo(nX(x1), nY(y1), nX(x2), nY(y2), nX(x3), nY(y3), getCorAtual(), getEsp());
        } else if (tipo==TipoPrimitivo.RETANGULO){
            FigurasRetangulo.desenharRetangulo(g, x1, y1, x2, y2, "", getEsp(), getCorAtual());
            getModelo().addRetangulo(nX(x1), nY(y1), nX(x2), nY(y2), getCorAtual(), getEsp());
        } else if (tipo==TipoPrimitivo.POLIGONO){
            //verifica se é o ultimo ponto do poligono
            if (ultimaVez){
                this.poligono.ultimaAresta(g, x1, y1);
                ArrayList<Float[]> aux = new ArrayList<>();
                //loop para normalizar todos os pontos do poligono e guardar em um novo array
                for (Integer[] p : getPoligono().getPontos()){
                    aux.add(new Float[]{nX(p[0]), nY(p[1])});
                }
                getModelo().addPoligono(aux, getCorAtual(), getEsp());
                this.poligono = new PoligonoGr();
                this.ultimaVez = false;
                primeiraVez = true;
            }else if (!primeiraVez){
                poligono.novaAresta(g, x1, y1);
            }
        }
        //percorre e desenha todos os arrays de primitivos e figuras do objeto modelo
        else if (tipo==TipoPrimitivo.CARREGAR){
            //percorre o array pontos do objeto modelo desenhando cada um deles
            for (PontoJson p : getModelo().getPontos()){
                x1 = dX(p.getCoord()[0]); y1 = dY(p.getCoord()[1]);
                FiguraPontos.desenharPonto(g, x1, y1, "", p.getEsp(), new Color(p.getCor()[0],p.getCor()[1], p.getCor()[2]));
            }
            //percorre o array retas do objeto modelo desenhando cada um deles
            for (RetaJson r : getModelo().getRetas()){
                x1 = dX(r.getpontos()[0][0]); y1 = dY(r.getpontos()[0][1]);
                x2 = dX(r.getpontos()[1][0]); y2 = dY(r.getpontos()[1][1]);
                FiguraRetas.desenharReta(g, x1, y1, x2,  y2, "", r.getEsp(), new Color(r.getCor()[0],r.getCor()[1], r.getCor()[2]));
            }
            //percorre o array circulos do objeto modelo desenhando cada um deles
            for (CirculoJson c : getModelo().getCirculos()){
                x1 = dX(c.getcentro()[0]); y1 = dY(c.getcentro()[1]);
                FiguraCirculos.desenharCirculo(g, x1, y1, dX(c.getRaio()), "", c.getEsp(), new Color(c.getCor()[0],c.getCor()[1], c.getCor()[2]));
            }
            //percorre o array triangulos do objeto modelo desenhando cada um deles
            for (TrianguloJson t : getModelo().getTriangulos()){
                x1 = dX(t.getpontos()[0][0]); y1 = dY(t.getpontos()[0][1]);
                x2 = dX(t.getpontos()[1][0]); y2 = dY(t.getpontos()[1][1]);
                x3 = dX(t.getpontos()[2][0]); y3 = dY(t.getpontos()[2][1]);
                FigurasTriangulo.desenharTriangulo(g, x1, y1, x2, y2, x3, y3, "", t.getEsp(), new Color(t.getCor()[0],t.getCor()[1], t.getCor()[2]));
            }
            //percorre o array retangulos do objeto modelo desenhando cada um deles
            for (RetanguloJson retangulo : getModelo().getRetangulos()){
                x1 = dX(retangulo.getpontos()[0][0]); y1 = dY(retangulo.getpontos()[0][1]);
                x2 = dX(retangulo.getpontos()[1][0]); y2 = dY(retangulo.getpontos()[1][1]);
                FigurasRetangulo.desenharRetangulo(g, x1, y1, x2, y2, "", retangulo.getEsp(), new Color(retangulo.getCor()[0],retangulo.getCor()[1], retangulo.getCor()[2]));
            }
            //percorre o array poligonos do objeto modelo desenhando cada um deles
            for (PoligonoJson poligono : getModelo().getPoligonos()){
                int tamanho = poligono.getpontos().size();
                Color aux = new Color(poligono.getCor()[0],poligono.getCor()[1], poligono.getCor()[2]);
                for (int p = 0; p<(tamanho-1);p++){
                    x1 = dX(poligono.getpontos().get(p)[0]); y1 = dY(poligono.getpontos().get(p)[1]);
                    x2 = dX(poligono.getpontos().get(p+1)[0]); y2 = dY(poligono.getpontos().get(p+1)[1]);
                    FiguraRetas.desenharReta(g, x1, y1, x2, y2, "", poligono.getEsp(), aux);
                }
                x1 = dX(poligono.getpontos().get(0)[0]); y1 = dY(poligono.getpontos().get(0)[1]);
                x2 = dX(poligono.getpontos().get(tamanho-1)[0]); y2 = dY(poligono.getpontos().get(tamanho-1)[1]);
                FiguraRetas.desenharReta(g, x1, y1, x2, y2, "", poligono.getEsp(), aux);
            }
        }
    }

    //normaliza a cordenada x
    private float nX(int x){return  (float)(x)/(this.getWidth());}

    //calcula a cordenada x em relação o tamanho da tela atual com a cordenada normalizada
    private int dX(float x){
        return (int)(x * this.getWidth());
    }

    //normaliza a cordenada y
    private float nY(int y){return ((float)(y))/(this.getHeight());}

    //calcula a cordenada y em relação o tamanho da tela atual com a cordenada normalizada
    private int dY(float y){
        return (int)(y * this.getHeight());
    }


    public void reset(){
        this.primeiraVez = true;
        this.segundaVez = false;
        this.ultimaVez = false;
    }
}
