class NewProgram {

	public static void main(int[] args) {
	
		int[] unsorted = {args[0]};

		int[] sortedArray = sort(unsorted);
		System.out.println(sortedArray);
	}

	public static int[] sort(int[] numbers) {
		int[] sorted = new int[numbers.length];
		int min = numbers[0];

		for (int i = 0; i < numbers.length; i++) {
			
			for (int j = 0; j < numbers.length; j++) {

				boolean isSorted = Arrays.asList(sorted).contains(numbers[j]);
			
				if (numbers[j] < min && !isSorted) {  
					min = numbers[j];	
				}
			}

			sorted[i] = min;
		}
		
		System.out.println(sorted);
isSorted}

}
