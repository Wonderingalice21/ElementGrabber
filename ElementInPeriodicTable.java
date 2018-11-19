/*
 * File:          ElementInPeriodicTable.java
 * Description:   a class for periodic-table-related properties of an element
 * Author:        Alice Yu, Olivia Gillman
 * Date-written:. 11/2018
 */

import java.awt.image.BufferedImage;

public class ElementInPeriodicTable {
    public static final int MAX_GROUP_NUMBER = 18;
    public static final int MAX_PERIOD_NUMBER = 7;

    private String group ="N/A";
    private String groupName ="N/A";
    private String period ="N/A";
    private String block ="N/A";
    private String shellStructure ="N/A";
    private String CASReg = "N/A";
    private BufferedImage periodicTable = null;

    public ElementInPeriodicTable() {
        group ="N/A";
        groupName ="N/A";
        period ="N/A";
        block ="N/A";
        shellStructure ="N/A";
        CASReg ="N/A";
        periodicTable = null;
    }

    boolean setGroup(String group) {
        if(group.length() <= 0 ) //STRING METHOD
            return false;
        this.group = group;
        return true;
    }

    boolean setGroupName(String groupName) {
        if(groupName.length() <= 0 ) //STRING METHOD
            return false;
        this.groupName = groupName;
        return true;
    }

    boolean setPeriod(String period) {
        if(period.length() <= 0 ) //STRING METHOD
            return false;
        this.period = period;
        return true;
    }

    boolean setBlock(String block) {
        if(block.length() <= 0 ) //STRING METHOD
            return false;
        this.block = block;
        return true;
    }

    boolean setShellStructure(String shStruct) {
        if(shStruct.length() <= 0 ) //STRING METHOD
            return false;
        this.shellStructure = shStruct;
        return true;
    }

    boolean setCASReg(String reg) {
        if(reg.length() <= 0 ) //STRING METHOD
            return false;
        this.CASReg = reg;
        return true;
    }

    void setPeriodicTable(BufferedImage img) {
        periodicTable = img;
    }

    BufferedImage getPeriodicTable() {
        return periodicTable;
    }

    @Override
    public String toString()
    {
        String st;

        st = "Group in periodic table:   " + group+ "\n";
        st = st + "Group name:   " + groupName+ "\n";
        st = st + "Period in periodic table:   " + period+ "\n";
        st = st + "Block in periodic table:  " + block+ "\n";
        st = st + "Shell structure:   " + shellStructure+ "\n";
        st = st + "CAS Registry:   " + CASReg+ "\n";

        return st;
    }
}
