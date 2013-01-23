package com.colosa.qa.automatization.tests.derivationRulesCombinations;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Test;

import com.colosa.qa.automatization.pages.*;
import com.colosa.qa.automatization.common.*;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DerivationRulesParallelEvaluation{

	protected static int caseNum;

	@Test
	public void derivationRulesParallelEvaluation() throws FileNotFoundException, IOException, Exception{
		//Init case
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "workflow");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Cyclical");
		Pages.DynaformExecution().setFieldValue("send", "");
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
	    //cyclical task
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("chris", "sample", "");
		Pages.Main().goHome();	
    	Pages.Home().gotoInbox();
		Assert.assertTrue("The case does not exist in Inbox", Pages.Home().existCase(caseNum));
		Pages.Home().openCase(caseNum);
		Pages.DynaformExecution().intoDynaform();
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Init case
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Manual");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("TASKS][1][USR_UID", "Swan, William");		
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Manual task
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("william", "sample", "");
		Pages.Main().goHome();	
    	Pages.Home().gotoInbox();
		Assert.assertTrue("The case does not exist in Inbox", Pages.Home().existCase(caseNum));
		Pages.Home().openCase(caseNum);
		Pages.DynaformExecution().intoDynaform();
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Init case
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Value Based");
		Pages.DynaformExecution().setFieldValue("send", "");
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Value based task
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
    	Pages.Home().gotoInbox();
		Assert.assertTrue("The case does not exist in Inbox", Pages.Home().existCase(caseNum));
		Pages.Home().openCase(caseNum);
		Pages.DynaformExecution().intoDynaform();
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Init case
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Reports to");
		Pages.DynaformExecution().setFieldValue("send", "");
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Report to task
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("zachary", "sample", "");
		Pages.Main().goHome();	
    	Pages.Home().gotoInbox();
		Assert.assertTrue("The case does not exist in Inbox", Pages.Home().existCase(caseNum));
		Pages.Home().openCase(caseNum);
		Pages.DynaformExecution().intoDynaform();
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Init case
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Self Service");
		Pages.DynaformExecution().setFieldValue("send", "");
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Self service task
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("chris", "sample", "");
		Pages.Main().goHome();	
		Pages.Home().gotoUnassigned();
		Assert.assertTrue("The case does not exist in Unassigned", Pages.Home().existCase(caseNum));
		Pages.Home().openCase(caseNum);
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("BTN_CATCH", "");
		Pages.DynaformExecution().outDynaform();
		Pages.DynaformExecution().intoDynaform();
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Init case
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Self Service Value Based");
		Pages.DynaformExecution().setFieldValue("send", "");
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Self Service Value Based task
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("william", "sample", "");
		Pages.Main().goHome();	
		Pages.Home().gotoUnassigned();
		Assert.assertTrue("The case does not exist in Unassigned", Pages.Home().existCase(caseNum));
		Pages.Home().openCase(caseNum);
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("BTN_CATCH", "");
		Pages.DynaformExecution().outDynaform();
		Pages.DynaformExecution().intoDynaform();
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		//Open cases to verify Cyclical assigmnent
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Cyclical");
		Pages.DynaformExecution().setFieldValue("send", "");
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();
		Pages.Login().gotoUrl();
		Pages.Login().loginUser("ezequiel", "sample", "");
		Pages.Main().goHome();	
		caseNum = Pages.Home().startCase("Derivation rules - parallel evaluation (Init)");
		Pages.DynaformExecution().intoDynaform();
		Pages.DynaformExecution().setFieldValue("name", "Charles Puyol");
		Pages.DynaformExecution().setFieldValue("amount", "3000");
		Pages.DynaformExecution().setFieldValue("send", "");
		Pages.DynaformExecution().setFieldValue("tasks", "Cyclical");
		Pages.DynaformExecution().setFieldValue("send", "");
	    Pages.InputDocProcess().continuebtn();
		Pages.DynaformExecution().outDynaform();
		Pages.Main().logout();


	}


}