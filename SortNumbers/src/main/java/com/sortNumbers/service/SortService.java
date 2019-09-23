package com.sortNumbers.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sortNumbers.dao.Sortdao;
import com.sortNumbers.entity.sortEntity;
import com.sortNumbers.model.SortedResult;




@Service
public class SortService {

	@Autowired
	static
	Sortdao dao;
	
	public static SortedResult sort(String randomNumbers)
	{
		sortEntity result = new sortEntity();
		int [] arrayOfNumbers = null;
		try {
			arrayOfNumbers = getArrayofNumbers(randomNumbers);
		}
		catch(NumberFormatException e)
		{
			result.setUnSortedNumbers(randomNumbers);
			result.setStatus("Sort Failed: ");
			//dao.saveOrUpdate(result);
			return new SortedResult(randomNumbers, 
					"",
					0,
					0,
					("Sort Failed"  + " Given Numbers are:" + randomNumbers + " are invalid"));
		}
		String unSortedNumbers = Arrays.toString(arrayOfNumbers);
		long startTime = System.nanoTime();
		int swapCount = getSwapCount(arrayOfNumbers);
		long endTime = System.nanoTime();
		result.setUnSortedNumbers(unSortedNumbers);
		result.setSortedNumbers(Arrays.toString(arrayOfNumbers));
		result.setDuration(endTime-startTime);
		result.setSwapCount(swapCount);
		result.setStatus("success");
		//dao.saveOrUpdate(result);
		return new SortedResult(Arrays.toString(arrayOfNumbers),
				unSortedNumbers,
				swapCount,
				endTime-startTime,
				"success");
	}
	public static int getSwapCount(int[] arrayOfNumbers) {
		int swapcount = 0;
		int n = arrayOfNumbers.length; 
        for (int i=1; i<n; ++i) 
        { 
            int key = arrayOfNumbers[i]; 
            int j = i-1; 
            while (j>=0 && arrayOfNumbers[j] > key) 
            { 
            	arrayOfNumbers[j+1] = arrayOfNumbers[j]; 
                j = j-1; 
                swapcount++;
            } 
            arrayOfNumbers[j+1] = key; 
        } 
        return swapcount;
    } 
		
	
	private static int[] getArrayofNumbers(String randomNumbers) {
		return Arrays.stream(randomNumbers.split(","))
				.map(String::trim)
				.mapToInt(Integer::parseInt)
				.toArray();
	}
	/**
	 * Retrieve All the Values by connecting to database
	 * 
	 * @return List<SortResult>
	 */
	public List<SortedResult> getAllResults() {

		List<SortedResult> results = new ArrayList<>();
		List<sortEntity> sortedNumber = dao.getAllSortNumbers();
		sortedNumber.forEach(resultRow -> {
			SortedResult result = new SortedResult(resultRow.getSortedNumbers(),
					resultRow.getUnSortedNumbers(),
					resultRow.getSwapCount(),
					resultRow.getDuration(),
					resultRow.getStatus());
			results.add(result);
		});

		return results;
	}
}
