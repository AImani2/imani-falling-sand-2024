package imani.fallingsand;

import java.util.Random;

import static java.lang.Math.min;

public class Sand {

    private int[][] field;
    private final Random random;

    public int[][] getField() {
        return field;
    }

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

    public void put(int startX, int startY, int width, int height, double probability) {
        for (int x = startX; x <= startX + width; x++) {
            for (int y = startY; y <= startY + height; y++) {
                if (random.nextDouble() <= probability) {
                    field[y][x] = 1;
                }
            }
        }
    }

    public void randomSand(int n) {
        for (int i = 0; i <= n; i++) {
            field[random.nextInt(field.length)][random.nextInt(field[0].length)] = 1;
        }
    }

    public void resize(int width, int height) {

        int[][] newField = new int[height][width];

        for (int y = 0; y < min(field.length, newField.length); y++) {
            for (int x = 0; x < min(field[y].length, newField[y].length); x++) {
                newField[y][x] = field[y][x];
            }
        }

        field = newField;
    }

    public void load(String sandString) {
        int y = 0;
        int x = 0;
        for (int i = 0; i < sandString.length(); i++){
            char c = sandString.charAt(i);
            switch (c) {
                case '\n' -> {
                    y++;
                    x = 0;
                }
                case '1' -> {
                    field[y][x] = 1;
                    x++;
                }
                default -> {
                    field[y][x] = 0;
                    x++;
                }
            }
        }
    }


    public void move(int x1, int y1, int x2, int y2) {
        field[y1][x1] = 0;
        field[y2][x2] = 1;
    }

    public void fall() {

        // moves all sand down one square
        for (int y = field.length - 2; y >= 0; y--) {
            for (int x = 0; x < field[y].length; x++) {
                if (isSand(x, y)) {
                    // does the sand fall straight down?
                    if (!isSand(x, y + 1)) {
                        move(x, y, x, y + 1);
                        continue;
                    }

                    boolean rightFirst = random.nextBoolean();
                    int direction1 = rightFirst ? +1 : -1;
                    int direction2 = rightFirst ? -1 : +1;

                    // how does this check the bounds?
                    if ((x + direction1) >= 0 && (x + direction1)
                            < field[y].length && field[y + 1][x + direction1] == 0) {
                        move(x, y, x + direction1, y + 1);
                    } else if ((x + direction2) >= 0 && (x + direction2)
                            < field[y].length && field[y + 1][x + direction2] == 0) {
                        field[y][x] = 0;
                        field[y + 1][x + direction2] = 1;
                    }
                }
            }
        }
    }

    private boolean isSand(int x, int y) {
        return field[y][x] == 1;
    }
}

