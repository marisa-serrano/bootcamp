class MissingChar {

public static void main(String[] args) {

	String word = "Robocop";
	int characterIndex = 3;

  	//receive command line argument if available
  	if (args.length >= 2) {
    		word = args[0]; 
    		characterIndex = Integer.parseInt(args[1]);
 	 }

  	String newWord = word.substring(0, characterIndex) + word.substring(characterIndex + 1);

  	System.out.println(newWord);

}
}
