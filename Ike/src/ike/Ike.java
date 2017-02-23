/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ike;
import org.openqa.selenium.By;
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
            driver.findElement(By.xpath("//div[2]/div[2]/table/tbody/tr/td")).click();
            //#MensajeTimeOut > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > button:nth-child(1)
        }
    }
}
