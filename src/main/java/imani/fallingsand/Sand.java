package imani.fallingsand;

public class Sand {
    private int[][] field = new int[3][3];

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
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
        // watch a video
        // moves all sand down one square
        // sand cant move if it is on the bottom
        // sand cant move if something is below it
        // only move one space at a time
        // all has to be inside this method

    }
}

