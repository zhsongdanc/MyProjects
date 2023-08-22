package com.demussong.lc;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2023/3/24 22:20
 */
public class L200 {
   class BFS{
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int res = 0;
            int rowNum = grid.length;
            int colNum = grid[0].length;
            boolean[][] visited = new boolean[rowNum][colNum];

            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        bfs(i, j, grid, visited);
                        res++;
                    }
                }
            }
            return res;
        }




        public void bfs(int i, int j, char[][] grid, boolean[][] visited) {
            int rowNum = grid.length;
            int colNum = grid[0].length;
            Deque<Integer> deque = new LinkedList<>();
            deque.add(i*colNum + j);
            visited[i][j] = true;
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int k = 0; k < size; k++) {
                    Integer tmp = deque.removeFirst();
                    int tmpI = tmp/colNum;
                    int tmpJ = tmp%colNum;
                    if (isValid(tmpI - 1, rowNum, tmpJ, colNum) && !visited[tmpI - 1][tmpJ] && grid[tmpI - 1][tmpJ] == '1') {

                        deque.add((tmpI - 1)*colNum + tmpJ);
                        visited[tmpI - 1][tmpJ] = true;
                    }
                    if (isValid(tmpI + 1, rowNum, tmpJ, colNum) && !visited[tmpI + 1][tmpJ] && grid[tmpI + 1][tmpJ] == '1') {

                        deque.add((tmpI + 1)*colNum + tmpJ);
                        visited[tmpI + 1][tmpJ] =true;
                    }
                    if (isValid(tmpI, rowNum, tmpJ - 1, colNum) && !visited[tmpI][tmpJ -1] && grid[tmpI ][tmpJ - 1] == '1') {
                        deque.add((tmpI)*colNum + tmpJ - 1);
                        visited[tmpI][tmpJ - 1] =true;
                    }
                    if (isValid(tmpI, rowNum, tmpJ + 1, colNum) && !visited[tmpI][tmpJ + 1] && grid[tmpI][tmpJ + 1] == '1') {
                        deque.add((tmpI)*colNum + tmpJ + 1);
                        visited[tmpI][tmpJ + 1] =true;

                    }

                }

            }
        }

        public boolean isValid(int i, int rowNum, int j, int colNum) {
            return i >= 0 && i < rowNum && j >= 0 && j < colNum;
        }

    }


    class BCJ{
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int res = 0;
            int rowNum = grid.length;
            int colNum = grid[0].length;
            int[] parent = new int[rowNum*colNum];
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (grid[i][j] == '1') {
                        find(i, j, parent, rowNum, colNum);
                    }
                }
            }
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (grid[i][j] == '1') {
                        int p = findParent(i * colNum + j, parent);
                        set.add(p);
                    }
                }
            }

            return set.size();


        }

        public void find(int i, int j,int[] parent,int rowNum,int colNum) {
            if (i - 1>= 0 && i -1 < rowNum && j >=0 && j < colNum) {
                union(i - 1, j, i, j, parent, rowNum, colNum);
            }
            if (i + 1>= 0 && i + 1< rowNum && j >=0 && j < colNum) {
                union(i + 1, j, i, j, parent, rowNum, colNum);
            }
            if (i >= 0 && i < rowNum && j - 1>=0 && j -1< colNum) {
                union(i, j, i, j - 1, parent, rowNum, colNum);
            }
            if (i >= 0 && i < rowNum && j + 1>=0 && j + 1 < colNum) {
                union(i, j, i, j + 1, parent, rowNum, colNum);
            }
        }

        public void union(int i,int j,int m,int n,int[] parent,int rowNum,int colNum) {
            int x1 = i*colNum + j;
            int x2 = m*colNum + n;
            int p1 = findParent(x1, parent);
            int p2 = findParent(x2, parent);
            parent[p1] = p2;
        }

        public int findParent(int m,int[] parent) {
            while (parent[m] != m) {
                m = parent[m];
            }
            return m;
        }
    }



    class DFS{
        // dfs
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }
            int count = 0;
            int rowNum = grid.length;
            int colNum = grid[0].length;
            boolean[][] visited = new boolean[rowNum][colNum];
            for (int i = 0; i < rowNum; i++) {
                for (int j = 0; j < colNum; j++) {
                    if (!visited[i][j] && grid[i][j] == '1') {
                        dfs(i, j , visited, grid);
                        count++;
                    }

                }
            }
            return count;

        }

        public void dfs(int i, int j, boolean[][] visited, char[][] grid){
            if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || visited[i][j] || grid[i][j] == '0') {
                return;
            }
            visited[i][j] = true;
            dfs(i - 1, j, visited, grid);
            dfs(i + 1, j, visited, grid);
            dfs(i, j - 1 ,visited, grid);
            dfs(i , j + 1, visited, grid);
        }
    }

}
