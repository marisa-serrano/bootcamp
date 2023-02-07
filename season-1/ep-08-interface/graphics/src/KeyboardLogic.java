// tem de implementar keyboardHandler
// tem de ter uma propriedade do tipo keyboard
// criar keyboard events

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardLogic implements KeyboardHandler {
    private Keyboard keyboard;
    private Cool cool;
    public KeyboardLogic(){
        init();
    }

    public void init() {
        keyboard = new Keyboard(this);
        // right... arrow

        // create keyboard event, the reference right represents the right arrow
        KeyboardEvent right = new KeyboardEvent();

        // set key
        right.setKey(KeyboardEvent.KEY_RIGHT);

        // set keyboard event type
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        // add event listener to our keyboard with the event as argument
        keyboard.addEventListener(right);

    }

    // what happens when you press a key
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT){
            cool.moveRight();
        }
    }

    // what happens when you release a key
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void setCool(Cool cool) {
        this.cool = cool;
    }
}
