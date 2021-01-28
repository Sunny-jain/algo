class Result {
  
  static int solveSudoku(int mat[][])
  {
    if(solve(mat, 0, 0)){
      return 1;
    }
    else{
      return 0;
    }
    
  }
  static boolean solve(int mat[][], int r, int c){
    if (r == 9 - 1 && c == 9)
      return true;
    if (c == 9) {
      r++;
      c = 0;
    }
    if (mat[r][c] != 0)
      return solve(mat, r, c + 1);
    for(int i = 1; i <= 9; i++){
      if(isSafe(mat, i, r, c)){
        
        mat[r][c] = i;
    
        if(solve(mat, r, c) == true){
          return true;
        }
        else{
          mat[r][c] = 0;
        }
      }
    }
    return false;
  }
  static boolean isSafe(int mat[][], int num, int r, int c){
    // vertical up
    int row=r-1;
    int col=c;
    while(row >= 0){
      if(mat[row][col] == num){
        return false;
      }
      row--;
    }
    // verticall down
    row=r+1;
    col=c;
    while(row <= 8){
      if(mat[row][col] == num){
        return false;
      }
      row++;
    }
    //horizontally left
    row=r;
    col=col-1;
    while(col >= 0){
      if(mat[row][col] == num){
        return false;
      }
      col--;
    }
    //horizontally right
    row=r;
    col=col+1;
    while(col <= 8){
      if(mat[row][col] == num){
        return false;
      }
      col++;
    }
    // in small matrix
    row = r - (r % 3);
    col = c - (c % 3);
    for(int i = row; i < row + 3; i++){
      for(int j = col; j < col + 3; j++){
        if(mat[i][j] == num){
          return false;
      	}
      }
    }
    return true;
  }
}
