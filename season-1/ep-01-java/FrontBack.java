class FrontBack {

	public static void main(String[] args) {

    		String word = "heisenberg";

    		//receive command line argument if available
    		if(args.length > 0){
      			word = args[0];
    		}

		String newWord = word.charAt(word.length()-1) + word.substring(1, word.length()-1) + word.charAt(0);
		System.out.println(newWord);

    		//print result here
	}

}
