class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        int[] leftarr = new int[n];
        int[] upperarr = new int[2*n-1];
        int[] lowerarr = new int[2*n-1]; 
        List<List<String>> res = new ArrayList();
        solve(0,res, leftarr,upperarr,lowerarr,board);
        return res;
    }

    public void solve(int col,List<List<String>>res,int[] leftarr,int[] upperarr,int[] lowerarr, char[][]board){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        for(int row =0; row<board.length;row++){
            if(leftarr[row]==0 && upperarr[row+col]==0 && lowerarr[board.length-1+col-row]==0){
                board[row][col] = 'Q';
                leftarr[row] = 1;
                upperarr[row+col] =1;
                lowerarr[board.length-1+col-row] =1;
                solve(col+1,res,leftarr,upperarr,lowerarr,board);
                board[row][col] = '.';
                leftarr[row] = 0;
                upperarr[row+col] =0;
                lowerarr[board.length-1+col-row] =0;
            }
        }
    }

    public List<String> construct(char [][] board){
        List<String> res = new ArrayList();
        for(int row =0; row<board.length;row++){
            String s = new String(board[row]);
            res.add(s);
        }
        return res;
    }
}