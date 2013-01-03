package com.colosa.qa.automatization.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;

import com.colosa.qa.automatization.common.*;
import com.colosa.qa.automatization.common.extJs.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DynaformExecution extends Page{

    public DynaformExecution() throws FileNotFoundException, IOException{
        
    }

    public void intoDynaform() throws Exception{
        Browser.driver().switchTo().defaultContent();
        Browser.driver().switchTo().frame("casesFrame");
        Browser.driver().switchTo().frame("casesSubFrame");
        Browser.driver().switchTo().frame("openCaseFrame");
    }

    public void intoDebug() throws Exception{
        Browser.driver().switchTo().defaultContent();
        Browser.driver().switchTo().frame("casesFrame");
    }

    public void outDynaform() throws Exception{
        Browser.driver().switchTo().defaultContent();
    }

    public WebElement getField(String nameField) throws Exception{
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDynaform");
        str = str.replace("replaceNameFieldDynaform", nameField);
        return Browser.getElement(str);
    }

    public void setFieldValue(String fieldName, String value, FieldType fieldType) throws Exception{
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDynaform");
        str = str.replace("replaceNameFieldDynaform", fieldName);

        System.out.println("element to search for: " + str);

        //search element
        WebElement element = Browser.getElement(str);

        System.out.println("element : "+element.getAttribute("value"));

        switch(fieldType)
        {
            case TEXTBOX: element.sendKeys(value);
                                    break;

            case BUTTON:    element.click();
                                    break;  

            case TEXTAREA: element.sendKeys(value);
                                     break; 

            case DROPDOWN: 
                Select droplist = new Select(element);
                droplist.selectByVisibleText(value);
                break;

            case RADIOBUTTON:   element.click();
                                        break;

            case CHECK:     element.click();
                                    break;  
                                    
            case READONLY:  ((JavascriptExecutor)Browser.driver()).executeScript("arguments[0].value=arguments[1]", element, value);
                            break;

            case SUGGEST:   String cadIns = value;
                            char c;
                            WebElement elem2 = null;
                            WebElement sugElem = null;
                            List<WebElement> listEl;                    
                            for(int lon=0;lon<cadIns.length();lon++)    
                            {
                                c = cadIns.charAt(0);
                                element.sendKeys(Character.toString(c));
                                try {
                                    Browser.waitForElement(By.xpath("//div[1]/ul/li"),2);                                   
                                } catch(Exception ex){
                                    //element not found
                                    cadIns = cadIns.substring(1, cadIns.length());
                                    continue;
                                }
                                elem2 = Browser.driver().findElement(By.xpath("//div[1]/ul/li"));
                                listEl = elem2.findElements(By.xpath("a"));
                                for(WebElement we2:listEl)
                                {
                                    if(we2.findElement(By.xpath("span[3]")).getText().equals(value))
                                    {
                                        sugElem = we2;
                                        we2.click();
                                        break;
                                    }                                       
                                }

                                if(sugElem!=null)
                                {
                                    break;
                                }
                                cadIns = cadIns.substring(1, cadIns.length());
                            }
                            //Thread.sleep(1000);
                            break;      
     
            default:    break;                                                                                                                                                      
        }

        return;
    } 

    public String getFieldValue(String fieldName) throws Exception{
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDynaform");
        str = str.replace("replaceNameFieldDynaform", fieldName);
        WebElement element = Browser.getElement(str);

        return element.getAttribute("value");
    }

    public String getDropdownFieldText(String fieldName) throws Exception{
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDynaform");
        str = str.replace("replaceNameFieldDynaform", fieldName);

        WebElement element = Browser.getElement(str);
        
        Select droplist = new Select(element);
        
        return droplist.getFirstSelectedOption().getText();
    }

    public String getFieldText(String fieldName) throws Exception{
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDynaform");
        str = str.replace("replaceNameFieldDynaform", fieldName);

        WebElement element = Browser.getElement(str);
        
        return element.getText();
    }

    public String getFieldProperty(String nameField, String property) throws Exception{
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDynaform");
        str = str.replace("replaceNameFieldDynaform", nameField);
        return Browser.getElement(str).getAttribute(property);
    }

    public WebElement getObject(String xpathField) throws Exception{
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDebug");
        str = str.replace("replaceXpath", xpathField);
        return Browser.getElement(str);
    }

    public String searchValueVariableDebug(String nameVariable) throws Exception{
        WebElement gridDebug = Browser.getElement("DynaformExecution.webElement.gridDebug");
        List<WebElement> gridDebugDivs = gridDebug.findElements(By.tagName("div"));

        String valueField = "";

        for(WebElement divs:gridDebugDivs)
        {
            if( divs.getAttribute("innerHTML").trim().equals(nameVariable))
            {
                WebElement trParent = divs.findElement(By.xpath("..")).findElement(By.xpath(".."));
                List<WebElement> fieldTds = trParent.findElements(By.tagName("td"));

                for(WebElement tds:fieldTds)
                {
                    if(!tds.findElement(By.xpath(".//div")).getAttribute("innerHTML").trim().equals(nameVariable))
                    {
                        valueField = tds.findElement(By.xpath(".//div")).getAttribute("innerHTML").trim();
                        break;
                    }
                }
                break;
            }
        }
        return valueField;
    }

     public void sleep(long timeMilliSeconds) throws Exception {
        Thread.sleep(timeMilliSeconds);
     }

     public void sendTab(String fieldName) throws Exception {
        
        String str = "";
        str = ConfigurationSettings.getInstance().getSetting("DynaformExecution.webElement.fieldDynaform");
        str = str.replace("replaceNameFieldDynaform", fieldName);
        WebElement element = Browser.getElement(str);
        element.sendKeys(Keys.TAB);
     }     

         
}