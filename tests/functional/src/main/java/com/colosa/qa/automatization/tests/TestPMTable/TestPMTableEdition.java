package com.colosa.qa.automatization.tests.TestPMTable;

import java.lang.Exception;
import java.util.List;

import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.NoSuchElementException;

import com.colosa.qa.automatization.pages.*;
import com.colosa.qa.automatization.common.*;
import com.colosa.qa.automatization.common.controlOptions.input.*;
import com.colosa.qa.automatization.common.controlOptions.selection.*;
import com.colosa.qa.automatization.common.controlOptions.ControlOptions;
import com.colosa.qa.automatization.common.Browser;
import com.colosa.qa.automatization.common.extJs.ExtJSGrid;

public class TestPMTableEdition{

    @Test
    public void runCase() throws Exception {
        
        Pages.Login().gotoUrl();
        Pages.Login().loginUser("admin","admin","workflow");
				
				Pages.Main().goAdmin();
        
        Pages.Admin().newPMTable("TESTTABLE","description Table");
        Pages.Admin().addField("ID","ID","VARCHAR","32",false,false,false);
        Pages.Admin().addField("NUMBER","NUMBER","INTEGER","4",true,false,true);
        Pages.Admin().addField("DESCRIPCION","DESCRIPCION","VARCHAR","100",false,false,false);
        Pages.Admin().createPMTable();
        
        Assert.assertTrue("PMTable does not exist.", Pages.Admin().verifyPMTable("TESTTABLE"));
        
        String dataArray[] = new String[3];
        dataArray[0] = "1a";
        dataArray[1] = "";
        dataArray[2] = "PRODUCT1";
        
        String dataArray1[] = new String[3];
        dataArray1[0] = "1b";
        dataArray1[1] = "";
        dataArray1[2] = "PRODUCT2";
        
        String dataArray2[] = new String[3];
        dataArray2[0] = "1c";
        dataArray2[1] = "";
        dataArray2[2] = "PRODUCT3";
        
        Boolean result = Pages.Admin().addDataPMTable("TESTTABLE", dataArray);
        
        String dkData = "0";
        String kData = "0";
        
     		WebElement dontKeepData = Pages.Admin().editPMTable("TESTTABLE", false, "TYPE","TYPE","VARCHAR","32",true,false,false);
     		if(dontKeepData.getAttribute("innerHTML").indexOf ("No rows to display") > -1) {
     			dkData = "1";
     	  }
     	  Assert.assertEquals("Edit PMTable does not Keep Data not works properly", "1", dkData);


				Pages.Admin().addDataPMTable("TESTTABLE", dataArray);
     		
				WebElement keepData = Pages.Admin().editPMTable("TESTTABLE", false, "TYPESS","TYPESS","VARCHAR","32",true,false,false);
				if(keepData.getAttribute("innerHTML") != "No rows to display") {
     			kData = "1";
     		}	
     		Assert.assertEquals("Edit PMTable Keep Data does not works properly.", "1", kData);
     		Pages.Admin().deletePMTable("TESTTABLE");
    }
	/*
    @After
    public void cleanup(){
        Browser.close();
    }
   */
}