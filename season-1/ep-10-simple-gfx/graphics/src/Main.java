import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Main {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(10, 10, 800, 600);
        rectangle.draw();

        Cool cool = new Cool();

        KeyboardLogic kb = new KeyboardLogic();
        kb.init();
        kb.setCool(cool);

        cool.draw();
    }
}
