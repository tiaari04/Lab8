package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCities() {
        list = MockCityList();
        City testcity = new City("Estevan", "SK");
        City testcity2 = new City("Edmonton", "Alberta");
        list.addCity(testcity);
        assertTrue(list.hasCity(testcity));
        assertFalse(list.hasCity(testcity2));
        list.addCity(testcity2);
        assertTrue(list.hasCity(testcity2));
    }

    @Test
    public void testDelete() {
        list  = MockCityList();
        City testcity1 = new City("Regina", "Saskatchewan");
        City testcity2 = new City("Calgary", "Alberta");
        list.add(testcity1);
        list.add(testcity2);

        assertEquals(2, list.getCount());
        list.deleteCity(testcity1);
        assertEquals(1, list.getCount());
    }
}
