package com.techproed.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDSample {



    @DataProvider
    public Object[][] testData(){

        String[][] data={

            {"Persons of Interest", "9"},
                {"Sherlack", "9.5"},
                {"Breaking Bad","10"},
                {"Lucifer","9"},
                {"Criminal Minds","9.5"},
                {"Preson Break","10"}

        };

        return data;
    }


    @Test(dataProvider = "testData")
    public void test1(String dizi, String imdb){

        System.out.println("Dizinin ismi "+dizi+"imdb puanı "+ imdb);

    }




}
