package jp.spring.learn.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.spring.learn.beans.Data;
import jp.spring.learn.beans.User;

@Repository
public class DataServiceImpl implements DataService {

	@Override
	public List<Data> retrieveData(User user) {
		return user.getData();
	}

}
