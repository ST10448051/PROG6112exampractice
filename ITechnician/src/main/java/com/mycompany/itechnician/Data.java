/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.itechnician;

/**
 * A simple data-holding class to pass GUI inputs to the
 * validation method, as required by the ITechnician interface (Q.2.7).
 */
public class Data {
    String location;
    String name;
    String repairCost;
    String rate;

    public Data(String location, String name, String repairCost, String rate) {
        this.location = location;
        this.name = name;
        this.repairCost = repairCost;
        this.rate = rate;
    }
}