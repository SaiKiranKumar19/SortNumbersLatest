package com.sortNumbers.model;

	public class SortedResult {

		private String SortedNumbers;
		private String UnSortedNumbers;
		private int SwapCount;
		private long duration;
		private String status;
		
		
		public SortedResult(String sortedNumbers, String unSortedNumbers, int swapCount, long duration, String status) {
			super();
			SortedNumbers = sortedNumbers;
			UnSortedNumbers = unSortedNumbers;
			SwapCount = swapCount;
			this.duration = duration;
			this.status = status;
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


