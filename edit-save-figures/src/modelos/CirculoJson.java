package modelos;

import java.awt.*;

//representa um circulo para persistencia de dados
public class CirculoJson {
    String nome;
    float[] centro;
    float raio;
    int[] cor;
    int esp;

    public CirculoJson(){}

    public CirculoJson(float x, float y, float r, Color c, int esp){
        setcentro(new float[]{x, y});
        setRaio(r);
        setCor(new int[]{c.getRed(), c.getGreen(), c.getBlue()});
        setEsp(esp);
    }

    public void setNome(String nome) {this.nome = nome;}

    public String getNome() {return nome;}

    public void setcentro(float[] centro) {this.centro = centro;}

    public float[] getcentro() {return centro;}

    public float getRaio() {return raio;}

    public void setRaio(float raio) {this.raio = raio;}

    public void setCor(int[] cor) {this.cor = cor;}

    public int[] getCor() {return cor;}

    public void setEsp(int esp) {this.esp = esp;}

    public int getEsp() {return esp;}
}
