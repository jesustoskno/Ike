/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ike;

import org.openqa.selenium.By;

/**
 *
 * @author toscanox
 */
public class elements {
    
    public final static String Url = "https://sise2mx.ikeasistencia.com/";
    public final static By userForm = new By.ById("Usr");
    public final static String user = "cmantenimiento";
    public final static By passForm = new By.ById("Pass");
    public final static String pass = "022017jR";    
    public final static By loginBtn = new By.ById("btnLogin");
    public final static String expBtnTxt = "//*[@id=\"msg_alerta\"]/table/tbody/tr/td/table/tbody/tr[4]/td/button";
    public final static By expBtn = new By.ByXPath(expBtnTxt);
    public final static By newExpAlrt = new By.ByXPath("//*[@id=\"msg_alerta\"]/table/tbody/tr/td/table/tbody/tr[4]/td/button");
    public final static By newExpBtn = new By.ByXPath("//*[@id=\"PW_LST\"]/tbody/tr[3]/td[10]/button");
    public final static String newExpMsg1 = "Has aceptado un nuevo expediente.";
    public final static String newExpMsg2 = "Fecha: ";
    public final static String tmOt = "//*[@id=\"MensajeTimeOut\"]/table";
    public final static By tmOtBtn = new By.ByXPath("//*[@id=\"MensajeTimeOut\"]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/button");
    public final static By updtExp = new By.ByXPath("//div[2]/div[2]/table/tbody/tr/td");
    public final static String DtFrm = "dd.MM.yyyy HH.mm.ss";   
    public final static String ChDrv = "webdriver.chrome.driver";    
    public final static String ChDrvLoc = "C:\\chromedriver.exe";
}