/*
Problem Description
A locality is in the shape of a n*m grid where each cell in a grid represents a house. There is a serious virus outbreak in this locality. This deadly virus converts people to zombies. Each cell in the grid has one of the following three values:

0 -> House is empty

1 -> House has people but not yet infected.

2 -> House is infected and has zombies.

In one minute all the non-empty houses adjacent to an infected house get infected and the people are converted into zombies (Two houses are called adjacent if they share a common edge). If all the people are infected then the government will have to bomb the locality.

Print the minimum time after which all the non-empty houses get infected (Basically no cells in the grid should be left 1. All cell values should be 2 or 0). If all the non-empty houses will never get infected then print -1.

Input format
First line contains two space seperated integers n, m representing dimensions of the grid.

An n*m size grid is given with values 0, 1 or 2.

Output format
Print a single integer denoting the minimum time after which all the non-empty houses get infected. If all the non-empty houses will never get infected then print -1.

Sample Input 1
1

3 3

2 1 1

1 1 0

0 1 1

Sample Output 1
4

Explanation
At time 0 only the top left cell is infected.

After 1st minute, scenario

2 2 1

2 1 0

0 1 1

After 2nd minute, scenario

2 2 2

2 2 0

0 1 1

After 3rd minute, scenario

2 2 2

2 2 0

0 2 1

After 4th minute scenario

2 2 2

2 2 0

0 2 2

Therefore after the 4th minute all the non-empty houses are infected.

Sample Input 2
1

1 2

0 2

Sample Output 2
0

Explanation
At time 0 only the top right cell is infected and the top left house is empty(0 indicates empty house). Therefore the answer is 0 as at time 0 all the non-empty house is infected.

Sample Input 3
1

3 3

2 1 1

0 1 1

1 0 1

Sample Output 3
-1

Explanation
At time 0 only the top left cell is infected.

After 1st minute, scenario

2 2 1

0 1 1

1 0 1

After 2nd minute, scenario

2 2 2
*/

import java.util.*;

class Zombies {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println(zombies(grid, n, m));
            t = t - 1;
        }
        
        sc.close();
    }

    static int zombies(int[][] grid, int n, int m) {
        Queue<Cordinate> queue = new LinkedList<>();
        int minutes = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cordinate(i, j));
                }
            }
        }

        Cordinate delimiter = new Cordinate(-1, -1);

        queue.add(delimiter);

        while (!queue.isEmpty()) {
            boolean flag = false;
            while (!isDelimiter(queue.peek())) {
                Cordinate cordinate = queue.poll();

                if (isValidCordinate(cordinate.x + 1, cordinate.y, n, m) && grid[cordinate.x + 1][cordinate.y] == 1) {
                    if (!flag) {
                        minutes++;
                        flag = true;
                    }
                    grid[cordinate.x + 1][cordinate.y] = 2;
                    queue.add(new Cordinate(cordinate.x + 1, cordinate.y));
                }

                if (isValidCordinate(cordinate.x - 1, cordinate.y, n, m) && grid[cordinate.x - 1][cordinate.y] == 1) {
                    if (!flag) {
                        minutes++;
                        flag = true;
                    }
                    grid[cordinate.x - 1][cordinate.y] = 2;
                    queue.add(new Cordinate(cordinate.x - 1, cordinate.y));
                }

                if (isValidCordinate(cordinate.x, cordinate.y + 1, n, m) && grid[cordinate.x][cordinate.y + 1] == 1) {
                    if (!flag) {
                        minutes++;
                        flag = true;
                    }
                    grid[cordinate.x][cordinate.y + 1] = 2;
                    queue.add(new Cordinate(cordinate.x, cordinate.y + 1));
                }

                if (isValidCordinate(cordinate.x, cordinate.y - 1, n, m) && grid[cordinate.x][cordinate.y - 1] == 1) {
                    if (!flag) {
                        minutes++;
                        flag = true;
                    }
                    grid[cordinate.x][cordinate.y - 1] = 2;
                    queue.add(new Cordinate(cordinate.x, cordinate.y - 1));
                }

            }
            queue.remove();
            if (!queue.isEmpty()) {
                queue.add(delimiter);
            }
        }

        return checkZombies(grid, n, m) ? -1 : minutes;
    }

    private static boolean checkZombies(int[][] grid, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValidCordinate(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static boolean isDelimiter(Cordinate cordinate) {
        return cordinate.x == -1 && cordinate.y == -1;
    }
}

class Cordinate {
    int x = 0;
    int y = 0;

    public Cordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}