package com.example.igrice.Model;

public class Igre {
    private int id;
    private String nazivIgrice, opisIgrice, kategorija, slikaURL;
    private double cena;

    public Igre() {
    }

    public Igre(int id, String nazivIgrice, String opisIgrice, String kategorija, String slikaURL, double cena) {
        this.id = id;
        this.nazivIgrice = nazivIgrice;
        this.opisIgrice = opisIgrice;
        this.kategorija = kategorija;
        this.slikaURL = slikaURL;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivIgrice() {
        return nazivIgrice;
    }

    public void setNazivIgrice(String nazivIgrice) {
        this.nazivIgrice = nazivIgrice;
    }

    public String getOpisIgrice() {
        return opisIgrice;
    }

    public void setOpisIgrice(String opisIgrice) {
        this.opisIgrice = opisIgrice;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getSlikaURL() {
        return slikaURL;
    }

    public void setSlikaURL(String slikaURL) {
        this.slikaURL = slikaURL;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Igre{" +
                "id=" + id +
                ", nazivIgrice='" + nazivIgrice + '\'' +
                ", opisIgrice='" + opisIgrice + '\'' +
                ", kategorija='" + kategorija + '\'' +
                ", slikaURL='" + slikaURL + '\'' +
                ", cena=" + cena +
                '}';
    }
}
