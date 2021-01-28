//printing number of ways to get out maze.

class Result {
  static int count=0;
  public static int solveMaze(int maze[][], int size) {
    
    helper(maze, 0, 0, size);
    return count;
  }
  public static void helper(int maze[][], int r, int c, int n){
    
    if(r == n-1 && c==n-1){
     
      count++;
      return;
    }
    if(c+1 < n && maze[r][c+1] != -1){
      
      helper(maze, r, c+1, n);
    }
    if(r+1 < n && maze[r+1][c] != -1){
      helper(maze, r+1, c, n);
    }
  }
}
