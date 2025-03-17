
import java.util.Arrays;

enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

class Solution {

    private int[][] gameArea;
    private int width;
    private int height;
    private boolean[][] fusing;

    public Solution(int[][] gameArea) {
        this.gameArea = gameArea;
        this.width = gameArea[0].length;
        this.height = gameArea.length;
        this.fusing = new boolean[height][width];
    }

    public static void main(String[] args){
        int[][] gameArea = new int[][]{
                {0, 1, 2, 3},
                {0, 3, 2, 1},
                {0, 0, 0, 0},
                {0, 5, 3, 5}
        };
        Solution game = new Solution(gameArea);
        System.out.println(game.getDescription());
        game.move(Direction.RIGHT);
        System.out.println(game.getDescription());
        int[][] gameArea1 = new int[][]{
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
        };
        game = new Solution(gameArea1);
        System.out.println(game.getDescription());
        game.move(Direction.UP);
        System.out.println(game.getDescription());
    }

    private void move(Direction direction) {
        switch (direction) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    private void moveRight() {
        for(int y=0; y < height; y++){
            for(int x = width-1; x >=0; x--){
                int curr = gameArea[y][x];
                if(curr == 0){// skip
                    continue;
                }
                for(int i= x+1; i < width; i++){//go left
                    if(gameArea[y][i] == 0){//Rule 1
                        gameArea[y][i] = curr;
                        gameArea[y][i-1] = 0;
                    }
                    else if(fusing[y][i] == false //Rule 3
                            && gameArea[y][i] == curr){//fuse
                        gameArea[y][i] = curr * 2;
                        fusing[y][i] = true; //Rule 3
                        gameArea[y][i-1] = 0;
                        break;
                    } else if(isFib(gameArea[y][i] +curr)){ // Rule 2
                        gameArea[y][i] = gameArea[y][i] +curr;
                        fusing[y][i] = true; //Rule 3
                        gameArea[y][i-1] = 0;
                        break;
                    }else {
                        break;
                    }
                }

            }
        }
    }

    private void moveLeft(){
        for(int y=0; y < height; y++){
            for(int x = 0; x < width; x++){
                int curr = gameArea[y][x];
                if(curr == 0){// skip
                    continue;
                }
                for(int i= x-1; i >=0; i--){
                    if(gameArea[y][i] == 0){//Rule 1
                        gameArea[y][i] = curr;
                        gameArea[y][i+1] = 0;
                    }
                    else if(fusing[y][i] == false //Rule 3
                            && gameArea[y][i] == curr){//fuse
                        gameArea[y][i] = curr * 2;
                        fusing[y][i] = true; //Rule 3
                        gameArea[y][i+1] = 0;
                        break;
                    } else if(isFib(gameArea[y][i] +curr)){ // Rule 2
                        gameArea[y][i] = gameArea[y][i] +curr;
                        fusing[y][i] = true; //Rule 3
                        gameArea[y][i+1] = 0;
                        break;
                    }else {
                        break;
                    }
                }

            }
        }

    }

    private void moveUp(){
        for(int x=0; x < width; x++){
            for(int y = 0; y < height; y++){
                int curr = gameArea[y][x];
                if(curr == 0){// skip
                    continue;
                }
                for(int i= y-1; i >=0; i--){
                    if(gameArea[i][x] == 0){//swap
                        gameArea[i][x] = curr;
                        gameArea[i+1][x] = 0;
                    }
                    else if(fusing[i][x] == false && gameArea[i][x] == curr){
                        gameArea[i][x] = curr * 2;
                        fusing[i][x] = true;
                        gameArea[i + 1][x] = 0;
                        break;
                    } else if(isFib(gameArea[i][x] +curr)){
                        gameArea[i][x] = gameArea[i][x] +curr;
                        fusing[i][x] = true;
                        gameArea[i + 1][x] = 0;
                        break;
                    }else {
                        break;
                    }
                }
            }
        }

    }

    private boolean isFib(int num) {
        int a = 0;
        int b = 1;
        while (a < num) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        return a == num;
    }

    private void moveDown(){
        for(int x=0; x < width; x++){
            for(int y = height-1; y >=0; y--){
                int curr = gameArea[y][x];
                if(curr == 0){// skip
                    continue;
                }
                for(int i= y+1; i < height; i++){//go up
                    if(gameArea[i][x] == 0){//swap
                        gameArea[i][x] = curr;
                        gameArea[i-1][x] = 0;
                    }
                    else if(fusing[i][x] == false && gameArea[i][x] == curr){
                        gameArea[i][x] = curr * 2;
                        fusing[i][x] = true;
                        gameArea[i - 1][x] = 0;
                        break;
                    } else if(isFib(gameArea[i][x] +curr)){
                        gameArea[i][x] = gameArea[i][x] +curr;
                        fusing[i][x] = true;
                        gameArea[i - 1][x] = 0;
                        break;
                    }else {
                        break;
                    }
                }

            }
        }
    }

    public int getTile(int x, int y) {
        return gameArea[y][x];
    }

    public void setTile(int x, int y, int fibValue) {
        gameArea[y][x] = fibValue;
    }

    public String getDescription() {
        StringBuilder strBuilder = new StringBuilder();
        for (int[] line : gameArea) {
            String strLine = Arrays.stream(line)
                    .mapToObj(fibVal -> String.format("%2d", fibVal))
                    .reduce((a, b) -> a + " " + b)
                    .orElse("");
            strBuilder.append(strLine).append("\n");
        }
        return strBuilder.toString();
    }
}