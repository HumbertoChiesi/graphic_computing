import javax.swing.*;
import java.awt.*;
import circulo.*;
import ponto.PontoGr;
import reta.RetaGr;

public class linesAndCircles extends JPanel {
    int cx;
    int cy;
    int circleSize;
    private int x[];
    private int y[];
    Graphics gr;

    public linesAndCircles(int size, Graphics g, int largura, int altura){
        this.circleSize = size;
        this.gr = g;
        this.cx =largura;
        this.cy = altura;
    }

    public void drawFigure(){
        double angle;
        int i, j;
        x = new int[6];
        y = new int[6];

        for(i=0 ; i < 6;i++) {
            angle = i * (360/6);

            x[i] = (int) (cx + circleSize/2 * Math.cos(Math.toRadians(angle)));
            y[i] = (int) (cy + circleSize/2 * Math.sin(Math.toRadians(angle)));

            new RetaGr(cx, cy, x[i], y[i], Color.red, "", 3).desenharRetaEq(this.gr);
        }
        new CirculoGr(this.cx, this.cy, this.circleSize/2, Color.green, "", 3).desenharCirculoEq(this.gr);

        for (j = 0; j<6; j++){
            new CirculoGr(x[j], y[j], this.circleSize/2, Color.green, "", 3).desenharCirculoEq(this.gr);
            new PontoGr(x[j], y[j], Color.BLUE, "", 9).desenharPonto(this.gr);
            
            if (j>0){
                new RetaGr(x[j-1], y[j-1], x[j], y[j], Color.red, "", 3).desenharRetaEq(this.gr);;
            } else {
                new RetaGr(x[5], y[5], x[j], y[j], Color.red, "", 3).desenharRetaEq(this.gr);
            }
        }

        int xAux = (x[5] + x[5] - x[4]) - cx;
        int yAux = y[5] - cy;
        int auxR = (int) Math.sqrt(xAux * xAux + yAux * yAux);

        this.x[0] = cx - xAux; this.y[0] = cy + yAux;
        this.x[1] = cx; this.y[1] = cy - auxR;
        this.x[2] = cx + xAux; this.y[2] = cy + yAux;
        this.x[3] = cx + xAux; this.y[3] = cy - yAux;
        this.x[4] = cx; this.y[4] = cy + auxR;
        this.x[5] = cx - xAux; this.y[5] = cy - yAux;

        for (j = 0; j < 6; j++){
            new PontoGr(x[j], y[j], Color.BLUE, "", 9).desenharPonto(this.gr);
            for (i = j; i < 6; i++){
                new RetaGr(x[j], y[j], x[i], y[i], Color.red, "", 3).desenharRetaEq(this.gr);
            }
        }


    }

}