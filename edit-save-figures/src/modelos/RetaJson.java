package modelos;

import java.awt.*;

//representa uma reta para persistencia de dados
public class RetaJson {
    String nome;
    float[][] pontos;
    int[] cor;
    int esp;

    public RetaJson(){}

    public RetaJson(float x1, float y1, float x2, float y2, Color c, int esp){
        setpontos(new float[][] {{x1, y1}, {x2,y2}});
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

