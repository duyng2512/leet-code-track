package org.dng.code.chain;

import org.dng.code.chain.data.DataWrapper;
import org.dng.code.chain.mapper.AddNewElementMapper;
import org.dng.code.chain.mapper.UpdateElementMapper;

import java.util.ArrayList;
import java.util.List;


public class ChainMain {
	
	public static void main(String[] args) {
		List<Integer> initData = new ArrayList<>(List.of(100, 200, 300));
		DataWrapper<List<Integer>> wrapper = new DataWrapper<>(initData);
		
		List<Integer> mappedData = wrapper
				.process(new AddNewElementMapper())
				.process(new UpdateElementMapper())
				.getData();
		
		System.out.println(mappedData);
	}
	
}
