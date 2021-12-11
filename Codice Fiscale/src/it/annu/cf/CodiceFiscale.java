package it.annu.cf;

import com.sun.jdi.IntegerValue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodiceFiscale {

    //ATTRIBUTI
    private String nome;
    private String cognome;
    private int anno;
    private int mese;
    private int giorno;
    private String sesso;
    private String citta;

    //METODI
    //Costruttori
    public CodiceFiscale() throws FileNotFoundException {}
    public CodiceFiscale(String nome, String cognome, int anno, int mese, int giorno, String sesso) throws FileNotFoundException {
        this.mese = mese;
        this.nome = nome;
        this.cognome = cognome;
        this.anno = anno;
        this.mese = mese;
        this.giorno = giorno;
        this.sesso = sesso;
    }

    //Getter
    public String getAnno() {
        String a = Integer.toString(anno);
        return a.substring(a.length()-2);
    }
    public String getMese(){
        String r="";
        switch(mese){
            case 1 : r="A"; break;
            case 2 : r="B"; break;
            case 3 : r="C"; break;
            case 4 : r="D"; break;
            case 5 : r="E"; break;
            case 6 : r="H"; break;
            case 7 : r="L"; break;
            case 8 : r="M"; break;
            case 9 : r="P"; break;
            case 10 : r="R"; break;
            case 11 : r="S"; break;
            case 12 : r="T"; break;
        }
        return r;
    }
    public String getGiorno() {
        int r = giorno;
        if (sesso.equals("F")) {
            r = giorno + 40;
        }
        return String.format("%02d", r);
    }
    public String getCitta() {
        return citta;
    }
    public String getCodice() throws Exception {
        return calcoloCog()+calcoloNome()+getAnno()+getMese()+getGiorno()+calcoloCitta();
    }

    //Setter
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setAnno(int anno) {
        this.anno = anno;
    }
    public void setMese(int mese) {
        this.mese = mese;
    }
    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String calcoloCog() {
        String s = cognome.toUpperCase();
        String cog = "";
        int temp = 0;
        int x = 0;
        do {
            if(s.charAt(x) != 'A' && s.charAt(x) != 'E' && s.charAt(x) != 'I' && s.charAt(x) != 'O' && s.charAt(x) != 'U') {
                cog += s.charAt(x);
                temp += 1;
            }
            x += 1;
        } while(temp != 3 && x != s.length());

        x = 0;

        if(temp != 3) {
            do{
                if(s.length() <= temp) {
                    cog += 'X';
                    temp += 1;
                } else {
                    if(s.charAt(x) == 'A' || s.charAt(x) == 'E' || s.charAt(x) == 'I' || s.charAt(x) == 'O' || s.charAt(x) == 'U'){
                        cog += s.charAt(x);
                        temp += 1;
                    }
                }
                x += 1;
            }while(temp != 3);
        }
        return cog;
    }
    public String calcoloNome(){
        String nom= "";
        nome = nome.toUpperCase();

        for (int i=0; i<nome.length(); i++){
            if (nom.length()!= 4 && nome.charAt(i) != 'A' && nome.charAt(i) != 'E' && nome.charAt(i) != 'I' && nome.charAt(i) != 'O' && nome.charAt(i) != 'U') {
                nom += nome.charAt(i);
            }
        }

        if (nom.length()==4){
            nom = nom.substring(0,1) + nom.substring(1+1);
        }

        if (nom.length() != 3) {
            for (int i = 0; i < nome.length(); i++) {
                if (nom.length() != 3) {
                    if (nome.charAt(i) == 'A' || nome.charAt(i) == 'E' || nome.charAt(i) == 'I' || nome.charAt(i) == 'O' || nome.charAt(i) == 'U') {
                        nom += nome.charAt(i);
                    }
                }
            }
        }

        if (nom.length() != 3){
            do {
                nom += 'X';
            }while (nom.length()!=3);
        }

        return nom;
    }
    public String calcoloCitta() throws Exception {
        FileReader f = new FileReader("input.txt");
        BufferedReader reader = new BufferedReader(f);
        boolean eof = false;
        String riga;
        String error = "Errore";
        while (!eof) {
            riga = reader.readLine();
            if (riga != null) {
                String[] parts = riga.split(";");
                String part1 = parts[0];
                if (part1.equalsIgnoreCase(citta)) {
                    String part2 = parts[1];
                    return part2;
                }
            } else {
                eof = true;
            }
        }
        f.close();
        reader.close();
        return error;
    }

    public int codSicurezzaPari() throws Exception {
        String codice = getCodice();
        Boolean eof = false;
        String riga;
        char t;
        int count = 0;

        for(int i = 1; i <= 14; i += 2) {
            eof = false;
            FileReader f = new FileReader("input2.txt");
            BufferedReader reader = new BufferedReader(f);
            while(!eof) {
                riga = reader.readLine();
                if (riga != null) {
                    String[] parts = riga.split(";");
                    String part1 = parts[0];
                    t = part1.charAt(0);
                    if (codice.charAt(i) == t) {
                        count += Integer.valueOf(parts[1]);
                    }
                } else {
                    eof = true;
                }
            }
            f.close();
            reader.close();
        }
        return count;
    }

    public int codSicurezzaDis() throws Exception {
        String codice = getCodice();
        Boolean eof = false;
        String riga;
        char t;
        int count = 0;

        for(int i = 0; i <= 14; i += 2) {
            eof = false;
            FileReader f = new FileReader("input3.txt");
            BufferedReader reader = new BufferedReader(f);
            while(!eof) {
                riga = reader.readLine();
                if (riga != null) {
                    String[] parts = riga.split(";");
                    String part1 = parts[0];
                    t = part1.charAt(0);
                    if (codice.charAt(i) == t) {
                        count += Integer.valueOf(parts[1]);
                    }
                } else {
                    eof = true;
                }
            }
            f.close();
            reader.close();
        }
        return count;
    }

    public String calcoloCodiceFin() throws Exception {
        FileReader f = new FileReader("input2.txt");
        BufferedReader reader = new BufferedReader(f);

        int num = (codSicurezzaDis() + codSicurezzaPari()) % 26;
        String error = "Errore";
        String riga;
        boolean eof = false;
        int count = 0;
        int t;

        while(!eof) {
            riga = reader.readLine();
            if(riga != null) {
                String[] parts = riga.split(";");
                String part1 = parts[1];
                t = Integer.valueOf(parts[1]);
                if(t == num) {
                    return parts[0];
                }
            } else {
                eof = true;
            }
        }
        f.close();
        reader.close();
        return error;
    }
}
