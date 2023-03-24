package org.dng.code.chain.data;

import lombok.Getter;
import org.dng.code.chain.mapper.Mapper;

public class DataWrapper<T> {
	
	@Getter
	private T data;
	
	public DataWrapper(T data) {
		this.data = data;
	}
	
	public DataWrapper<T> process(Mapper<T> mapper) {
		this.data = mapper.map(data);
		return this;
	}
	
}
