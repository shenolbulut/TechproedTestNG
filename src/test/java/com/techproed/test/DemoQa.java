package com.techproed.test;

import com.techproed.pages.DemoQaPage;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import java.util.List;

public class DemoQa {

    /*
    Test Senaryosu:
    1- kullanıcı https://demoqa.com/webtables adresine gider
    2- add butonuna tıklar
    3- açılan penceredeki inputları doldurur
    4- kaydet butonuna tıklar
    5- yapmış olduğu yeni kaydı webtable ile karşılaştırı

     */

    DemoQaPage demoQaPage=new DemoQaPage();


    @Test
    public void test1(){

        Driver.get().get("https://demoqa.com/webtables");

        demoQaPage.addBttn.click();

        List<WebElement> inputs=Driver.get().findElements(By.tagName("input"));



//        demoQaPage.getFormElements("firstName").sendKeys("Ahmedd");
//        demoQaPage.getFormElements("lastName").sendKeys("Mehmeddd");
//        demoQaPage.getFormElements("userEmail").sendKeys("asdfa@gmail.com");
//        demoQaPage.getFormElements("age").sendKeys("24");
//        demoQaPage.getFormElements("salary").sendKeys("2500");
//        demoQaPage.getFormElements("department").sendKeys("IT");
//        demoQaPage.getFormElements("submit").click();

        demoQaPage.getFormElements("firstName","ali")
                .getFormElements("lastName","veli")
                .getFormElements("userEmail","asdfa@gmail.com")
                .getFormElements("age","28")
                .getFormElements("salary", "2000")
                .getFormElements("department","IT")
                .getFormElements("submit", Keys.ENTER);
        Actions actions = new Actions(Driver.get());

        actions.sendKeys("sdf").click().pause(2);




        for(WebElement elm:demoQaPage.columNames){
            if(elm.getText().equals("Ahmedd")){
                System.out.println("PASS");
                break;

            }
        }



    }



    @Test
    public void test2(){
        Driver.get().get("https://demoqa.com/webtables");



        for(WebElement elm:demoQaPage.columNames){
            System.out.println(elm.getText());
        }

        System.out.println(demoQaPage.tbody.getText());


    }






}
