package org.example;

public class Present extends Tovar {
    public int indif;
    public double kolvo;

    public Present(int indif, double kolvo){
        this.indif=indif;
        this.kolvo=kolvo;
    }
    @Override
    public void print(){
        System.out.println("ID: " + indif + ", Количество: " + kolvo);}
}