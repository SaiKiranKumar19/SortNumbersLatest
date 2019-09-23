package com.sortNumbers.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Result")
public class sortEntity {
	
	@Id
	@GeneratedValue
	private long id;
	private String SortedNumbers;
	private String UnSortedNumbers;
	private int SwapCount;
	private long duration;
	private String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSortedNumbers() {
		return SortedNumbers;
	}
	public void setSortedNumbers(String sortedNumbers) {
		SortedNumbers = sortedNumbers;
	}
	public String getUnSortedNumbers() {
		return UnSortedNumbers;
	}
	public void setUnSortedNumbers(String unSortedNumbers) {
		UnSortedNumbers = unSortedNumbers;
	}
	public int getSwapCount() {
		return SwapCount;
	}
	public void setSwapCount(int swapCount) {
		SwapCount = swapCount;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
