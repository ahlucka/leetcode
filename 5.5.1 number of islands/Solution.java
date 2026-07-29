class Solution {
    public static void main(String[] args) {
        
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[rows][col];

        int count = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    gridTraversal (grid, visited, r, c, rows, col);
                }
            }
        }
        return count;
    }

    private static void gridTraversal(char[][] matrix, boolean[][] visited, int r, int c, int rows, int col) {
        if (r < 0 || r >= rows || c < 0 || c >= col || visited[r][c] == true || matrix[r][c] == '0') return;
        
        visited[r][c] = true;
        
        gridTraversal(matrix, visited, r + 1, c, rows, col);
        gridTraversal(matrix, visited, r - 1, c, rows, col);
        gridTraversal(matrix, visited, r, c + 1, rows, col);
        gridTraversal(matrix, visited, r, c - 1, rows, col);
    }

}