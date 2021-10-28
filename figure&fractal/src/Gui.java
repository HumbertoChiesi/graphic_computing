import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
class Gui extends JFrame {
    // Tipo Atual de primitivo
    private TipoPrimitivo tipoAtual = TipoPrimitivo.NENHUM;

    // Cor atual
    private Color corAtual = Color.BLACK;

    // Espessura atual do primitivo
    private int espAtual = 1;

    // Componentes de GUI
    // barra de menu (inserir componente)
    private JToolBar barraComandos = new JToolBar();

    // mensagens
    private JLabel msg = new JLabel("Msg: ");

    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipoAtual, corAtual, 10);

    private JButton jbRetaMp = new JButton("Curva");
    private JButton jbCirculoEq = new JButton("Curva do Dragao");
    private JButton jbLimpar = new JButton("Limpar");
    private JButton jbSair = new JButton("Sair");

    private JLabel jlEsp = new JLabel("   Tamanho da Curva: " + String.format("%-5s", 1));
    private JSlider jsEsp = new JSlider(1, 15, 1);

    // Construtor
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Curvas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);

        barraComandos.add(jbRetaMp);
        barraComandos.add(jbCirculoEq);
        barraComandos.add(jbLimpar); // Botao de Limpar

        barraComandos.add(jlEsp); // Label para espessura
        barraComandos.add(jsEsp);    // Slider para espacamento
        areaDesenho.setEsp(espAtual); // define a espessura inicial
        barraComandos.add(jbSair); // Botao de Cores

        // adiciona os componentes com os respectivos layouts
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);
    
        jbRetaMp.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.CURVA;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.removeAll();
            repaint();
        });        
        jbCirculoEq.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.CURVA_DRAGAO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.removeAll();     
            repaint();
        });         
        jbLimpar.addActionListener(e -> {
            areaDesenho.removeAll();
            jsEsp.setValue(0); // inicia slider (necessario para limpar ultimo primitivoda tela) 
            repaint();        
        });        
        jsEsp.addChangeListener(e -> {
            espAtual = jsEsp.getValue();
            jlEsp.setText("   Tamanho: " + String.format("%-5s", espAtual));
            areaDesenho.setEsp(espAtual); 
            repaint();       
        });        

        jbSair.addActionListener(e -> {
            System.exit(0);
        });        
    }
}
