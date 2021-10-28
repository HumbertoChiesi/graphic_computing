package CalculosPontos;

//classe que guarda todos os pontos do triangulo e aplica as transformações em cada ponto
public class CalculoPontos {
    //pontos do triangulo
    int[][] tPontos;
    //diferenca de x e y de cada ponto do triangulo até o seu baricentro
    int[][] dBaricentro;

    //matrizes para transformacoes
    float[][] matriz;
    int[] mAux;
    int[] mResultante = {0, 0, 0};

    //seno e coseno para utilizar na rotacao
    float cos, sin;

    public int getX1(){return tPontos[0][0];}

    public int getY1(){return tPontos[0][1];}

    public int getX2(){return tPontos[1][0];}

    public int getY2(){return tPontos[1][1];}

    public int getX3(){return tPontos[2][0];}

    public int getY3(){return tPontos[2][1];}

    public int[][] gettPontos() {return tPontos;}

    public void settPontos(int[][] tPontos){this.tPontos = tPontos;}

    public int[][] getdBaricentro() {return dBaricentro;}

    public void setdBaricentro(int[][] dBaricentro) {this.dBaricentro = dBaricentro;}

    public float[][] getMatriz() {return matriz;}

    public void setMatriz(float[][] matriz) {this.matriz = matriz;}

    public int[] getmAux() {return mAux;}

    public void setmAux(int[] mAux) {this.mAux = mAux;}

    public int[] getmResultante() {return mResultante;}

    public void setmResultante(int[] mResultante) {this.mResultante = mResultante;}

    public float getCos() {return cos;}

    public void setCos(float cos) {this.cos = cos;}

    public float getSin() {return sin;}

    public void setSin(float sin) {this.sin = sin;}

    public CalculoPontos(int x, int y){
        dBaricentro = new int[][]{
                {0, -60}, {-60, 45}, {60, 45}
        };
        tPontos = new int[][]{
                {x, y+dBaricentro[0][1]},
                {x+dBaricentro[1][0], y+dBaricentro[1][1]},
                {x+dBaricentro[2][0], y+dBaricentro[2][1]}
        };
    }

    //aplica a translação em cada ponto do triangulo
    //x1, y1 ponto de referência para translação
    public void calcularTranslacao(int x1, int y1){
        for (int i=0;i<3;i++){
            tPontos[i][0] += (x1-tPontos[i][0]) + dBaricentro[i][0];
            tPontos[i][1] += (y1-tPontos[i][1]) + dBaricentro[i][1];
        }
    }

    //aplica a rotacao em cada ponto do triangulo
    //parametros: x1, y1 ponto de referência para rotação e o angulo da rotação
    public void calcularRotacao(int x1, int y1, int angulo){
        sin = (float)Math.sin(angulo*Math.PI/180); cos = (float)Math.cos(angulo*Math.PI/180);
        matriz = new float[][] {
                {cos, -sin, x1*(1-cos)+y1*sin},
                {sin, cos, y1*(1-cos)-x1*sin},
                {0, 0, 1}
        };
        int soma;
        for (int i = 0; i<3;i++){
            mAux = new int[] {tPontos[i][0], tPontos[i][1], 1};
            for (int j=0; j<3;j++){
                soma = 0;
                for (int k=0; k<3;k++){
                    soma += matriz[j][k] * mAux[k];
                }
                mResultante[j] = soma;
            }
            tPontos[i][0] = mResultante[0];
            tPontos[i][1] = mResultante[1];
        }
        int xB = (tPontos[0][0]+tPontos[1][0]+tPontos[2][0])/3;
        int yB = (tPontos[0][1]+tPontos[1][1]+tPontos[2][1])/3;
        dBaricentro = new int[][]{
                {tPontos[0][0]-xB, tPontos[0][1]-yB},
                {tPontos[1][0]-xB, tPontos[1][1]-yB},
                {tPontos[2][0]-xB, tPontos[2][1]-yB}
        };
    }

    //aplica a escala em cada ponto do triangulo
    //x1, y1 ponto de referência para a escala
    public void calcularEscala(int x1, int y1, float escala){
        matriz = new float[][]{
                {escala, 0, x1*(1-escala)}, {0, escala, y1*(1-escala)}, {0, 0, 1}
        };
        int soma;
        for (int i = 0; i<3;i++){
            mAux = new int[] {tPontos[i][0], tPontos[i][1], 1};
            for (int j=0; j<3;j++){
                soma = 0;
                for (int k=0; k<3;k++){
                    soma += matriz[j][k] * mAux[k];
                }
                mResultante[j] = soma;
            }
            tPontos[i][0] = mResultante[0];
            tPontos[i][1] = mResultante[1];
        }
        int xB = (tPontos[0][0]+tPontos[1][0]+tPontos[2][0])/3;
        int yB = (tPontos[0][1]+tPontos[1][1]+tPontos[2][1])/3;
        dBaricentro = new int[][]{
                {tPontos[0][0]-xB, tPontos[0][1]-yB},
                {tPontos[1][0]-xB, tPontos[1][1]-yB},
                {tPontos[2][0]-xB, tPontos[2][1]-yB}
        };
    }
}
