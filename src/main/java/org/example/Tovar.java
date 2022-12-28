package org.example;

public class Tovar implements Printer {
    int indif;
    double kolvo;
    double zena;
    public Tovar(int indif, double kolvo, double zena){
        this.indif=indif;
        this.kolvo=kolvo;
        this.zena=zena;}

    public Tovar() {
    }

    @Override
    public void print(){
        System.out.println("ID: " + indif + ", Количество: " + kolvo + ", Цена: " + zena);
    }
}
