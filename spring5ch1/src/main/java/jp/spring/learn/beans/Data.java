package jp.spring.learn.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Data {
	private int value;
	
	public Data(int value) {
		this.value = value;
	}
}
