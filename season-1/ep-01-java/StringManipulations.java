class StringManipulations {

	public static void main(String[] args) {

	String str = "http://www.academiadecodigo.org";

	String domain = str.substring(7, str.length()); // www.academiadecodigo.org
	String name = "< " + Character.toUpperCase(domain.charAt(4)) + domain.substring(5, 12) + " " + domain.substring(12, 14) + " " + Character.toUpperCase(domain.charAt(14)) + domain.substring(15, domain.length() - 4) + "_ >";  // < Academia de Codigo_ >
	


	// print the following message at the end
	// I am a Code Cadet at < Academia de Codigo_ >, www.academiadecodigo.org
		
	System.out.println("I am a Code Cadet at " + name + ", " + domain);
	}
}
