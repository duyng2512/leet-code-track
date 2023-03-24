package org.dng.code.chain.mapper;


import java.util.List;

public class UpdateElementMapper implements Mapper<List<Integer>> {
	@Override
	public List<Integer> map(List<Integer> s) {
		s.set(0, 100);
		return s;
	}
}
