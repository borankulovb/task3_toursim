package com.epam.entity;

/**
 * The class that contains a tour
 * <p/>
 * This class contains data on tour
 *
 * @author Bakytzhan Borankulov
 */

public class Tour {

    private long id;

    private int price;

    private int numberOfDays;

    private String country;


    /**
     * Default constructor
     */
    public Tour() {
    }

    /**
     * JavaBeans Builder Pattern implementation for Tour
     */

    public void setPrice(int val) {
        if (val < 0) {
            val = Math.abs(val);
        }
        this.price = val;
    }

    public void setNumberOfDays(int val) {
        if (val < 0) {
            val = Math.abs(val);
        }
        this.numberOfDays = val;
    }

    public void setCountry(String val) {
        this.country = val;
    }

    public void setId(long val) {
        this.id = val;
    }

    /**
     * @return numberOfDays
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }


    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }


    /**
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", price=" + price +
                ", numberOfDays=" + numberOfDays +
                ", country='" + country + '\'' +
                '}';
    }


}


