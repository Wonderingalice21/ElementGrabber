/*
 * File:          CElement.java
 * Description:   a class for an element
 * Author:        Alice Yu, Olivia Gillman
 * Date-written:. 11/2018
 */
public class CElement {

    public ElementGenProperty genProperty;  // general properties of an element
    public ElementInPeriodicTable periodicTable; // periodic table information of an element
    public ElementPhyProperty phyProperty;  // physical properties of an element
    public ElementHeatProperty heatProperty;  // heat properties of an element

    public CElement() {
          genProperty = new ElementGenProperty();
          periodicTable = new ElementInPeriodicTable();
          phyProperty = new ElementPhyProperty();
          heatProperty = new ElementHeatProperty();
    }


    public void ClearAll() {
        genProperty = null;
        periodicTable = null;
        phyProperty = null;
        heatProperty = null;
    }

}
