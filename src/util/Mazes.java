/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author S542046
 */
public class Mazes {

    /**
     * Get Shortest Path
     * 
     * @param grid  the grid of the maze, with # = wall, E = solution, and anything else valid space
     * @param x     the starting x value
     * @param y     the starting y value
     * @return      the shortest path to the letter E
     */
    public static int gsp(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (grid[x][y] == '#') {
            return Integer.MAX_VALUE;
        }
        if (grid[x][y] == 'E') {
            return 0;
        }
        grid[x][y] = '#';
        int west = gsp(grid.clone(), x - 1, y);
        int north = gsp(grid.clone(), x, y + 1);
        int east = gsp(grid.clone(), x + 1, y);
        int south = gsp(grid.clone(), x, y - 1);

        if (west == Integer.MAX_VALUE && east == Integer.MAX_VALUE && north == Integer.MAX_VALUE && south == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        int nw = Math.min(west, north);
        int se = Math.min(south, east);
        return Math.min(nw, se) + 1;

    }

}
