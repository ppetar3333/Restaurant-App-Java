package mogucnostiMusterije;

import enumi.*;
import main.MainRestoran;
import net.miginfocom.swing.MigLayout;
import ucitavanje.IstorijaPorudzbina;
import ucitavanje.Ucitavanje;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Naruci extends JFrame {

    private Ucitavanje ucitavanje;
    private JLabel pice = new JLabel("Pice");
    private JComboBox<Pice> piceJComboBox = new JComboBox<>(Pice.values());
    private JLabel paste = new JLabel("Paste");
    private JComboBox<Paste> pasteJComboBox = new JComboBox<>(Paste.values());
    private JLabel priloziZaPicu = new JLabel("Prilozi za picu");
    private JComboBox<Prilozi> priloziPicaJComboBox = new JComboBox<>(Prilozi.values());
    private JLabel priloziZaPastu = new JLabel("Prilozi za pastu");
    private JComboBox<Prilozi> priloziPastaJComboBox = new JComboBox<>(Prilozi.values());
    private JLabel gaziraniSok = new JLabel("Gazirani sokovi");
    private JComboBox<GaziraniSokovi> gaziraniSokoviJComboBox = new JComboBox<>(GaziraniSokovi.values());
    private JLabel negaziraniSok = new JLabel("Negazirani sokovi");
    private JComboBox<NegaziraniSokovi> negaziraniSokoviJComboBox  = new JComboBox<>(NegaziraniSokovi.values());
    private JLabel voda = new JLabel("Vode");
    private JComboBox<Voda> vodaJComboBox = new JComboBox<>(Voda.values());
    private JButton naruci = new JButton("Naruci");
    private JButton odustani = new JButton("Odustani");
    private String brojStola;

    public Naruci(Ucitavanje ucitavanje, String brojStola) {
        this.ucitavanje = ucitavanje;
        this.brojStola = brojStola;
        setTitle("Porudzbina");
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
        add(pice);
        add(piceJComboBox);
        add(priloziZaPicu);
        add(priloziPicaJComboBox);
        add(paste);
        add(pasteJComboBox);
        add(priloziZaPastu);
        add(priloziPastaJComboBox);
        add(gaziraniSok);
        add(gaziraniSokoviJComboBox);
        add(negaziraniSok);
        add(negaziraniSokoviJComboBox);
        add(voda);
        add(vodaJComboBox);
        add(new JLabel());
        add(naruci,"split 2");
        add(odustani);
    }

    private void initActions(){
        naruci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = ucitavanje.generisiNoviID();
                String brojStola1 = brojStola.toLowerCase(Locale.ROOT);
                LocalDateTime datumIvremePorudzbine = LocalDateTime.now();
                Pice pice = (Pice) piceJComboBox.getSelectedItem();
                Paste paste = (Paste) pasteJComboBox.getSelectedItem();
                Prilozi priloziPica = (Prilozi) priloziPicaJComboBox.getSelectedItem();
                Prilozi priloziPasta = (Prilozi) priloziPastaJComboBox.getSelectedItem();
                GaziraniSokovi gaziraniSokovi = (GaziraniSokovi) gaziraniSokoviJComboBox.getSelectedItem();
                NegaziraniSokovi negaziraniSokovi = (NegaziraniSokovi) negaziraniSokoviJComboBox.getSelectedItem();
                Voda voda = (Voda) vodaJComboBox.getSelectedItem();
                IstorijaPorudzbina istorijaPorudzbina = new IstorijaPorudzbina(id,brojStola1,datumIvremePorudzbine,pice,paste,priloziPica,priloziPasta,gaziraniSokovi,negaziraniSokovi,voda,"0",false);
                ucitavanje.getIstorijaPorudzbina().add(istorijaPorudzbina);
                ucitavanje.snimiPorudzbine(MainRestoran.podaciIzFajla);
                JOptionPane.showMessageDialog(null,"Uspesno ste porucili!","Obavestenje",JOptionPane.INFORMATION_MESSAGE);
                Naruci.this.setVisible(false);
                Naruci.this.dispose();
            }
        });
        odustani.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Naruci.this.setVisible(false);
                Naruci.this.dispose();
            }
        });
    }
}
