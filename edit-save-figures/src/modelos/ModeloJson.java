package modelos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

//classe que sera salva no arquivo json,
//guarda todos dados necessario de cada figura e primitivo para a persistencia de dados
public class ModeloJson {
    //arrays que guardam os dados de todas as figuras e primitivos adicionados
    ArrayList<PontoJson> pontos;
    ArrayList<RetaJson> retas;
    ArrayList<CirculoJson> circulos;
    ArrayList<TrianguloJson> triangulos;
    ArrayList<RetanguloJson> retangulos;
    ArrayList<PoligonoJson> poligonos;

    public ArrayList<PontoJson> getPontos() {return pontos;}
    public void setPontos(ArrayList<PontoJson> pontos) {this.pontos = pontos;}
    public ArrayList<RetaJson> getRetas() {return retas;}
    public void setRetas(ArrayList<RetaJson> retas) {this.retas = retas;}
    public ArrayList<CirculoJson> getCirculos() {return circulos;}
    public void setCirculos(ArrayList<CirculoJson> circulos) {this.circulos = circulos;}
    public ArrayList<TrianguloJson> getTriangulos() {return triangulos;}
    public void setTriangulos(ArrayList<TrianguloJson> triangulos) {this.triangulos = triangulos;}
    public ArrayList<RetanguloJson> getRetangulos() {return retangulos;}
    public void setRetangulos(ArrayList<RetanguloJson> retangulos) {this.retangulos = retangulos;}
    public void setPoligonos(ArrayList<PoligonoJson> poligonos) {this.poligonos = poligonos;}
    public ArrayList<PoligonoJson> getPoligonos() {return poligonos;}

    public ModeloJson(){
        this.pontos = new ArrayList<>();
        this.retas = new ArrayList<>();
        this.circulos = new ArrayList<>();
        this.triangulos = new ArrayList<>();
        this.retangulos = new ArrayList<>();
        this.poligonos = new ArrayList<>();
    }

    //salva os dados das figuras e primitivos que estão nos arrays em um arquivo json
    public void salvar(String arquivo) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        Files.createDirectories(Paths.get("./dadosSalvos"));
        File f = new File("./dadosSalvos/"+arquivo+".json");
        mapper.writeValue(f, this);
    }

    //le os dados das figuras e primitivos de um arquivo json e salva nos arrays
    public void carregar(String arquivo) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        File f = new File("./dadosSalvos/"+arquivo);
        ModeloJson m = mapper.readValue(f, ModeloJson.class);
        this.reset();
        this.setPontos(m.getPontos());
        this.setRetas(m.getRetas());
        this.setCirculos(m.getCirculos());
        this.setTriangulos(m.getTriangulos());
        this.setRetangulos(m.getRetangulos());
        this.setPoligonos(m.getPoligonos());
    }

    //adiciona um pontoJson no array pontos
    public void addPonto(float x, float y, Color c, int esp){
        PontoJson p = new PontoJson(x, y, c, esp);
        p.setNome("ponto" + (pontos.size() + 1));
        this.pontos.add(p);
    }

    //adiciona uma retaJson no array retas
    public void addReta(float x1, float y1, float x2, float y2, Color c, int esp){
        RetaJson r = new RetaJson(x1, y1, x2, y2, c, esp);
        r.setNome("reta"+ (retas.size() + 1));
        this.retas.add(r);
    }

    //adiciona um circuloJson no array circulo
    public void addCirculo(float x1, float y1, float r, Color c, int esp){
        CirculoJson circulo = new CirculoJson(x1, y1, r, c, esp);
        circulo.setNome("circulo"+(circulos.size()+1));
        this.circulos.add(circulo);
    }

    //adiciona um trianguloJson no array triangulos
    public void addTriangulo(float x1, float y1, float x2, float y2, float x3, float y3, Color c, int esp){
        TrianguloJson t = new TrianguloJson(x1, y1, x2, y2, x3, y3, c, esp);
        t.setNome("triangulo"+ (triangulos.size()+1));
        this.triangulos.add(t);
    }

    //adiciona um retanguloJson no array retangulos
    public void addRetangulo(float x1, float y1, float x2, float y2, Color c, int esp){
        RetanguloJson r = new RetanguloJson(x1, y1, x2, y2, c, esp);
        r.setNome("retangulo"+ (retangulos.size() + 1));
        this.retangulos.add(r);
    }

    //adiciona um poligonoJson no array poligonos
    public void addPoligono(ArrayList<Float[]> p, Color c, int esp){
        PoligonoJson poligono = new PoligonoJson(p, c, esp);
        poligono.setNome("poligono"+(poligonos.size()+1));
        this.poligonos.add(poligono);
    }

    //reseta o modeloJson limpando todos os arrays
    public void reset() {
        this.pontos.clear();
        this.retas.clear();
        this.circulos.clear();
        this.triangulos.clear();
        this.retangulos.clear();
        this.poligonos.clear();
    }
}

