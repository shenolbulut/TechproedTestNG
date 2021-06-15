package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public abstract boolean checkTitle();

    String menuElemetn="moda";

    String path="//span[contains(*,'"+menuElemetn+"')]";

    //Driver.get().findElement(By.xpat(path));
    By ustMenu=By.xpath("//span[contains(*,'"+menuElemetn+"')]");


    /*
    method oluşturalım
    return type=WebElement
    parameter String (moda, Elektornik, vs)
     */

    public WebElement getNavMenu(String menuName){ //Moda, Elektronkik,

        By ustMenu=By.xpath("//span[contains(*,'"+menuName+"')]");

        WebElement element=Driver.get().findElement(ustMenu);

        return element;
    }


    /*
    method oluşturup alt menulere tıklayalım
    returnType= void
    parameter= String, String
     */
    public void navBar(String menuName, String subMenu) throws InterruptedException { //Moda, Elektronkik,

        WebElement element=Driver.get().findElement(By.xpath("//span[contains(*,'"+menuName+"')]"));

        element.click();
        Thread.sleep(5000);

        WebElement altElm=Driver.get().findElement(By.xpath("//a/span[text()='"+subMenu+"']"));
        altElm.click();
        Thread.sleep(5000);

    }









}
