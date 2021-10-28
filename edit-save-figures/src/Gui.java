import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

@SuppressWarnings("serial")
class Gui extends JFrame {
    // Tipo Atual de primitivo
    private TipoPrimitivo tipoAtual = TipoPrimitivo.NENHUM;

    // Cor atual
    private Color corAtual = Color.BLACK;

    // Espessura atual do primitivo
    private int espAtual = 5;

    // Componentes de GUI
    // barra de menu (inserir componente)
    private JToolBar barraComandos = new JToolBar();

    // mensagens
    private JLabel msg = new JLabel("Msg: ");

    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipoAtual, corAtual, 10);

    // Botoes
    private JButton jbPonto = new JButton("Ponto");
    private JButton jbReta = new JButton("Reta");
    private JButton jbCirculo = new JButton("Circulo");
    private JButton jbTriangulo = new JButton("Triangulo");
    private JButton jbRetangulo = new JButton("Retangulo");
    private JButton jbPoligono = new JButton("Poligono");
    private JButton jbLimpar = new JButton("Limpar");
    private JButton jbCor = new JButton("Cor");
    private JButton jbSair = new JButton("Sair");
    private JButton jbSalvar = new JButton("Salvar");
    private JButton jbCarregar = new JButton("Carregar");

    // Entrada (slider) para definir espessura dos primitivos
    private JLabel jlEsp = new JLabel("   Espessura: " + String.format("%-5s", 5));
    private JSlider jsEsp = new JSlider(1, 50, 5);

    // Construtor
    public Gui(int larg, int alt) {
        /**
         * Definicoes de janela
         */
        super("Testa Primitivos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);

        barraComandos.add(jbPonto);
        barraComandos.add(jbReta);
        barraComandos.add(jbCirculo);
        barraComandos.add(jbTriangulo);
        barraComandos.add(jbRetangulo);
        barraComandos.add(jbPoligono);
        barraComandos.add(jbCor); // Botao de Cores
        barraComandos.add(jbLimpar); // Botao de Limpar
        barraComandos.add(jbCarregar);
        barraComandos.add(jbSalvar);

        barraComandos.add(jlEsp); // Label para espessura
        barraComandos.add(jsEsp);    // Slider para espacamento
        areaDesenho.setEsp(espAtual); // define a espessura inicial
        barraComandos.add(jbSair); // Botao de sair

        // adiciona os componentes com os respectivos layouts
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);

        // Adiciona "tratador" ("ouvidor") de eventos para 
        // cada componente
        jbPonto.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.PONTO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.reset();
        });        
        jbReta.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETA;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.reset();
        });
        jbCirculo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.CIRCULO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.reset();
        });
        jbTriangulo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.TRIANGULO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.reset();
        });
        jbRetangulo.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETANGULO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.reset();
        });
        jbPoligono.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.POLIGONO;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.reset();
        });
        jbLimpar.addActionListener(e -> {
            areaDesenho.removeAll();
            tipoAtual = TipoPrimitivo.NENHUM;
            areaDesenho.setTipo(tipoAtual);
            areaDesenho.modelo.reset();
            areaDesenho.reset();
            jsEsp.setValue(5); // inicia slider (necessario para limpar ultimo primitivoda tela)
            repaint();
        });        
        jbCor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(null, "Escolha uma cor", msg.getForeground());
            if (c != null){ 
                corAtual = c; // pega do chooserColor 
            }
            areaDesenho.setCorAtual(corAtual); // cor atual
        });  
        jsEsp.addChangeListener(e -> {
            espAtual = jsEsp.getValue();
            jlEsp.setText("   Espessura: " + String.format("%-5s", espAtual));
            areaDesenho.setEsp(espAtual);        
        });        

        jbSair.addActionListener(e -> {
            System.exit(0);
        });

        jbSalvar.addActionListener(e -> {
            try {
                String nome = JOptionPane.showInputDialog(null,"Digite o nome do arquivo", "Salvar", JOptionPane.WARNING_MESSAGE);
                if (nome != null && !nome.equals("")){
                    areaDesenho.modelo.salvar(nome);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERRO ao salvar!", "ERRO", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        });

        jbCarregar.addActionListener(e ->{
            ArrayList<String> resultados = new ArrayList<String>();
            File[] arquivos = new File("./dadosSalvos").listFiles();
            for (File file : arquivos) {
                if (file.isFile()) {
                    resultados.add(file.getName());
                }
            }

            DefaultComboBoxModel model = new DefaultComboBoxModel<String>();
            for (String aNome : resultados){
                model.addElement(aNome);
            }
            if (model.equals(new DefaultComboBoxModel<String>())){
                model.addElement(" ");
            }
            JComboBox cb = new JComboBox(model);
            int result = JOptionPane.showConfirmDialog(null, cb, "Escolha um dos arquivos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                String arquivo = (String) cb.getSelectedItem();
                try {
                    areaDesenho.removeAll();
                    areaDesenho.modelo.reset();
                    areaDesenho.reset();
                    repaint();
                    jsEsp.setValue(5);
                    tipoAtual = TipoPrimitivo.CARREGAR;
                    areaDesenho.setTipo(tipoAtual);
                    areaDesenho.modelo.carregar(arquivo);
                    areaDesenho.corAtual = Color.BLACK;
                    areaDesenho.paintComponent(areaDesenho.getGraphics());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO ao carregar!", "ERRO", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                tipoAtual = TipoPrimitivo.CARREGAR;
                areaDesenho.setTipo(tipoAtual);
            }
        });
    }
}
