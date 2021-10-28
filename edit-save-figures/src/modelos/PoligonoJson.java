package modelos;

import java.awt.*;
import java.util.ArrayList;

//representa um poligono para persistencia de dados
public class PoligonoJson {
    String nome;
    ArrayList<Float[]> pontos;
    int[] cor;
    int esp;

    public PoligonoJson(){}

    public PoligonoJson(ArrayList<Float[]> p, Color c, int esp){
        setpontos(new ArrayList<>(p));
        setCor(new int[]{c.getRed(), c.getGreen(), c.getBlue()});
        setEsp(esp);
    }

    public void setNome(String nome) {this.nome = nome;}

    public String getNome() {return nome;}

    public void setpontos(ArrayList<Float[]> pontos) {this.pontos = pontos;}

    public ArrayList<Float[]> getpontos() {return pontos;}

    public void setCor(int[] cor) {this.cor = cor;}

    public int[] getCor() {return cor;}

    public void setEsp(int esp) {this.esp = esp;}

    public int getEsp() {return esp;}
}
