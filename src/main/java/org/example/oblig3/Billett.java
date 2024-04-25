package org.example.oblig3;

public class Billett {
    private long id;
    private String film;
    private int antallBilletter;
    private String navn;
    private String telefonnr;
    private String epost;

    public Billett() {}
    public Billett(long id, String film, int antallBilletter,
                   String navn, String telefonnr, String epost) {
        this.id = id;
        this.film = film;
        this.antallBilletter = antallBilletter;
        this.navn = navn;
        this.telefonnr = telefonnr;
        this.epost = epost;
    }


    public long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFilm() {
        return film;
    }
    public void setFilm(String film) {
        this.film = film;
    }

    public int getAntallBilletter() {
        return antallBilletter;
    }
    public void setAntallBilletter(int antallBilletter) {
        this.antallBilletter = antallBilletter;
    }

    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getTelefonnr() {
        return telefonnr;
    }
    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getEpost() {
        return epost;
    }
    public void setEpost(String epost) {
        this.epost = epost;
    }
}
