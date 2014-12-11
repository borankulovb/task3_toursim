package com.epam.entity;



/**
 * The class that contains a cruise
 * <p/>
 * This class contains data on cruise
 *
 * @author Bakytzhan Borankulov
 */

public class Cruise extends Tour {

    private String shipModel;

    private CabinType cabin;

    /**
     * Default constructor
     */
    public Cruise() {

    }

    /**
     * JavaBeans Builder Pattern implementation for Tour
     */
    public void setShipModel(String val) {
        this.shipModel = val;
    }

    public void setCabin(CabinType val) {
        this.cabin = val;
    }

    /**
     * @return shipModel
     */
    public String getShip_model() {
        return shipModel;
    }



    /**
     * @return cabin
     */
    public CabinType getCabin() {
        return cabin;
    }

    @Override
    public String toString() {
        return "Cruise{" +
                "shipModel='" + shipModel + '\'' +
                ", cabin=" + cabin +
                '}';
    }
}
