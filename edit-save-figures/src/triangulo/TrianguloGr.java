package triangulo;

import ponto.PontoGr;
import reta.FiguraRetas;

import java.awt.*;

public class TrianguloGr {
    // Atributos do triangulo grafica
    int x1, y1, x2, y2, x3, y3;             // pontos do triangulo
    Color corTriangulo = Color.BLACK;       // cor do triangulo
    String nomeTriangulo = "";              // nome do triangulo
    int espTriangulo = 1;                   // espessura do triangulo

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

    public Color getCorTriangulo() {return corTriangulo;}

    public void setCorTriangulo(Color corTriangulo) {this.corTriangulo = corTriangulo;}

    public String getNomeTriangulo() {return nomeTriangulo;}

    public void setNomeTriangulo(String nomeTriangulo) {this.nomeTriangulo = nomeTriangulo;}

    public int getEspTriangulo() {return espTriangulo;}

    public void setEspTriangulo(int espTriangulo) {this.espTriangulo = espTriangulo;}

    public TrianguloGr(int x1, int y1, int x2, int y2, int x3, int y3, Color cor, String nome, int esp){
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setX3(x3);
        setY3(y3);
        setCorTriangulo(cor);
        setNomeTriangulo(nome);
        setEspTriangulo(esp);
    }
    public TrianguloGr(PontoGr p1, PontoGr p2, PontoGr p3, Color cor, String str, int esp){
        setX1((int)p1.getX());
        setY1((int)p1.getY());
        setX2((int)p2.getX());
        setY2((int)p2.getY());
        setX3((int)p3.getX());
        setY3((int)p3.getY());
        setCorTriangulo(cor);
        setNomeTriangulo(str);
        setEspTriangulo(esp);
    }

    void desenharTriangulo(Graphics g){
        FiguraRetas.desenharReta(g, x1, y1, x2, y2, "", getEspTriangulo(), getCorTriangulo());
        FiguraRetas.desenharReta(g, x2, y2, x3, y3, "", getEspTriangulo(), getCorTriangulo());
        FiguraRetas.desenharReta(g, x3, y3, x1, y1, "", getEspTriangulo(), getCorTriangulo());
    }
}
