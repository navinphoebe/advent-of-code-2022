public class Rope {

    public int[][] tailPositions = new int[10000][20];
    public int[] tail = { 9, 0 };
    public int[] head = { 9, 0 };
    public int placesTouched = -1;

    public void logTailPosition() {
        boolean duplicate = false;
        for (int i = 0; i < 10000; i++) {
            if (tail[0] == tailPositions[i][0] && tail[1] == tailPositions[i][1]) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            placesTouched += 1;
            tailPositions[placesTouched][0] = tail[0];
            tailPositions[placesTouched][1] = tail[1];
        }
    }

    public void moveDown() {
        head[0] += 1;
        updateTailPosition();
    }

    public void updateTailPosition() {
        if (tail[0] == head[0] && tail[1] == head[1]) {
            return;
        }
        int difference = Math.abs(head[0] - tail[0]);
        int difference2 = Math.abs(head[1] - tail[1]);
        if (difference == 1 && difference2 == 1) {
            return;
        }
        if (tail[0] == head[0]) {
            if (head[1] + 1 < tail[1]) {
                tail[1] -= 1;
            } else if (head[1] - 1 > tail[1]) {
                tail[1] += 1;
            }
            logTailPosition();
            return;
        }
        if (tail[1] == head[1]) {
            if (head[0] + 1 < tail[0]) {
                tail[0] -= 1;
            } else if (head[0] - 1 > tail[0]) {
                tail[0] += 1;
            }
            logTailPosition();
            return;
        }

        if (head[1] < tail[1]) {
            tail[1] -= 1;
        } else if (head[1] > tail[1]) {
            tail[1] += 1;
        }
        if (head[0] < tail[0]) {
            tail[0] -= 1;
        } else if (head[0] > tail[0]) {
            tail[0] += 1;
        }

        logTailPosition();
    }

    public void moveUp() {
        head[0] -= 1;
        updateTailPosition();
    }

    public void moveLeft() {
        head[1] -= 1;
        updateTailPosition();
    }

    public void moveRight() {
        head[1] += 1;
        updateTailPosition();
    }

}
