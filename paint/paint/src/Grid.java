
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {
    private static final int CELL_SIZE = 25;  // Tamanho de cada célula
    private static final int COLS = 25;       // Número de colunas
    private static final int ROWS = 25;       // Número de linhas
    private static final int PADDING = 10;    // Margem da grid

    private static boolean[] gridState = new boolean[COLS*ROWS];

    private static Rectangle[] rectangles = new Rectangle[COLS * ROWS];
    public Grid() {
        drawGrid();  // Desenha a grid ao inicializar
    }
    void drawGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Rectangle cell = new Rectangle(getX(col), getY(row), CELL_SIZE, CELL_SIZE);
                gridState[col + (COLS * row)] = false;
                cell.setColor(Color.GRAY);
                rectangles[col+ (COLS * row)] = cell;
                cell.draw();  // Apenas desenha as bordas
            }
        }
    }

    public static boolean[] getGridState() {
        boolean[] newGrid = new boolean[COLS * ROWS];
        for(int i = 0;i < gridState.length; i++){
            newGrid[i]=gridState[i];
        }
        return newGrid;
    }

    public static int getROWS() {
        return ROWS;
    }

    public static int getCOLS() {
        return COLS;
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }

    public static int getPADDING() {
        return PADDING;
    }

    public static void fillSquare (int col, int row){


        if(gridState[col +(COLS* row)] == false){
            rectangles[col +(COLS* row)].fill();
            gridState[col +(COLS* row)] = true;

        } else {
            rectangles[col+ (COLS * row)].delete();
            Rectangle cell = new Rectangle(getX(col), getY(row), CELL_SIZE, CELL_SIZE);
            cell.setColor(Color.GRAY);
            rectangles[col+ (COLS * row)] = cell;
            gridState[col +(COLS* row)] = false;
            cell.draw();

        }


    }

    public static void loadGrid (boolean[] gridLoad){
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if(gridState[col + (COLS * row)] != gridLoad[col + (COLS * row)]){
                    fillSquare(col,row);
                }
            }
        }
    }
    // Calcula a coordenada X com base na coluna
    public static int getX(int col) {
        return PADDING + col * CELL_SIZE;
    }
    // Calcula a coordenada Y com base na linha
    public static int getY(int row) {
        return PADDING + row * CELL_SIZE;
    }

    public static int xToCol (int x){
        return ((x - PADDING) / CELL_SIZE);
    }

    public static int yToRow (int y){
        return ((y - PADDING) / CELL_SIZE);
    }


}
