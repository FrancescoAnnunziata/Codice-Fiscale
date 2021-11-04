package codiceFiscale;

public class codice {
    //ATTRIBUTI
    private String cognome;
    private String nome;

    //METODI
    //Costruttori
    public codice(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }
    public codice() {
    }

    //Setter
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Getter
    public String getCognome() {
        return cognome;
    }
    public String getNome() {
        return nome;
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
    public String calcoloNom() {
        String f = nome.toUpperCase();
        String nom = "";
        int temp = 0;
        int x = 0;
        do {
            if(f.charAt(x) != 'A' && f.charAt(x) != 'E' && f.charAt(x) != 'I' && f.charAt(x) != 'O' && f.charAt(x) != 'U') {
                if(temp != 1) {
                    nom += f.charAt(x);
                    temp += 1;
                } else {
                    temp += 1;
                }
            }
            x += 1;
        } while(temp != 4 && x != f.length());

        return nom;
    }
}
