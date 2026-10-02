class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character> > row= new HashMap<>();
        HashMap<Integer, Set<Character>> col= new HashMap<>();

        HashMap<String, Set<Character>> squares= new HashMap<>();

        //create empty sets

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                row.put(i, new HashSet<>());
                col.put(i, new HashSet<>());
            }
        }
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++){
                if(board[r][c] == '.'){
                    continue;
                }
                String squareKey= (r/3)+","+(c/3);

                if(!squares.containsKey(squareKey)) {
                    squares.put(squareKey, new HashSet<>());
                }
                
                // OR
                //if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    

                if( row.get(r).contains(board[r][c]) || 
                    col.get(c).contains(board[r][c]) ||    
                    squares.get(squareKey).contains(board[r][c])){

                    return false;
                }

                row.get(r).add(board[r][c]);
                col.get(c).add(board[r][c]);

                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
    }
}
