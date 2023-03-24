package org.dng.code.chain.mapper;


import java.util.List;

public class AddNewElementMapper implements Mapper<List<Integer>> {
	@Override
	public List<Integer> map(List<Integer> s) {
		s.add(100);
		return s;
	}
}
