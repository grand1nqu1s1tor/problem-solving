package snakegame;

import java.util.*;

/*
 The LeetCode problem presents us with a classic game of Snake,
 where the objective is to control a snake that moves around a grid,
 eats food, and grows in length with each piece of food it consumes.
 The game stops if the snake either runs into the wall or itself.
 We're asked to design the game logic for a snake initially of length 1 unit,
 starting from the top-left corner of the grid with dimensions height x width.

 The grid functions like a 2D array where the food items are coordinates listed in the food array.
 The snake moves in one of four directions each turn: up (U), down (D), left (L), or right (R).
 The game scores a point when the snake eats a piece of food,
 which involves moving to the same coordinate location as the next item in the food array.
 Food items appear sequentially, with the next item making its appearance only after the current one has been eaten.
 The game is over if the snake tries to move beyond the boundary of the grid or into a space occupied by its body.

The objective is to implement the SnakeGame class with:
A constructor SnakeGame(int width, int height, int[][] food) which initializes the game with the screen size and the food positions.
A method int move(String direction) to move the snake in the requested direction and return the game's score or -1 if the game is over.

*/
public class SnakeGame {
    // When the snake moves, we need to ADD to the HEAD and DELETE from the TAIL.
    // Deque supports O(1) insertion/removal from both ends
    Deque<int[]> snake;
    // While moving the snake, we need to check that the snake doesn't collide/eat itself.
    // We can use a set for O(1) collision detection.
    Set<String> occupied;
    // List where food is present (Manually fill)
    int[][] food;
    //We need an active index for which food is to be eaten currently from the food array.
    int foodIndex;
    // Track the current score
    int score;
    //Grid dimensions
    int width, height;
    // Directions Helper Array
    Map<String, int[]> DIRS = Map.of(
            "U", new int[]{-1, 0},
            "D", new int[]{1, 0},
            "L", new int[]{0, -1},
            "R", new int[]{0, 1}
    );


    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.foodIndex = 0;
        this.snake = new LinkedList<>();
        this.occupied = new HashSet<>();
        this.score = 0;

        // Snake starts at position (0, 0)
        snake.offerFirst(new int[]{0, 0});
        occupied.add("0,0");
    }

    //Either returns the score(food eaten) or -1 if game is over.
    public int move(String direction) {
        // 1.) Get the current position of the snake
        int[] head = snake.peekFirst();
        int headRow = head[0];
        int headCol = head[1];

        // 2.) Get the new position after the move
        int[] getDirFromMap = DIRS.get(direction);
        int newRow = headRow + getDirFromMap[0];
        int newCol = headCol + getDirFromMap[1];

        // 3.) Check that the new position is valid and is NOT a WALL
        if (newRow < 0 || newCol < 0 || newRow >= width || newCol >= height) {
            return -1;
        }

        // 3.5 -> BIGGEST EDGE CASE :
        // Before checking collision,
        // we will remove the tail
        // because when the snake's head moves,
        // the tail will also move.
        int[] tail = snake.peekLast();
        String tailPos = tail[0] + "," + tail[1];
        occupied.remove(tailPos);

        //4.) Check if the new position is NOT ALREADY PART of the SNAKE
        String newHeadPos = newRow + "," + newCol;
        if (occupied.contains(newHeadPos)) {
            return -1;
        }

        //5.) Add new head to the snake and also add to the set
        snake.offerFirst(new int[]{newRow, newCol});
        occupied.add(newHeadPos);

        //6.) If SNAKE ATE FOOD, RESTORE the TAIL
        if (foodIndex < food.length
                && newRow == food[foodIndex][0] && newCol == food[foodIndex][1]) {
            foodIndex++;
            score++;
            occupied.add(tailPos);
        }
        // Else, Remove the Tail
        else {
            snake.pollLast();
        }

        return score;
    }


    public static void main(String[] args) {
        // Initialize game with a 3x3 grid and 2 food items
        int width = 3;
        int height = 3;
        int[][] food = {{2, 0}, {0, 2}};

        SnakeGame game = new SnakeGame(width, height, food);

        // Sequence of moves and expected output
        System.out.println(game.move("D")); // → 0 (just moved)
        System.out.println(game.move("D")); // → 1 (eats food at (2,0))
        System.out.println(game.move("R")); // → 1 (just moved)
        System.out.println(game.move("U")); // → 1 (just moved)
        System.out.println(game.move("U")); // → 1 (just moved)
        System.out.println(game.move("R")); // → 2 (eats food at (0,2))
        System.out.println(game.move("D")); // → 2 (just moved)
        System.out.println(game.move("D")); // → -1 (hits wall at (3,2))
    }

}
