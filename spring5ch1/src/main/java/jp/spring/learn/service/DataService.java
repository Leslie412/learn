package jp.spring.learn.service;

import java.util.List;

import jp.spring.learn.beans.Data;
import jp.spring.learn.beans.User;

public interface DataService {
	List<Data> retrieveData(User user);
}
