package LeetcodeStreak.Medium;

public class a885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        /*
         * right (0, 1) means moving horizontally to the right (increase column).
        * down (1, 0) means moving vertically downwards (increase row).
        * left (0, -1) means moving horizontally to the left (decrease column).
        * up (-1, 0) means moving vertically upwards (decrease row).
        */
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

        int directionIndex = 0; //start by moving right
        int steps = 1; // steps to move in the current direction
        int totalCells = rows * cols;
        int index = 0; //to track the number of cells visited

        int r = rStart, c = cStart;
        result[index++] = new int[]{r, c};

        while (index < totalCells) {
            for (int i = 0; i < 2; i++) {  // each direction pair (right & down or left & up)
                //We move in two directions for each loop iteration (e.g., right then down, or left then up).
                for (int j = 0; j < steps; j++) {
                    //We move steps times in the current direction.
                    r += directions[directionIndex][0];
                    c += directions[directionIndex][1];

                    //update the current position based on the current direction.

                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[index++] = new int[]{r, c};
                    }

                    if (index == totalCells) {
                        return result;
                    }
                }
                directionIndex = (directionIndex + 1) % 4; // change direction
                //After finishing steps in a direction, we change the direction by updating directionIndex = (directionIndex + 1) % 4.
            }
            steps++; // increment steps after completing one pair of directions
        }

        return result;
    }
}
