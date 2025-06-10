package com.example.periodictable.model;

import java.io.Serializable;

public class Element implements Serializable {
    private String name;
    private String symbol;
    private int atomicNumber;
    private double atomicMass;

    public Element(String name, String symbol, int atomicNumber, double atomicMass) {
        this.name = name;
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
    }

    public String getName() { return name; }
    public String getSymbol() { return symbol; }
    public int getAtomicNumber() { return atomicNumber; }
    public double getAtomicMass() { return atomicMass; }
}
