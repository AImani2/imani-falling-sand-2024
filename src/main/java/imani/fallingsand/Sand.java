package imani.fallingsand;

public class Sand {
    private int[][] field;

    public Sand(int width, int height) {
        field = new int[height][width];
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field[y].length; x++) {
                builder.append(field[y][x]); // the one that prints sideways is x
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public int get(int x, int y) {
        return field[y][x];
    }

    public void put(int x, int y) {
        field[y][x] = 1;
    }

    public void fall() {

        int[][] newField = new int[3][3];

        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (field[y][x] == 1 && field[y + 1][x] == 0) {
                    field[y + 1][x] = 1;
                    field[y][x] = 0;
                }
            }
        }
    }
}


// settings actions on save - reformat optimize rearrange
// do it backwards
// intellij plugin checkstyles
// dont want to touch the bottom row
// gradle: id 'checkstlyle' reload
// make it configurable



