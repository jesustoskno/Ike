/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ike;
import static junit.framework.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author toscanox
 */
public class Ike {
    /**
     * @param args the command line arguments
     */
    public static void setProps(){
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }
    
    public static void main(String[] args) throws InterruptedException {
        setProps();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://sise2mx.ikeasistencia.com/");
        driver.findElement(By.id("Usr")).clear();
        driver.findElement(By.id("Usr")).sendKeys("cmantenimiento");
        driver.findElement(By.id("Pass")).clear();
        driver.findElement(By.id("Pass")).sendKeys("022017jR");
        driver.findElement(By.id("btnLogin")).click();
        for (int i=0; i<1; i=0){
            Thread.sleep(3100);
            if((isElementPresent(("//*[@id=\"MensajeTimeOut\"]/table"), driver))==true){
                driver.findElement(By.xpath("//*[@id=\"MensajeTimeOut\"]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/button")).click();
            } else {
                driver.findElement(By.xpath("//div[2]/div[2]/table/tbody/tr/td")).click();
            ////*[@id="MensajeTimeOut"]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/button
            ////*[@id="MensajeTimeOut"]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/button
            ////*[@id="MensajeTimeOut"]/table
            }
        }
    }

    private static boolean isElementPresent(String xpathLocator, WebDriver driver) {
        try{
            driver.findElement(By.xpath(xpathLocator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}