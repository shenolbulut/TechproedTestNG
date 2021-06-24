package com.techproed.test;

import com.techproed.pages.Dashboard;
import com.techproed.utilities.ConfigurationReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RandomNavbarDataProvider {

    Dashboard dashboard=new Dashboard();

    @BeforeMethod
    public void test(){

        Driver.get().get(ConfigurationReader.get("hepsiburada"));


    }

    @DataProvider
    public Object[][] navbarTest(){

        String[][] data={

                {"1. test","Moda"},
                {"2. test","Moda"},
                {"3. test","Moda"},
                {"4. test","Moda"},

                {"1. test", "Ev, Yaşam"},
                {"2. test", "Ev, Yaşam"},
                {"3. test", "Ev, Yaşam"},
                {"4. test", "Ev, Yaşam"}

        };

        return data;

    }

    @Test(dataProvider = "navbarTest")
    public void test(String testSayisi, String menu) throws InterruptedException {

        System.out.println(testSayisi);
        Assert.assertTrue(dashboard.checkNavBar(menu));

    }


}
