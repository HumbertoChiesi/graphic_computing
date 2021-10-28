package modelos;

import java.awt.*;

//representa um triangulo para persistencia de dados
public class TrianguloJson {
    String nome;
    float[][] pontos;
    int[] cor;
    int esp;

    public TrianguloJson(){}

    public TrianguloJson(float x1, float y1, float x2, float y2, float x3, float y3, Color c, int esp){
        setpontos(new float[][] {{x1, y1}, {x2,y2}, {x3, y3}});
        setCor(new int[]{c.getRed(), c.getGreen(), c.getBlue()});
        setEsp(esp);
    }

    public void setNome(String nome) {this.nome = nome;}

    public String getNome() {return nome;}

    public void setpontos(float[][] pontos) {this.pontos = pontos;}

    public float[][] getpontos() {return pontos;}

    public void setCor(int[] cor) {this.cor = cor;}

    public int[] getCor() {return cor;}

    public void setEsp(int esp) {this.esp = esp;}

    public int getEsp() {return esp;}
}
