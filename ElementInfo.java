package prj5;

/*
 * File:          ElementInfo.java
 * Description:   a class helps to retrieve properties of an element from
 *                  https://www.webelements.com
 *                 and store them in CElement
 * Author:        Alice Yu, Olivia Gillman
 * Date-written:. 11/2018
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ElementInfo {

    private static final String NAME = "Name";
    private static final String SYMBOL = "Symbol";
    private static final String ATOMIC_NUMBER = "Atomic number";
    private static final String REL_MASS = "Relative atomic mass";
    private static final String STANDARD_STATE = "Standard state";
    private static final String APPEARANCE = "Appearance";
    private static final String CLASSIFICATION = "Classification";


    private static final String GROUP_IN_TABLE = "Group in periodic table";
    private static final String GROUP_NAME = "Group name";
    private static final String PERIOD = "Period in periodic table";
    private static final String BLOCK = "Block in periodic table";
    private static final String SHELL_STRUCTURE = "Shell structure";
    private static final String CAS_REG = "CAS Registry";

    private static final String DENSITY = "Density of solid";
    private static final String MOLAR_VOLUME = "Molar volume<";
    private static final String THERMAL_CONDUCTIVITY = "Thermal conductivity<";

    private static final String MELTING_POINT = "Melting point<";
    private static final String BOILING_POINT = "Boiling point<";
    private static final String ENTHALPY = "Enthalpy of fusion<";

    private CElement element = null;
    private String line = "";

    public ElementInfo() {
        element = null;
        line = "";
    }

    public boolean getElement(String name,CElement element ) {

        this.element = element;

        String elementForUrl = "";

             try {
                if (name.length() == 0)
                    return false;

                elementForUrl = name.toLowerCase().trim() + "/";

                String website = "https://www.webelements.com/" + elementForUrl;
                URL site = new URL(website);
                URLConnection yc = site.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        yc.getInputStream()));

                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    line += inputLine;
                }

                in.close();

                //get general properties
                 if( getGenProperty() && getPeriodicTable() && getPhyProperty() && getHeatProperty())
                      return true;
                 else {
                     element.ClearAll();
                     return false;
                 }


            } catch (FileNotFoundException ex) {
                System.out.println("unknown");
                return false;
            } catch (MalformedURLException e) {
                System.out.println("badly formed url exception occurred");
                return false;
            } catch (IOException e) {
                System.out.println("IO exception occurred");
                return false;
            }
    }

    private boolean getGenProperty(){
        int spot = -1;
        String prop="";
        boolean ret = false;

        spot = line.indexOf(NAME);
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.genProperty.setName(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(SYMBOL);  //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.genProperty.setSymbol(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(ATOMIC_NUMBER); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.genProperty.setAtomicNumber(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(REL_MASS); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.genProperty.setRelMass(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(STANDARD_STATE); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.genProperty.setStdState(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(APPEARANCE); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.genProperty.setAppearance(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(CLASSIFICATION); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.genProperty.setClassification(prop);
            ret = true;
        }
        else
            ret = false;

        System.out.println( element.genProperty.toString());
        return ret;
    }

    public boolean getPeriodicTable() {
        int spot = -1;
        String prop="";
        boolean ret = false;

        spot = line.indexOf(GROUP_IN_TABLE); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.periodicTable.setGroup(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(GROUP_NAME); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.periodicTable.setGroupName(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(PERIOD); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.periodicTable.setPeriod(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(BLOCK); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.periodicTable.setBlock(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(SHELL_STRUCTURE); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.periodicTable.setShellStructure(prop);
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(CAS_REG); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.periodicTable.setCASReg(prop);
            ret = true;
        }
        else
            ret = false;

        System.out.println( element.periodicTable.toString());
        return ret;

    }
    public boolean getPhyProperty() {
        int spot = -1;
        String prop="";
        boolean ret = false;

        spot = line.indexOf(DENSITY);  //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.phyProperty.setDensity(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(MOLAR_VOLUME);  //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.phyProperty.setMolarVol(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(THERMAL_CONDUCTIVITY);
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.phyProperty.setThermConduct(prop);
            ret = true;
        }
        else
            ret = false;

        System.out.println( element.phyProperty.toString());
        return ret;
    }
    public boolean getHeatProperty(){
        int spot = -1;
        String prop="";
        boolean ret = false;

        spot = line.indexOf(MELTING_POINT);  //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.heatProperty.setMeltingPoint(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(BOILING_POINT);  //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.heatProperty.setBoilingPoint(prop);
            ret = true;
        }
        else
            ret = false;

        prop = "";
        spot = line.indexOf(ENTHALPY); //STRING METHOD
        if (spot != -1) {
            prop = getInfo(line, spot);
            element.heatProperty.setEnthalpy(prop);
            ret = true;
        }
        else
            ret = false;

        System.out.println( element.heatProperty.toString());
        return ret;
    }

    //extract property from a string
	private String getInfo(String line, int spot){
		int start = line.indexOf(":", spot)+2;  //STRING METHOD
		int end = line.indexOf("<", start); //STRING METHOD
		return line.substring(start, end);  //STRING METHOD
	}

}