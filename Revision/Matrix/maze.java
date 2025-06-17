package Revision.Matrix;

public class maze {

    public boolean dfsPath(int[][] maze, int[] start, int[] destination) {
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        maze[start[0]][start[1]] = 2;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : directions) {
            int x = start[0];
            int y = start[1];

            // Roll in the current direction until hitting a wall or boundary
            while ((0 <= x + dir[0]) && (x + dir[0] < m) &&
                   (0 <= y + dir[1]) && (y + dir[1] < n) &&
                   maze[x + dir[0]][y + dir[1]] == 0) {
                x += dir[0];
                y += dir[1];
            }

                if (maze[x][y] == 0) {
                    if (dfsPath(maze, new int[]{x, y}, destination)) {
                        return true;
                    }
                }

            }

        return false;
    }
}
