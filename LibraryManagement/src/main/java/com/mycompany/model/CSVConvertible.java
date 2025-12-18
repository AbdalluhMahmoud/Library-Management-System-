package com.mycompany.model;

public interface CSVConvertible {
    // Every class that implements this MUST have a toCSV method
    String toCSV(); 
}