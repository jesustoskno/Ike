/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ike;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author jesustoskno@gmail.com
 */
public class Ike {

    private static final SimpleDateFormat time = new SimpleDateFormat(elements.DtFrm);

    public static void setProps() {
        System.setProperty(elements.ChDrv, elements.ChDrvLoc);
    }

    public static void magic(WebDriver driver) throws InterruptedException {
        for (int i = 0; i < 1; i = 0) {
            pause();
            if(isElementPresent(elements.expBtnTxt, driver)){
                click(elements.expBtn, driver);
                if(isElementPresent(elements.newExpTxt, driver)){
                    click(elements.newExpBtn, driver);
                    System.out.println(elements.newExpMsg1);
                    System.out.println(elements.newExpMsg2 + timeStamp());
                } else {
                    System.out.println(elements.newExpMsg1);
                    System.out.println(elements.newExpMsg2 + timeStamp());
                }
            } else {
                if(isElementPresent(elements.tmOtBtnTxt, driver)){
                    click(elements.tmOtBtn, driver);
                } else {
                    if(isElementPresent(elements.updtExpTxt, driver)){
                        pause();
                        pause();
                        click(elements.updtExp, driver);
                    }
                }
            }
        }
    }

    public static void login(WebDriver driver) {
        driver.findElement(elements.userForm).clear();
        driver.findElement(elements.userForm).sendKeys(elements.user);
        driver.findElement(elements.passForm).clear();
        driver.findElement(elements.passForm).sendKeys(elements.pass);
        driver.findElement(elements.loginBtn).click();
    }

    public static void main(String[] args) throws InterruptedException {
        setProps();
        WebDriver driver = new ChromeDriver();
        driver.get(elements.Url);
        login(driver);
        magic(driver);
    }

    private static boolean isElementPresent(String xpathLocator, WebDriver driver) {
        try {
            driver.findElement(By.xpath(xpathLocator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private static void pause() throws InterruptedException {
        Thread.sleep(1000);
    }

    private static void msg() {
        WebDriver driver2 = new ChromeDriver();
        driver2.get(elements.msg);
        driver2.findElement(By.id("Email")).clear();
        driver2.findElement(By.id("Email")).sendKeys("serviciosycerrajerias@gmail.com");
        driver2.findElement(By.id("next")).click();
        driver2.findElement(By.id("Passwd")).clear();
        driver2.findElement(By.id("Passwd")).sendKeys("tomaservicios");
        driver2.findElement(By.id("signIn")).click();
        driver2.findElement(By.xpath("//div[@id=':3k']/div/div")).click();
        driver2.findElement(By.id(":8i")).click();
        driver2.findElement(By.id(":8i")).clear();
        driver2.findElement(By.id(":8i")).sendKeys("Nuevo Expediente");
        driver2.findElement(By.id(":88")).click();

        //caso 2
        
        assertEquals("cerrajerías servicios", driver2.findElement(By.cssSelector("p.profile-name")).getText());
        driver2.findElement(By.id("Passwd")).clear();
        driver2.findElement(By.id("Passwd")).sendKeys("tomaservicios");
        driver2.findElement(By.id("signIn")).click();

    }

    public static String timeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return time.format(timestamp);
    }
    
    public static void click(By element, WebDriver driver){
        try{
            driver.findElement(element).click();
        } catch (NoSuchElementException e) {
            
        }
    }
}
