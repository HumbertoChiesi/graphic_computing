package modelos;

import java.awt.*;

//representa um ponto para persistencia de dados
public class PontoJson{
    String nome;
    float[] coord;
    int[] cor;
    int esp;

    public PontoJson(){}

    public PontoJson(float x, float y, Color c, int esp){
        setCoord(new float[]{x, y});
        setCor(new int[]{c.getRed(), c.getGreen(), c.getBlue()});
        setEsp(esp);
    }

    public void setNome(String nome) {this.nome = nome;}

    public String getNome() {return nome;}

    public void setCoord(float[] coord) {this.coord = coord;}

    public float[] getCoord() {return coord;}

    public void setCor(int[] cor) {this.cor = cor;}

    public int[] getCor() {return cor;}

    public void setEsp(int esp) {this.esp = esp;}

    public int getEsp() {return esp;}
}