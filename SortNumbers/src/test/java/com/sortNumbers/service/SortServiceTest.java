package com.sortNumbers.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sortNumbers.model.SortedResult;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SortServiceTest {

	@Autowired
	SortService SortService;

	
	
	@Test
	public void testFor_ValidData() {
		int[] ExpectedsortingNumber = { 1, 2, 3, 4 };
		SortedResult sortResult = SortService.sort("4,3,2,1");
		Assert.assertEquals(Arrays.toString(ExpectedsortingNumber), sortResult.getSortedNumbers());
		
	}

	@Test
	public void testFor_InvalidData() {
		SortedResult sortResult = SortService.sort("4,3,2,A");
		Assert.assertTrue(sortResult.getStatus().contains("Sort Failed"));
	}
	@Test
	public void testFor_SwapCount() {
		int ExpectedSwapCount = 6;
		SortedResult sortResult = SortService.sort("4,3,2,1");
		Assert.assertEquals(ExpectedSwapCount, sortResult.getSwapCount());
	}
	@Test
	public void testFor_SortedInput() {
		int ExpectedSwapCount = 0;
		SortedResult sortResult = SortService.sort("1,2,3,4");
		Assert.assertEquals(ExpectedSwapCount, sortResult.getSwapCount());
	}
	@Test
	public void testFor_NegativeInput() {
		int ExpectedSwapCount = 0;
		SortedResult sortResult = SortService.sort("-4,-3,-2,1");
		Assert.assertEquals(ExpectedSwapCount, sortResult.getSwapCount());
	}

	
	
}
