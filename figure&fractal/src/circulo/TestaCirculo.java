package circulo;
import ponto.Ponto;

/**
 * Aplicacao para testar primitivos graficos.
 * 
 * @author Humberto Chiesi Neto e Matheus Madureira Fortunato
 * @version 13/09/2021
 */
public class TestaCirculo
{
    public static void main(String args[]) {
        Ponto p = new Ponto(23.5, 45.7);
        Circulo c = new Circulo(10, 10, 20);
        Circulo c1 = new Circulo(c);
        Circulo c2 = new Circulo(p, 22);
        System.out.println(c);
        System.out.println(c1);
        System.out.println(c2);
    }
}