package retangulo;

import reta.FiguraRetas;

import java.awt.*;

public class RetanguloGr {
    // Atributos do retangulo grafica
    int x1, y1, x2, y2, x3, y3, x4, y4;             // pontos do retangulo
    Color corRetangulo = Color.BLACK;       // cor do retangulo
    String nomeRetangulo = "";              // nome do retangulo
    int espRetangulo = 1;                   // espessura do retangulo

    public int getX1() {return x1;}

    public void setX1(int x1) {this.x1 = x1;}

    public int getY1() {return y1;}

    public void setY1(int y1) {this.y1 = y1;}

    public int getX2() {return x2;}

    public void setX2(int x2) {this.x2 = x2;}

    public int getY2() {return y2;}

    public void setY2(int y2) {this.y2 = y2;}

    public int getX3() {return x3;}

    public void setX3(int x3) {this.x3 = x3;}

    public int getY3() {return y3;}

    public void setY3(int y3) {this.y3 = y3;}

    public int getX4() {return x4;}

    public void setX4(int x4) {this.x4 = x4;}

    public int getY4() {return y4;}

    public void setY4(int y4) {this.y4 = y4;}

    public Color getCorRetangulo() {return corRetangulo;}

    public void setCorRetangulo(Color corRetangulo) {this.corRetangulo = corRetangulo;}

    public int getEspRetangulo() {return espRetangulo;}

    public void setEspRetangulo(int espRetangulo) {this.espRetangulo = espRetangulo;}

    public String getNomeRetangulo() {return nomeRetangulo;}

    public void setNomeRetangulo(String nomeRetangulo) {this.nomeRetangulo = nomeRetangulo;}

    public RetanguloGr(int x1, int y1, int x2, int y2, Color cor, String nome, int esp){
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setCorRetangulo(cor);
        setNomeRetangulo(nome);
        setEspRetangulo(esp);
    }

    void calcularPontos(){
        double distancia = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        double auxX = y2-y1, auxY = (x2-x1)*-1;
        setX3(x1);
        setY3((y1 + (y2-y1)));
        setX4(x2);
        setY4((y2 + (y1-y2)));
    }

    void desenharRetangulo(Graphics g){
        calcularPontos();
        FiguraRetas.desenharReta(g, x1, y1, x3, y3, "", getEspRetangulo(), getCorRetangulo());
        FiguraRetas.desenharReta(g, x3, y3, x2, y2, "", getEspRetangulo(), getCorRetangulo());
        FiguraRetas.desenharReta(g, x2, y2, x4, y4, "", getEspRetangulo(), getCorRetangulo());
        FiguraRetas.desenharReta(g, x4, y4, x1, y1, "", getEspRetangulo(), getCorRetangulo());
    }
}
