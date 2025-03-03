import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GameHandler implements KeyboardHandler {

    private Keyboard keyboard;
    private Rectangle cursor;

    private Grid grid;

    private boolean[] gridState;


    Picture mekie;


    public GameHandler() {

        grid = new Grid();
        grid.drawGrid();
        keyboard = new Keyboard(this);

        cursor = new Rectangle(Grid.getX(0), Grid.getY(0), Grid.getCellSize(), Grid.getCellSize());
        cursor.setColor(Color.GREEN);
        cursor.fill();


        createKeyboardEvents();


    }


    public void createKeyboardEvents() {

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventS = new KeyboardEvent();
        keyboardEventS.setKey(KeyboardEvent.KEY_S);
        keyboardEventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventS);

        KeyboardEvent keyboardEventL = new KeyboardEvent();
        keyboardEventL.setKey(KeyboardEvent.KEY_L);
        keyboardEventL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventL);

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);


    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (Grid.xToCol(cursor.getX()) != 0) {
                    cursor.translate(-Grid.getCellSize(), 0);
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (Grid.xToCol(cursor.getX()) != 24) {
                    cursor.translate(Grid.getCellSize(), 0);
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (Grid.yToRow(cursor.getY()) != 0) {
                    cursor.translate(0, -25);
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (Grid.yToRow(cursor.getY()) != 24) {
                    cursor.translate(0, 25);
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                Grid.fillSquare(Grid.xToCol(cursor.getX()), Grid.yToRow(cursor.getY()));
                break;
            case KeyboardEvent.KEY_S:
                gridState = Grid.getGridState();
                try {
                    CopyPasteFile.saveFile(gridState);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case KeyboardEvent.KEY_L:
                Grid.loadGrid(gridState);
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
