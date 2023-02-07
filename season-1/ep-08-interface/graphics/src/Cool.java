import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cool {

    // (x0, y0, string = path da imagem)
    private Picture cool = new Picture(10, 10, "/cool.jpeg");

    public void draw() {
        cool.draw();
    }

    public void moveRight() {
        // mudar a posição do x, posição do y
        cool.translate(20, 0);
    }
}
