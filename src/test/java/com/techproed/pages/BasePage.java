package com.techproed.pages;

import com.techproed.utilities.BrowserUtils;
import com.techproed.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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



    public void navBar(String menu) throws InterruptedException {

        Thread.sleep(5000);

        WebElement element=Driver.get().findElement(By.xpath("//span[contains(*,'"+menu+"')]"));
        element.click();

    }

    /*
    method oluşturacaz
    return = List<String>
    parameter= List<WebElemt>

     */

    public List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }


    /*
    method oluşturalım
    return boolean
    parameter String = Moda Ev ya
     */

    public boolean checkNavBar(String menu) throws InterruptedException {

        WebElement element=Driver.get().findElement(By.xpath("//span[contains(*,'"+menu+"')]"));
        element.click();

        Thread.sleep(3000);
        List<WebElement> tumLinkler = Driver.get().findElements(By.xpath("//*[@class='sf-ChildMenuItems-3VA7f']//a"));

        List<String> subMenuText = getElementsText(tumLinkler);

        System.out.println(subMenuText);

        Random random=new Random();

        int index=random.nextInt(subMenuText.size());
        System.out.println(index);

        String subTitle=subMenuText.get(index); //get(index)

        System.out.println(subTitle);

        navBar(menu,subTitle);

        Thread.sleep(3000);

        if(Driver.get().getTitle().contains(subTitle)){
            return true;
        }else{

            System.out.println("Beklenilen Başlık: "+subTitle);
            System.out.println("Gelen Başlık"+Driver.get().getTitle());
            return false;
        }

    }



    public void navBar(String menuName, String subMenu) { //Moda, Elektronkik,

        WebElement element=Driver.get().findElement(By.xpath("//span[contains(*,'"+menuName+"')]"));

        WebElement altElm=Driver.get().findElement(By.partialLinkText(subMenu));

        Actions actions=new Actions(Driver.get());

        try{

            element.click();

        } catch (Exception e){

            actions.click(element).perform();

        }catch (Throwable e){

            BrowserUtils.clickWithJS(element);

        }


        try{

            altElm.click();

        }catch (Exception e){

            actions.click(altElm).perform();

        }catch (Throwable t){

            JavascriptExecutor js= (JavascriptExecutor) Driver.get();
            js.executeScript("arguments[0].click();", altElm); // altElm.click()

        }





    }









}
