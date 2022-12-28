package org.example;

public class Prodavez implements Printer{
    private String name;
    private int indif;

    public Prodavez (int indif, String name){
        this.indif = indif;
        this.name = name;
    }
    @Override
    public void print() {
        System.out.println("Продавец " + indif +":"+ " Имя: " + name);
    }
}
