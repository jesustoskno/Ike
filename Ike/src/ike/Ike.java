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
 * @author jesustoskno@gmail.com
 */
public class Ike {
    
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
        }
    }
}
