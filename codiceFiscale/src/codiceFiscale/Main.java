package codiceFiscale;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        codice cod1 = new codice();

        System.out.println("Inserire i dati richiesti");

        //Cognome
        System.out.println("COGNOME: ");
        String cognome = scanner.next();
        cod1.setCognome(cognome);
        System.out.println(cod1.calcoloCog());

        //Nome
        System.out.println("NOME: ");
        String nome = scanner.next();
        cod1.setNome(nome);
        System.out.println(cod1.calcoloNom());
    }
}