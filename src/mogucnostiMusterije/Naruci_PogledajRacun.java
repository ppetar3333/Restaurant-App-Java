package mogucnostiMusterije;

import net.miginfocom.swing.MigLayout;
import ucitavanje.IstorijaPorudzbina;
import ucitavanje.Ucitavanje;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Naruci_PogledajRacun extends JFrame {

    private Ucitavanje ucitavanje;
    private JButton naruci = new JButton("Poruci");
    private JButton pogledajRacun = new JButton("Pogledaj racun");
    private String brojStola;

    public Naruci_PogledajRacun(Ucitavanje ucitavanje, String brojStola){
        this.ucitavanje = ucitavanje;
        this.brojStola = brojStola;
        setTitle("Italijanski restoran " + brojStola.replace("sto","Sto broj "));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGUI();
        initActions();
        pack();
        setLocationRelativeTo(null);
    }

    private void initGUI(){
        MigLayout layout = new MigLayout("wrap 2");
        setLayout(layout);
        add(naruci);
        add(pogledajRacun);
    }

    private void initActions(){
        naruci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IstorijaPorudzbina istorijaPorudzbina = ucitavanje.neplaceniSto(brojStola);
                if(istorijaPorudzbina == null) {
                    Naruci naruci = new Naruci(ucitavanje, brojStola);
                    naruci.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Morate prvo platiti pa naruciti.","Obavestenje",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        pogledajRacun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IstorijaPorudzbina istorijaPorudzbina = ucitavanje.neplaceniSto(brojStola);
                if(istorijaPorudzbina != null) {
                    PogledajRacun pogledajRacun = new PogledajRacun(ucitavanje, brojStola);
                    pogledajRacun.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Svi racuni su placeni","Obavestenje",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

}
