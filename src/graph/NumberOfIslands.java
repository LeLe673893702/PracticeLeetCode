package graph;

import java.util.*;

/**
 * 200. 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
 * 你可以假设网格的四个边均被水包围。
 *
 * 输入:
 * 11110
 * 11010
 * 10100
 * 01000
 *
 * 输出: 1
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 */
public class NumberOfIslands {
    public class Point {

        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
//        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
//        NumberOfIslands numberOfIslands = new NumberOfIslands();
//        numberOfIslands.numIslands(grid);

        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        primeNumbers.add(5);
        boolean isPrime = false;
        for (int i = 6; i < 100; i++) {
            isPrime = true;
            for (Integer primeNumber : primeNumbers) {
                if (primeNumber >= i || i % primeNumber == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primeNumbers.add(i);
        }
        primeNumbers.forEach(System.out::println);
    }

    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; i++) {
                if (grid[i][j] == '1') {

                }
            }
        }
        return 4;
    }

    public boolean isLands(int i, int j, char[][] grid) {
        boolean left, right, up,down;
        if (i - 1 < 0) {
            left = true;
        } else {
            left = grid[i - 1][j] == '1';
        }
        if (i + 1 >= grid.length) {
            right = true;
        } else {
            right = grid[i+1][j] == '1';
        }

        if (j - 1 < 0) {
            up = true;
        } else {
            up = grid[i][j-1] == '1';
        }

        if (j + 1 >= grid[0].length) {
            down = true;
        } else {
            down = grid[i][j+1] == '1';
        }

        return left || right || down || up;
    }
}
