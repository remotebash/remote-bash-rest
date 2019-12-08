package com.remotebash.api.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.microsoft.sqlserver.jdbc.StringUtils;
import com.remotebash.api.model.Command;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandServiceTest {

	@Autowired
	private CommandService service;	
	
	@Test
	public void TestIfCommandServiceThrowsExceptionWithNullObject(){
		Command command = null;
		String exceptionMessage = StringUtils.EMPTY;
		String expected = "command não pode ser null";
		try {
			service.executeOnComputer(command);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
		}
		Assert.assertEquals(expected, exceptionMessage);
	}
	
	@Test
	public void TestIfCommandServiceThrowsExceptionWithUserIDNull(){
		Command command = new Command();
		command.setUserId(null);
		String exceptionMessage = StringUtils.EMPTY;
		String expected = "UserID não pode ser null";
		try {
			service.executeOnComputer(command);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
		}
		Assert.assertTrue(exceptionMessage.contains(expected));
	}
	
	@Test
	public void TestIfCommandServiceThrowsExceptionWithCommandNull(){
		Command command = new Command();
		command.setUserId(0L);
		String exceptionMessage = StringUtils.EMPTY;
		String expected = "O Comando não pode ser null";
		try {
			service.executeOnComputer(command);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
		}
		Assert.assertTrue(exceptionMessage.contains(expected));
	}
	
	@Test
	public void TestIfCommandServiceThrowsExceptionWithCommandEmpty(){
		Command command = new Command();
		command.setUserId(0L);
		command.setCommand(StringUtils.EMPTY);
		String exceptionMessage = StringUtils.EMPTY;
		String expected = "O Comando não pode ser vazio";
		try {
			service.executeOnComputer(command);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
		}
		Assert.assertTrue(exceptionMessage.contains(expected));
	}
	
	@Test
	public void TestIfCommandServiceThrowsExceptionWithIdComputerNull(){
		Command command = new Command();
		command.setUserId(0L);
		command.setCommand("ipconfig");
		String exceptionMessage = StringUtils.EMPTY;
		String expected = "O IdComputer não pode ser null";
		try {
			service.executeOnComputer(command);
		} catch (Exception ex) {
			exceptionMessage = ex.getMessage();
		}
		Assert.assertTrue(exceptionMessage.contains(expected));
	}
	
	//@Test
	public void TestIfCommandServiceThrowsExceptionWithUserNotExists(){
		Command command = new Command();
		command.setUserId(0L);
		command.setCommand("ipconfig");
		command.setIdComputer(0L);
		String exceptionMessage = StringUtils.EMPTY;
		String expected = "Usuário com o id " + command.getUserId() + " não existe.";
		try {
			service.executeOnComputer(command);
		} catch (Exception ex) {
			System.err.println("Usuário com o id " + command.getUserId() + " não existe.");
			exceptionMessage = ex.getMessage();
		}
		Assert.assertTrue(exceptionMessage.contains(expected));
	}		
}