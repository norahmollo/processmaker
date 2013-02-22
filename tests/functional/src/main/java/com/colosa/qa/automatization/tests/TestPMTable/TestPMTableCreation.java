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

public class TestPMTableCreation{

    @Test
    public void runCase() throws Exception {
        
        Pages.Login().gotoUrl();
        Pages.Login().loginUser("admin","admin","workflow");
				
				Pages.Main().goAdmin();
        Pages.Admin().newPMTable("TESTTABLE","description Table");
        Pages.Admin().addField("ID","ID","VARCHAR","32",true,false,false);
        Pages.Admin().addField("NAME","NAME","VARCHAR","50",false,false,false);
        Pages.Admin().addField("DESCRIPCION","DESCRIPCION","VARCHAR","100",false,false,false);
        Pages.Admin().createPMTable();
        
        Pages.Main().goHome();
        int casenumber = Pages.Home().startCase("TestPMTables (Task 1)");
        Pages.DynaformExecution().intoDynaform();
        
        String fieldRESULT = Pages.DynaformExecution().getFieldProperty("RESULT_TEST","value");
        Assert.assertEquals("PMTable does not exist in Database.", "0", fieldRESULT);
        
        FormFieldData[] fieldArray=new FormFieldData[1];
		    fieldArray[0]=new FormFieldData();
				
		    fieldArray[0].fieldPath="form[SUBMIT]";
		    fieldArray[0].fieldFindType=FieldKeyType.ID;
		    fieldArray[0].fieldType=FieldType.BUTTON;
		    fieldArray[0].fieldValue="";
    
        FormFiller.formFillElements(fieldArray);
        Pages.InputDocProcess().continuebtn();
        
        if( fieldRESULT != "0" ){
	        Pages.Main().goAdmin();
	        Pages.Admin().deletePMTable("TESTTABLE");
      	}
        Pages.Main().goAdmin();
        Pages.Admin().newPMTable("TEST TABLE1","description Table");
        Pages.Admin().addField("ID","ID","VARCHAR","32",true,false,false);
        Pages.Admin().addField("NAME","NAME","VARCHAR","50",false,false,false);
        Pages.Admin().addField("DESCRIPCION","DESCRIPCION","VARCHAR","100",false,false,false);
        Pages.Admin().createPMTable();
        
        Assert.assertTrue("Exist any space in Name Table", Pages.Admin().verifyPMTable("TESTTABLE1"));
        if(Pages.Admin().verifyPMTable("TESTTABLE1") == true) {
        	Pages.Admin().deletePMTable("TESTTABLE1");
        }        
        Pages.Admin().newPMTable("TESTTABLE3","description Table3");
        Pages.Admin().addField("ID","ID","VARCHAR","32",false,false,false);
        Pages.Admin().addField("NAME","NAME","","50",false,false,false);
        Pages.Admin().addField("DESCRIPCION","DESCRIPCION","VARCHAR","100",false,false,false);
        Pages.Admin().createPMTable();
                
        Assert.assertEquals("Type Field should be defined in Table", false,Pages.Admin().verifyPMTable("TESTTABLE3"));
        if(Pages.Admin().verifyPMTable("TESTTABLE3") == true) {
        	Pages.Admin().deletePMTable("TESTTABLE3");
        } 
        Pages.Admin().newPMTable("TESTTABLE2","description Table2");
        Pages.Admin().addField("ID","ID","VARCHAR","32",false,false,false);
        Pages.Admin().addField("NAME","NAME","VARCHAR","50",false,false,false);
        Pages.Admin().addField("DESCRIPCION","DESCRIPCION","VARCHAR","100",false,false,false);
        Pages.Admin().createPMTable();
        
        Assert.assertEquals("Does not exist Primary Key field in Table", false,Pages.Admin().verifyPMTable("TESTTABLE2"));
    		if(Pages.Admin().verifyPMTable("TESTTABLE2") == true) {
        	Pages.Admin().deletePMTable("TESTTABLE2");
        } 
    }

    @After
    public void cleanup(){
        Browser.close();
    }
   
}