/*
 * File:          ElementPhyProperty.java
 * Description:   a class for physical properties of an element
 * Author:        Alice Yu, Olivia Gillman
 * Date-written:. 11/2018
 */

public class ElementPhyProperty {
    public static final double MAX_TEMPERATUE = 100000.0;

    private String density = "N/A";
    private String molarVol = "N/A";
    private String thermalConduct = "N/A";

    public ElementPhyProperty() {
        density = "N/A";
        molarVol = "N/A";
        thermalConduct = "N/A";

    }

    public boolean setDensity(String density){
        if(density.length() <= 0 ) //STRING METHOD
            return false;

        //separate property info from html formation string
        this.density = density.substring(0, density.indexOf("&")); //STRING METHOD
        this.density = this.density + " " + "kg/m3";

        return true;
    }

    public boolean setMolarVol(String molVol){
        if(molVol.length() <= 0 )
            return false;

        //separate property info from html formation string
        this.molarVol = molVol.substring(0, molVol.indexOf("&")); //STRING METHOD
        this.molarVol = this.molarVol + " " + "cm3";
        return true;
    }

    public boolean setThermConduct(String themConduct){
        if(themConduct.length() <= 0 )
            return false;

        //separate property info from html formation string
        this.thermalConduct = themConduct.substring(0, themConduct.indexOf("&")); //STRING METHOD
        this.thermalConduct = this.thermalConduct + " " + "W/m.K";

        return true;
    }


    @Override
    public String toString()
    {
        String st;

        st = "Density of solid:   " + density+ "\n";
        st = st + "Molar volume:   " + molarVol+ "\n";
        st = st + "Thermal conductivity:   " + thermalConduct+ "\n";

        return st;
    }

}
