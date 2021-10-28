package poligono;

import reta.FiguraRetas;

import java.awt.*;
import java.util.ArrayList;

public class PoligonoGr {
    // Atributos do poligono grafica
    ArrayList<Integer[]> pontos;            // pontos do poligono
    Color corPoligono = Color.BLACK;       // cor do poligono
    String nomePoligono = "";              // nome do poligono
    int espPoligono = 1;                   // espessura do poligono

    public ArrayList<Integer[]> getPontos() {return pontos;}

    public void setPontos(ArrayList<Integer[]> pontos) {this.pontos = pontos;}

    public Color getCorpoligono() {return corPoligono;}

    public void setCorpoligono(Color corpoligono) {this.corPoligono = corpoligono;}

    public String getNomepoligono() {return nomePoligono;}

    public void setNomepoligono(String nomepoligono) {this.nomePoligono = nomepoligono;}

    public int getEsppoligono() {return espPoligono;}

    public void setEsppoligono(int esppoligono) {this.espPoligono = esppoligono;}

    public PoligonoGr(){}

    public PoligonoGr(int x1, int y1, String nome, Color cor, int esp){
        setPontos(new ArrayList<>());
        pontos.add(new Integer[]{x1, y1});
        setCorpoligono(cor);
        setNomepoligono(nome);
        setEsppoligono(esp);
    }

    public void novaAresta(Graphics g, int x, int y){
        int x2 = getPontos().get(pontos.size()-1)[0];
        int y2 = getPontos().get(pontos.size()-1)[1];
        FiguraRetas.desenharReta(g, x, y, x2, y2, "", getEsppoligono(), getCorpoligono());
        pontos.add(new Integer[]{x, y});
    }

    public void ultimaAresta(Graphics g, int x, int y){
        int x2 = getPontos().get(pontos.size()-1)[0];
        int y2 = getPontos().get(pontos.size()-1)[1];
        FiguraRetas.desenharReta(g, x, y, x2, y2, "", getEsppoligono(), getCorpoligono());
        int x3 = getPontos().get(0)[0];
        int y3 = getPontos().get(0)[1];
        FiguraRetas.desenharReta(g, x, y, x3, y3, "", getEsppoligono(), getCorpoligono());
        pontos.add(new Integer[]{x, y});
    }

}
