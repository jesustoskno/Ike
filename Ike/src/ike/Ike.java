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
            Thread.sleep(3100);
            if ((isElementPresent((elements.expBtnTxt), driver)) == true) {
                driver.findElement(elements.expBtn).click();
                if (isElementPresent(elements.newExpTxt, driver)) {
                    driver.findElement(elements.newExpBtn).click();
                    System.out.println(elements.newExpMsg1);
                    System.out.println(elements.newExpMsg2 + timeStamp());
                } else {
                    System.out.println(elements.newExpMsg1);
                    System.out.println(elements.newExpMsg2 + timeStamp());
                }
            } else {
                if ((isElementPresent(elements.tmOt, driver)) == true) {
                    driver.findElement(elements.tmOtBtn).click();
                } else {
                    driver.findElement(elements.updtExp).click();
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

    public static String timeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return time.format(timestamp);
    }
}
