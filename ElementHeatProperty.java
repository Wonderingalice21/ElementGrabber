/*
 * File:          ElementHeatProperty.java
 * Description:   a class for heat properties of an element
 * Author:        Alice Yu, Olivia Gillman
 * Date-written:. 11/2018
 */

public class ElementHeatProperty {

    private String meltingPoint = "N/A";
    private String boilingPoint = "N/A";
    private String enthalpy = "N/A";

    public ElementHeatProperty() {
       meltingPoint = "N/A";
       boilingPoint = "N/A";
       enthalpy = "N/A";
    }

    public boolean setMeltingPoint(String meltingPoint){
        if(meltingPoint.length() <= 0) //STRING METHOD
            return false;
        //separate property info from html formation string
        meltingPoint.trim();
        int p1 = meltingPoint.indexOf("["); //STRING METHOD
        int p2 = meltingPoint.indexOf("("); //STRING METHOD
        int p3 = meltingPoint.indexOf(")", p2);//STRING METHOD
        if(p1 != -1) {
            this.meltingPoint = meltingPoint.substring(0, p1); //STRING METHOD
            this.meltingPoint += " ";
            this.meltingPoint += meltingPoint.substring(meltingPoint.lastIndexOf(";")+1,
                    meltingPoint.length()); //STRING METHOD
            return true;
        }
        else if(p2 != -1 && p3 != -1 && meltingPoint.substring(p2, p3+1).equalsIgnoreCase("(no data)")) {
            this.meltingPoint = "(no data)" + " " + meltingPoint.substring(meltingPoint.lastIndexOf(";") + 1,
                    meltingPoint.length()); //STRING METHOD
            return true;
        }
        else {
            this.meltingPoint = meltingPoint;
            return true;
        }
    }

    public boolean setBoilingPoint(String boilingPoint){
        if(boilingPoint.length() <= 0)
            return false;
        //separate property info from html formation string
        boilingPoint.trim();
        int p1 = boilingPoint.indexOf("["); //STRING METHOD
        int p2 = boilingPoint.indexOf("("); //STRING METHOD
        int p3 = boilingPoint.indexOf(")", p2);//STRING METHOD

        if( p1 != -1){
            this.boilingPoint = boilingPoint.substring(0, p1); //STRING METHOD
            this.boilingPoint += " ";
            this.boilingPoint += boilingPoint.substring(boilingPoint.lastIndexOf(";")+1, boilingPoint.length());//STRING METHOD
            return true;
        }
        else if(p2 != -1 && p3 != -1 && boilingPoint.substring(p2, p3+1).equalsIgnoreCase("(no data)")) {
            this.boilingPoint = "(no data)" + " " + boilingPoint.substring(boilingPoint.lastIndexOf(";") + 1, boilingPoint.length()); //STRING METHOD
            return true;
        }
        else {
            this.boilingPoint = boilingPoint;
            return true;
        }
    }

    public boolean setEnthalpy(String enthalpy){
        if(enthalpy.length() <= 0)
            return false;
        //separate property info from html formation string
        enthalpy.trim();
        int p = enthalpy.indexOf("&"); //STRING METHOD
        if(p!= -1){
            this.enthalpy = enthalpy.substring(0,p ); //STRING METHOD
            this.enthalpy = this.enthalpy + " " + "kJ/mol";
            return true;
        }
        else {
            this.enthalpy = enthalpy;
            return true;
        }

    }

    @Override
    public String toString()
    {
        String st;

        st = "Melting point:   " + meltingPoint+ "\n";
        st = st + "Boiling point:   " + boilingPoint+ "\n";
        st = st + "Enthalpy of fusion:   " + enthalpy+ "\n";
        return st;
    }
}
