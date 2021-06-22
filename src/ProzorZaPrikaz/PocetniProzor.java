package ProzorZaPrikaz;

import mogucnostiMusterije.Naruci_PogledajRacun;
import net.miginfocom.swing.MigLayout;
import ucitavanje.Ucitavanje;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PocetniProzor extends JFrame {

    private Ucitavanje ucitavanje;
    private JButton sto1 = new JButton("Sto broj 1");
    private JButton sto2 = new JButton("Sto broj 2");
    private JButton sto3 = new JButton("Sto broj 3");
    private JButton sto4 = new JButton("Sto broj 4");
    private JLabel lblPoruka;

    public PocetniProzor(Ucitavanje ucitavanje) {
        this.ucitavanje = ucitavanje;
        setTitle("Italijanski restoran");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGUI();
        initActions();
        pack();
        setLocationRelativeTo(null);
    }

    private void initGUI(){
        MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[][]20[]");
        setLayout(layout);
        this.lblPoruka = new JLabel("Dobrodošli u nas Italijanski restoran");
        add(lblPoruka, "span 2");
        add(sto1);
        add(sto2);
        add(sto3);
        add(sto4);
    }

    private void initActions(){
        sto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Naruci_PogledajRacun naruci_pogledajRacun = new Naruci_PogledajRacun(ucitavanje,"sto1");
                naruci_pogledajRacun.setVisible(true);
            }
        });
        sto2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Naruci_PogledajRacun naruci_pogledajRacun = new Naruci_PogledajRacun(ucitavanje,"sto2");
                naruci_pogledajRacun.setVisible(true);
            }
        });
        sto3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Naruci_PogledajRacun naruci_pogledajRacun = new Naruci_PogledajRacun(ucitavanje,"sto3");
                naruci_pogledajRacun.setVisible(true);
            }
        });
        sto4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Naruci_PogledajRacun naruci_pogledajRacun = new Naruci_PogledajRacun(ucitavanje,"sto4");
                naruci_pogledajRacun.setVisible(true);
            }
        });

    }


}
