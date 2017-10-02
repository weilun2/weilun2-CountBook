/*
 * Copyright (c) weilun2, CUMPT301, University of Alberta - All Rights Reserved. You may use,distribute, or modify this code under terms and condition of the Code of Students Behavior at Univerisity og Alberta
 */

package com.example.weilun2.countbook;

import java.util.Date;

/**
 * Represent a counter
 *Copy from my own lonelyTwitter project
 *
 * @author: Weilun2
 * @version 1.0
 * @since 1.0
 */
public class Counter {


    private String name;
    private Date date;
    private Integer value;
    private Integer initValue;

    /**
     * Constructs a counter
     *
     * @param name
     * @param initValue
     */
    public Counter(String name, Integer initValue) {
        this.name = name;
        this.initValue = initValue;
        this.value = initValue;
        this.date = new Date();
    }

    public Counter(String name, Integer initValue, Date date) {
        this.name = name;
        this.initValue = initValue;
        this.value = initValue;
        this.date = date;
    }

    /**
     * Set a name
     * @param name
     */
    public void setName(String name) { this.name = name; }

    /**
     * Set a initial value
     * @param value
     */
    public void setInit(Integer value) { this.initValue = value; }

    /**
     * Set a new value
     * @param value
     */
    public void setValue(Integer value) { this.value = value; }

    /**
     * Set the date
     * @param date
     */
    public void setDate(Date date) { this.date = date; }
    /**
     * Get the name
     * @return String
     */
    public String getName() { return this.name; }

    /**
     * Get the date
     * @return Date
     */
    public Date getDate() { return this.date; }

    /**
     * Get the value
     * @return Integer
     */
    public Integer getValue() { return this.value; }

    /**
     * Get the initial value
     * @return Integer
     */
    public Integer getInitValue() { return this.initValue; }

    /**
     * Increment the value and update the date
     *
     */
    public void increment() {
        this.date = new Date();
    }

    /**
     * Decrement the current value and update the date
     */
    public void decrement() {
        if (this.value > 0) {

            this.date = new Date();
        }
    }

    /**
     * Reset the value to initial value
     */
    public void reset() {

        this.value = this.getInitValue();
        this.date = new Date();
    }

    /**
     * represents a counter.
     * @return String
     */
    @Override
    public String toString() {

        return "Last modified: " + date + "   ||   " + name +  "   ||   " + value;

    }

}
