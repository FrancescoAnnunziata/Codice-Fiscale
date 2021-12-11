package it.annu.cf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        CodiceFiscale cf = new CodiceFiscale();
        //FileReader f = new FileReader("input.txt");
        //BufferedReader reader = new BufferedReader(f);

        System.out.println("Inserire i dati richiesti");

        //Cognome
        System.out.print("COGNOME: ");
        String cognome = input.next();
        cf.setCognome(cognome);

        //Nome
        System.out.print("NOME: ");
        String nome = input.next();
        cf.setNome(nome);

        //Giorno
        System.out.print("GIORNO DI NASCITA: ");
        int giorno = input.nextInt();
        cf.setGiorno(giorno);

        //Mese
        System.out.print("MESE DI NASCITA: ");
        int mese = input.nextInt();
        cf.setMese(mese);

        //Anno
        System.out.print("ANNO DI NASCITA: ");
        int anno = input.nextInt();
        cf.setAnno(anno);

        //Sesso
        System.out.print("SESSO: ");
        String sesso = input.next();
        cf.setSesso(sesso);

        //Città
        System.out.print("CITTÀ DI NASCITA: ");
        String citta = input.next();
        cf.setCitta(citta);

        //Codice
        System.out.println("CODICE FISCALE");
        System.out.println(cf.getCodice() + cf.calcoloCodiceFin());
    }
}
