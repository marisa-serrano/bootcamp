import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        String[] messageArray = message.split(" ");

        String newMessage = Stream.of(messageArray)
                .map(String::toUpperCase)
                .filter(word -> !word.equals("GARBAGE"))
                .reduce("", (acc, word) -> acc + word + " ");

        System.out.println(newMessage);
    }
}