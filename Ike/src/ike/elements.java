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
    public final static String msg = "https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1#identifier";
    public final static By userForm = new By.ById("Usr");
    public final static String user = "cmantenimiento";
    public final static By passForm = new By.ById("Pass");
    public final static String pass = "022017jR";    
    public final static By loginBtn = new By.ById("btnLogin");
    public final static String expBtnTxt = "//tr[4]/td/button //button[@onclick='fn_CALRT();']";//tr[4]/td/button //button[@onclick='fn_CALRT();']  //div[@id='msg_alerta']/table/tbody/tr/td/table/tbody/tr[4]/td/button //primer boton de nuevo expediente
    public final static By expBtn = new By.ByXPath(expBtnTxt);
    public final static String newExpTxt = "//*[@id=\"PW_LST\"]/tbody/tr[3]/td[10]/button";
    public final static By newExpBtn = new By.ByXPath(newExpTxt);
    public final static String newExpMsg1 = "Has aceptado un nuevo expediente.";
    public final static String newExpMsg2 = "Fecha: ";
    public final static String tmOt = "//*[@id=\"MensajeTimeOut\"]/table";
    public final static String tmOtBtnTxt = "//*[@id=\"MensajeTimeOut\"]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/button";
    public final static By tmOtBtn = new By.ByXPath("//*[@id=\"MensajeTimeOut\"]/table/tbody/tr/td/table/tbody/tr[4]/td[2]/button");
    public final static String updtExpTxt = "//div[2]/div[2]/table/tbody/tr/td";//div[2]/div[2]/table/tbody/tr/td
    public final static By updtExp = new By.ByXPath(updtExpTxt);
    public final static String updtExpAltTxt = "//*[@id=\"tLinks\"]/tbody/tr/td[1]";//*[@id="tLinks"]/tbody/tr/td[1]
    public final static By updtExpAlt = new By.ByXPath(updtExpAltTxt);
    public final static String DtFrm = "dd.MM.yyyy HH.mm.ss";   
    public final static String ChDrv = "webdriver.chrome.driver";    
    public final static String ChDrvLoc = "C:\\chromedriver.exe";
    public final static By emailId = new By.ById("Email");
    public final static String email = "serviciosycerrajerias@gmail.com";
    public final static By nextBtn = new By.ById("next");
    public final static By emailPassId = new By.ById("Passwd");
    public final static String emailPass = "tomaservicios";
    public final static By signIn = new By.ById("signIn");
    public final static By newMsg = new By.ByXPath("//div[@id=':3k']/div/div");
    
}