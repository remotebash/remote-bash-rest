package com.remotebash.api.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ComputerServiceTest {
	@Autowired
	private ComputerService service;	
	
	@Test
	public void TestIfMethod_isComputerOnline_ReturnsFalse(){
		Assert.assertFalse(service.isComputerOnline(0L));
	}
}
