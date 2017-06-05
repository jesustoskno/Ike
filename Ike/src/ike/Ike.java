/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ike;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 *
 * @author jesustoskno@gmail.com
 */
public class Ike {

    private static final SimpleDateFormat time = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
    private static String mTimestamp = "";

    public static void setProps() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    }

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        setProps();
        FirefoxOptions options = new FirefoxOptions()
    .setProfile(new FirefoxProfile());
        Proxy proxy = new Proxy();
        proxy.setProxyType(Proxy.ProxyType.AUTODETECT);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("proxy", proxy);
        WebDriver driver = new FirefoxDriver(capabilities);
        driver.get("https://sise2mx.ikeasistencia.com/");
        driver.findElement(By.id("Usr")).clear();
        driver.findElement(By.id("Usr")).sendKeys("cmantenimiento");
        driver.findElement(By.id("Pass")).clear();
        driver.findElement(By.id("Pass")).sendKeys(readPass());
        driver.findElement(By.id("btnLogin")).click();
        for (int i = 0; i < 1; i = 0) {
            Thread.sleep(3100);
            if ((isElementPresent(("//*[@id=\"PW_LST\"]/tbody/tr[3]/td[10]/button"), driver)) == true) {
                driver.findElement(By.xpath("//*[@id=\"PW_LST\"]/tbody/tr[3]/td[10]/button")).click();
                System.out.println("Has aceptado un nuevo expediente.");
                System.out.println("Fecha: " + timeStamp());
                msg();
            }
            if ((isElementPresent(("//*[@id=\"msg_alerta\"]/table/tbody/tr/td/table/tbody/tr[4]/td/button"), driver)) == true) {
                driver.findElement(By.xpath("//*[@id=\"msg_alerta\"]/table/tbody/tr/td/table/tbody/tr[4]/td/button")).click();
                if ((isElementPresent(("//*[@id=\"PW_LST\"]/tbody/tr[3]/td[10]/button"), driver)) == true) {
                    driver.findElement(By.xpath("//*[@id=\"PW_LST\"]/tbody/tr[3]/td[10]/button")).click();
                }
                System.out.println("Has aceptado un nuevo expediente.");
                System.out.println("Fecha: " + timeStamp());
                msg();
            }
            if ((isElementPresent(("//*[@id=\"MensajeTimeOut\"]/table"), driver)) == true) {
                driver.findElement(By.xpath("//*[@id=\"MensajeTimeOut\"]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/button")).click();
            } else {
                driver.findElement(By.xpath("//div[2]/div[2]/table/tbody/tr/td")).click();
            }
        }
    }

    private static boolean isElementPresent(String xpathLocator, WebDriver driver) {
        try {
            driver.findElement(By.xpath(xpathLocator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    private static String readPass() throws FileNotFoundException, IOException{
        String passFile = "pass.txt";
        String line = null;
        String password = new String();
        FileReader fileReader = new FileReader(passFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while((line = bufferedReader.readLine()) != null){
            password = line;
        }
        return password;
    }

    public static void msg() throws InterruptedException {
        WebDriver driver2 = new FirefoxDriver();
        
        driver2.get("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1#identifier");
        driver2.findElement(By.id("Email")).clear();
        driver2.findElement(By.id("Email")).sendKeys("serviciosycerrajerias@gmail.com");
        driver2.findElement(By.id("next")).click();
        Thread.sleep(2000);
        driver2.findElement(By.id("Passwd")).clear();
        driver2.findElement(By.id("Passwd")).sendKeys("tomaservicios");
        driver2.findElement(By.id("signIn")).click();
        Thread.sleep(13000);
        driver2.findElement(By.className("z0")).click();
        Thread.sleep(2000);
        driver2.findElement(By.name("to")).click();
        driver2.findElement(By.name("to")).clear();
        driver2.findElement(By.name("to")).sendKeys("serviciosycerrajerias@gmail.com");
        driver2.findElement(By.name("subjectbox")).click();
        driver2.findElement(By.name("subjectbox")).clear();
        driver2.findElement(By.name("subjectbox")).sendKeys("Nuevo expediente: " + mTimestamp);
        driver2.findElement(By.xpath("//td/div/div/div[4]/table/tbody/tr/td/div/div[2]")).click();
        driver2.quit();
    }

    public static String timeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        mTimestamp = time.format(timestamp);
        return mTimestamp;
    }
}