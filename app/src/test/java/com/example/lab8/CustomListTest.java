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

    /**
     * creates 2 new cities and adds the first city to the list
     * checks that the first city was added to the list
     * checks that the second city is not in the list
     * adds the second city to the list
     * checks that the second city is in the list
     */
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

    /**
     * adds 2 cities to the list
     * checks the count of cities in the list
     * deletes the first city from the list
     * checks if the count of cities in the list
     * checks that delete removed the correct city
     */
    @Test
    public void testDelete() {
        list  = MockCityList();
        City testcity1 = new City("Regina", "Saskatchewan");
        City testcity2 = new City("Calgary", "Alberta");
        list.addCity(testcity1);
        list.addCity(testcity2);

        assertEquals(2, list.getCount());
        list.deleteCity(testcity1);
        assertEquals(1, list.getCount());
        assertTrue(list.hasCity(testcity2));
        assertFalse(list.hasCity(testcity1));
    }

    /**
     * adds a city to the list
     * checks if the number of cities in the list is correct
     * removes the city from the list
     * checks again if the number of cities in the list is correct
     */
    @Test
    public void testCount() {
        list = MockCityList();
        City testcity1 = new City("Calgary", "Alberta");
        list.addCity(testcity1);
        assertEquals(1, list.countCities());
        list.deleteCity(testcity1);
        assertEquals(0, list.countCities());
    }
}
