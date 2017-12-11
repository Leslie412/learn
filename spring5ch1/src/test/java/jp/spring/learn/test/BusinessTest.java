package jp.spring.learn.test;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import jp.spring.learn.beans.Data;
import jp.spring.learn.beans.User;
import jp.spring.learn.service.BusinessService;
import jp.spring.learn.service.BusinessServiceImpl;
import jp.spring.learn.service.DataService;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BusinessTest {

	@Mock
	private DataService dataService;

	@InjectMocks
	private BusinessService service = new BusinessServiceImpl();

	@Test
	public void testBusinessService() {

		BDDMockito.given(dataService.retrieveData(Matchers.any(User.class)))
				.willReturn(Arrays.asList(new Data(1), new Data(2), new Data(3)));
		
		assertEquals((long)6, service.calculateSum(new User()));
	}

}
