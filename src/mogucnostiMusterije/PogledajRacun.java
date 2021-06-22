package mogucnostiMusterije;

import enumi.*;
import main.MainRestoran;
import net.miginfocom.swing.MigLayout;
import ucitavanje.IstorijaPorudzbina;
import ucitavanje.Ucitavanje;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PogledajRacun extends JFrame {

    private Ucitavanje ucitavanje;
    private String brojStola;

    private JLabel brojStola1 = new JLabel("Broj stola");
    private JTextField tbrojStola1 = new JTextField(20);
    private JLabel racun = new JLabel("Racun");
    private JTextField tracun = new JTextField(20);
    private JButton plati = new JButton("Plati");
    private JButton odustani = new JButton("Odustani");

    public PogledajRacun(Ucitavanje ucitavanje, String brojStola) {
        this.ucitavanje = ucitavanje;
        this.brojStola = brojStola;
        setTitle("Racun");
        popunjavanjePolja();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initGUI();
        initActions();
        pack();
        setLocationRelativeTo(null);
    }

    private void popunjavanjePolja(){
        ArrayList<IstorijaPorudzbina> istorijaPorudzbina = ucitavanje.nadjiPorudzbine(brojStola);
        int prilog = ucitavanje.randomBroj(20,100);
        int obrok = ucitavanje.randomBroj(300,600);
        int pice = ucitavanje.randomBroj(150,500);

        int piceUkupno = 0;
        int prilogUkupno = 0;
        int obrokUkupno = 0;

        for(IstorijaPorudzbina istorijaPorudzbina1 : istorijaPorudzbina){
            GaziraniSokovi gaziraniSok = istorijaPorudzbina1.getGaziraniSokovi();
            if(gaziraniSok != GaziraniSokovi.Nista){
                piceUkupno++;
            }
            Voda voda = istorijaPorudzbina1.getVoda();
            if(voda != Voda.Nista){
                piceUkupno++;
            }
            NegaziraniSokovi negaziraniSokovi = istorijaPorudzbina1.getNegaziraniSokovi();
            if(negaziraniSokovi != NegaziraniSokovi.Nista){
                piceUkupno++;
            }
            Pice pice1 = istorijaPorudzbina1.getPica();
            if(pice1 != Pice.Nista){
                obrokUkupno++;
            }
            Paste paste = istorijaPorudzbina1.getPasta();
            if(paste != Paste.Nista){
                obrokUkupno++;
            }
            Prilozi priloziPasta = istorijaPorudzbina1.getPriloziZaPastu();
            if(priloziPasta != Prilozi.Nista){
                prilogUkupno++;
            }
            Prilozi priloziPica = istorijaPorudzbina1.getPriloziZaPicu();
            if(priloziPica != Prilozi.Nista){
                prilogUkupno++;
            }
        }
        int racun = (piceUkupno * pice) + (prilogUkupno * prilog) + (obrok * obrokUkupno);
        tracun.setText(String.valueOf(racun));
    }
    private void initGUI(){
        MigLayout layout = new MigLayout("wrap 2", "[][]", "[]20[][]20[]");
        setLayout(layout);
        add(racun);
        add(tracun);
        add(brojStola1);
        add(tbrojStola1);
        tbrojStola1.setEditable(false);
        tbrojStola1.setText(brojStola.replace("sto","Sto broj "));
        tracun.setEditable(false);
        add(new JLabel());
        add(plati,"split 2");
        add(odustani);
    }

    private void initActions(){
        plati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Uspesno ste platili racun.","Obavestenje",JOptionPane.INFORMATION_MESSAGE);
                ArrayList<IstorijaPorudzbina> nadjiPorudzbinu = ucitavanje.nadjiPorudzbine(brojStola);
                for(IstorijaPorudzbina istorijaPorudzbina : nadjiPorudzbinu){
                    istorijaPorudzbina.setPlatio(true);
                    istorijaPorudzbina.setCena(tracun.getText());
                }
                ucitavanje.snimiPorudzbine(MainRestoran.podaciIzFajla);
                PogledajRacun.this.setVisible(false);
                PogledajRacun.this.dispose();
            }
        });
        odustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PogledajRacun.this.setVisible(false);
                PogledajRacun.this.dispose();
            }
        });
    }
}
