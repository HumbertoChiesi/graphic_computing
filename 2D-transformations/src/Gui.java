import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
class Gui extends JFrame implements WindowListener {
    // Tipo Atual de primitivo
    private TipoPrimitivo tipoAtual = TipoPrimitivo.NENHUM;

    // Componentes de GUI
    // barra de menu (inserir componente)
    private JToolBar barraComandos = new JToolBar();

    // mensagens
    private JLabel msg = new JLabel("Msg: ");

    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipoAtual);

    // Botoes
    private JButton jbTranslacao = new JButton("Translacao");
    private JButton jbRotacao = new JButton("Rotacao");
    private JButton jbEscala = new JButton("Escala");
    private JButton jbResetar = new JButton("Resetar");
    private JButton jbSair = new JButton("Sair");

    // Construtor
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Testa Primitivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        this.addWindowListener(this);
        setVisible(true);

        // Adiciona os componentes na barra de comandos
        barraComandos.add(jbTranslacao);
        barraComandos.add(jbRotacao);
        barraComandos.add(jbEscala);
        barraComandos.add(jbResetar);
        barraComandos.add(jbSair); // Botao de Cores

        // adiciona os componentes com os respectivos layouts
        add(barraComandos, BorderLayout.NORTH);
        add(areaDesenho, BorderLayout.CENTER);
        msg.setForeground(Color.BLUE);
        add(msg, BorderLayout.SOUTH);

        // Adiciona "tratador" ("ouvidor") de eventos e respectivas a��es para
        // cada componente
        jbTranslacao.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.TRANSLACAO;
            areaDesenho.setTipo(tipoAtual);
        });
        jbRotacao.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.ROTACAO;
            areaDesenho.setTipo(tipoAtual);
        });
        jbEscala.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.ESCALA;
            areaDesenho.setTipo(tipoAtual);
        });
        jbResetar.addActionListener(e ->{
            tipoAtual = TipoPrimitivo.NENHUM;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.reset(areaDesenho.getGraphics());
        });
        jbSair.addActionListener(e -> {
            System.exit(0);
        });
        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                tipoAtual = TipoPrimitivo.CARREGAR;
                areaDesenho.setTipo(tipoAtual);
            }
        });
    }

    //trata o evento de janela aberta
    @Override
    public void windowOpened(WindowEvent e) {
        Graphics g = areaDesenho.getGraphics();
        areaDesenho.desenharAbriu(g);
    }

    @Override
    public void windowClosing(WindowEvent e) {}
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}

}
