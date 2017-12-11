package jp.spring.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.spring.learn.beans.Data;
import jp.spring.learn.beans.User;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private DataService dataService;
	
	@Override
	public long calculateSum(User user) {
		List<Data> data = dataService.retrieveData(user);
		return (long)data.stream().map(Data::getValue).reduce(0, Integer::sum);
	}
}
