package main.java;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ImprimirExcluir extends JFrame {
    private JPanel painel;
    private JTable table1;
    private JScrollPane scrollPane1;
    private JButton btImprimir;
    private JButton btExcluir;
    private JButton btSair;
    private JList list1;
    private JComboBox cbBox;

    private Passeio passeio = new Passeio();
    private BDVeiculos bdVeiculos = new BDVeiculos();

    String header[] = {"Placa", "Marca", "Modelo", "Cor", "Qtd. Rodas", "Velocidade Máxima", "Qtd. Pistão", "Potência", "Qtd. Passageiros"};


    public ImprimirExcluir(String title) {
        super(title);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(painel);
        this.pack();

        btImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimir();
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectTab();
            }
        });
        cbBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preencherCombo();
                selectCombo();
            }
        });
        list1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                preencherLista();
                selectLista();
            }
        });
    }


    public void sair() {
        int resp = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Sair", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resp == 0) {
            this.dispose();
        }
    }


    //selecionar o item da tabela ao clicar na linha
    public void selectTab() {
        String valLinTab = "";
        int posLin = table1.getSelectedRow();

        for (int coluna = 0; coluna < table1.getColumnCount(); coluna++) {
            valLinTab += table1.getModel().getValueAt(posLin, coluna).toString();

            if (coluna + 1 < table1.getColumnCount()) {
                valLinTab += " - ";
            }
        }
        JOptionPane.showMessageDialog(null, "Os valores da linha " + posLin + "è: " + valLinTab, "Seleção de Tabela", 1);
    }


    public void preencherLista() {
        DefaultListModel modLista = new DefaultListModel();

        for (Passeio passeio : bdVeiculos.getListaPasseio()) {
            modLista.addElement(passeio.getPlaca() + "-" + passeio.getModelo() + "-" + passeio.getMarca() + "-" + passeio.getCor() + "-" + passeio.getQtdPassageiros() + "-" + passeio.getVelocMax() + "-" + passeio.getQtdRodas() + "-" + passeio.getMotor().getPontencia() + "-" + passeio.getMotor().getQtdPist());
        }
        list1.setModel(modLista);
    }

    public void selectLista() {
        String valLinList = "";
        int posLin = list1.getSelectedIndex();
        valLinList = list1.getSelectedValue().toString();

        JOptionPane.showMessageDialog(null, "Os valores da linha " + posLin + "è: " + valLinList, "Seleção de Tabela", 1);
    }

    public void preencherCombo() {
        cbBox.removeAllItems();
        cbBox.addItem("Escolha uma opção");

        for (Passeio passeio : bdVeiculos.getListaPasseio()) {
            cbBox.addItem(passeio.getPlaca() + "-" + passeio.getModelo() + "-" + passeio.getMarca() + "-" + passeio.getCor() + "-" + passeio.getQtdPassageiros() + "-" + passeio.getVelocMax() + "-" + passeio.getQtdRodas() + "-" + passeio.getMotor().getPontencia() + "-" + passeio.getMotor().getQtdPist());
        }
    }

    public void selectCombo() {
        int posLin = cbBox.getSelectedIndex();
        if (cbBox.getSelectedIndex() >= 1) {
            String valLinComb = cbBox.getSelectedItem().toString();
            JOptionPane.showMessageDialog(null, "Os valores da linha " + posLin + "è: " + valLinComb, "Seleção de ComboBox", 1);
        }
    }

    public void imprimir() {
        DefaultTableModel modelo = (DefaultTableModel) table1.getModel();
        int poslin = 0;
        modelo.setRowCount(poslin);


        for (Passeio passeio : bdVeiculos.getListaPasseio()) {
            modelo.insertRow(poslin, new Object[]{passeio.getPlaca(), passeio.getMarca(), passeio.getModelo(), passeio.getCor(), passeio.getQtdRodas(), passeio.getVelocMax(), passeio.getMotor().getQtdPist(), passeio.getMotor().getPontencia(), passeio.getQtdPassageiros()});
            poslin++;
        }
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        painel = new JPanel();
        painel.setLayout(new GridBagLayout());
        painel.setAlignmentX(1.0f);
        painel.setAlignmentY(1.0f);
        painel.setBackground(new Color(-13684945));
        painel.putClientProperty("html.disable", Boolean.FALSE);
        scrollPane1 = new JScrollPane();
        scrollPane1.setBackground(new Color(-13684945));
        scrollPane1.setForeground(new Color(-1));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        painel.add(scrollPane1, gbc);
        table1 = new JTable();
        table1.setAutoResizeMode(4);
        table1.setDropMode(DropMode.INSERT_ROWS);
        scrollPane1.setViewportView(table1);
        btImprimir = new JButton();
        btImprimir.setForeground(new Color(-16382458));
        btImprimir.setText("Imprimir todos");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(btImprimir, gbc);
        btSair = new JButton();
        btSair.setForeground(new Color(-16382458));
        btSair.setText("Sair");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(btSair, gbc);
        btExcluir = new JButton();
        btExcluir.setForeground(new Color(-16382458));
        btExcluir.setText("Excluir todos");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(btExcluir, gbc);
        list1 = new JList();
        final DefaultListModel defaultListModel1 = new DefaultListModel();
        defaultListModel1.addElement("Lista de Veículos cadastrado no sistema.");
        list1.setModel(defaultListModel1);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        painel.add(list1, gbc);
        cbBox = new JComboBox();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(cbBox, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return painel;
    }

}
