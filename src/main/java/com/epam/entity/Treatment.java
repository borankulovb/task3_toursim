package com.epam.entity;


/**
 * This class contains data on treatment
 *
 * @author Bakytzhan Borankulov
 */

public class Treatment extends Tour {

    private String clinicName;

    /**
     * Default constructor
     */
    public Treatment() {

    }

    /**
     * JavaBeans Builder Pattern implementation for Tour
     */
    public void setClinicName(String val) {
        this.clinicName = val;
    }

    /**
     * @return clinicName
     */
    public String getClinicName() {
        return clinicName;
    }


    @Override
    public String toString() {
        return "Treatment{" + super.toString() +
                "clinicName='" + clinicName + '\'' +
                '}';
    }
}
