class NotString {

	public static void main(String[] args) {

   		String word = "semicolon"; // what if the word is "nothing"?
   
    		//receive command line argument if available
    		if (args.length > 0) {
      			word = args[0];
		}

		String start = word.substring(0, 3);
		String newWord;

    		if (start.toLowerCase() != "not") {
   			newWord = "not " + word; 
    		
		} else {
			newWord = word;
		}

    		// print result here

    		System.out.println(newWord);

	}
}
