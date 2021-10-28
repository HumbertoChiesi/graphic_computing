import java.util.*;
import java.awt.Color;
import java.awt.Graphics;
import reta.*;

public class CurvaoDragao {
    public Object [] viradas;
    public double angulo_inicial, lado;
    public Graphics gr;
    public int meio_vertical;
    //Interacoes do slider.
    public CurvaoDragao(int iter, Graphics g, int meio_tela, int meio_vertical) {
        this.gr= g;
        viradas = sequencia_viradas(iter);
        angulo_inicial = -iter * (Math.PI / 4);
        lado = meio_tela / Math.pow(2, iter / 2.);
        this.meio_vertical = meio_vertical;
    }
 
    public Object [] sequencia_viradas(int iteracoes) {
        List<Integer> lista_viradas = new ArrayList<Integer>();
        for (int i = 0 ; i < iteracoes; i++) {
            List<Integer> aux = new ArrayList<Integer>(lista_viradas);
            Collections.reverse(aux);
            lista_viradas.add(1);
            for(int j=0; j<aux.size(); j++){
                int virada = aux.get(j);
                lista_viradas.add(-virada);
            }
        }
        return  lista_viradas.toArray();
    }
 
    public void desenha() {
        // this.gr.setColor(Color.black);
        double angulo = angulo_inicial;
        int x1 = 230, y1 = this.meio_vertical;
        int x2 = x1 + (int) (Math.cos(angulo) * lado);
        int y2 = y1 + (int) (Math.sin(angulo) * lado);
        RetaGr r= new RetaGr(x1, y1, x2, y2, Color.black, "", 2);
        r.desenharRetaMp(this.gr);
        x1 = x2;
        y1 = y2;
        for(int i =0; i<viradas.length; ++i){
            int virada = (int) viradas[i];
            angulo += virada * (Math.PI / 2);
            x2 = x1 + (int) (Math.cos(angulo) *lado);
            y2 = y1 + (int) (Math.sin(angulo) * lado);
            r= new RetaGr(x1, y1, x2, y2, Color.black, "", 2);
            r.desenharRetaMp(this.gr);
            // this.gr.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
        
    }


}
