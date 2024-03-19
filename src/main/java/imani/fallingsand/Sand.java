package imani.fallingsand;

import java.util.Random;

public class Sand {
    private final int[][] field;

    private final Random random;

    public Sand(int width, int height) {
        field = new int[height][width];
        this.random = new Random();
    }

    public Sand(int width, int height, Random random) {
        field = new int[height][width];
        this.random = random;
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

    public void randomSand(int n) {
        for (int i = 0; i <= n; i++) {
            field[random.nextInt(field.length)][random.nextInt(field[0].length)] = 1;
        }
    }

    public void fall() {

        int[][] newField = new int[3][3];

        // moves all sand down one square
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {

                if (field[y][x] == 1) {
                    // does the sand fall straight down?
                    if (field[y + 1][x] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x] = 1;
                        continue;
                    }

                    boolean rightFirst = random.nextBoolean();
                    int direction1 = rightFirst ? +1 : -1;
                    int direction2 = rightFirst ? -1 : +1;

                    // how does this check the bounds?
                    if ((x + direction1) >= 0 && (x + direction1) < field[y].length && field[y + 1][x + direction1] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction1] = 1;
                    } else if ((x + direction2) >= 0 && (x + direction2) < field[y].length && field[y + 1][x + direction2] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction2] = 1;
                    }
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
// dont forget to change branches back
// fall simultaneously?
// right and left need to be exclusive of each other
// tests that sometimes pass and sometimes fail
// mockito
// tell gradle that i want to use mockito
// refactor extract method

// hw - a GUI method called randomSand
// that adds random sand to da field
