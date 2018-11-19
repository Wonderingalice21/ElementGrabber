package prj5;

/*
 * File:          ElementGenProperty.java
 * Description:   a class for general properties of an element
 * Author:        Alice Yu, Olivia Gillman
 * Date-written:. 11/2018
 */

import java.awt.image.BufferedImage;

public class ElementGenProperty {

    private String name = "N/A";
    private String symbol = "N/A";
    private String atomicNumber = "N/A";
    private String relMass = "N/A";
    private String stdState = "N/A";
    private String appearance =  "N/A";
    private String classification =  "N/A";
    private BufferedImage elmimage = null;

    public ElementGenProperty(){
        name = "N/A";
        symbol = "N/A";
        atomicNumber =  "N/A";
        relMass = "N/A";
        stdState = "N/A";
        appearance =  "N/A";
        classification =  "N/A";
        elmimage = null;
    }
    boolean setName(String name) {
         if(name.length() <= 0 )  //STRING METHOD
            return false;
        this.name = name;
        return true;
    }

    String getName() {
        return name;
    }

    boolean setAtomicNumber(String atmNumber) {
         if(atmNumber.length() <0 ) //STRING METHOD
            return false;
        this.atomicNumber = atmNumber;
        return true;
    }

    String getAtomicNumber() {
        return atomicNumber;
    }

    boolean setSymbol(String symbol) {
        if(symbol.length() <= 0) //STRING METHOD
            return false;
        this.symbol = symbol;
        return true;
    }

    String getSymbol() {
        return symbol;
    }

    boolean setRelMass(String relMass) {
        if(relMass.length() <= 0)  //STRING METHOD
            return false;
        else {
            this.relMass = relMass;
            return true;
        }
    }

    String getRelMass() {
        return relMass;
    }

    boolean setStdState(String stdState) {
        if(stdState.length() <= 0) //STRING METHOD
            return false;
        this.stdState = stdState;
        return true;
    }

    String getStdState() {
        return stdState;
    }

    boolean setAppearance(String appearance) {
        if(appearance.length() <= 0) //STRING METHOD
            return false;
        this.appearance = appearance;
        return true;
    }

    String getAppearance() {
        return appearance;
    }

    boolean setClassification(String classification) {
        if(classification.length() <= 0) //STRING METHOD
            return false;
        this.classification = classification;
        return true;
    }

    String getClassification() {
        return classification;
    }

    void setImage(BufferedImage img) {
        elmimage = img;
    }

    BufferedImage getImage() {
        return elmimage;
    }

    @Override
    public String toString()
    {
        String st;
        st = "Name:   " + name+ "\n";
        st = st + "Symbol:   " + symbol + "\n";
        st = st + "Atomic Number:   " + atomicNumber + "\n";
        st = st + "Relative atomic mass:   " + relMass + "\n";
        st = st + "Standard state:   " + stdState + "\n";
        st = st + "Appearance:   " + appearance + "\n";
        st = st + "Classification:   " + classification + "\n";

        return st;
    }
 }
