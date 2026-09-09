class Solution {
    public static void main(String[] args) {
        
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    gridTraversal(grid, visited, r, c, rows, cols);
                }
            }
        }

        return count;
    }

    private static void gridTraversal(char[][] grid, boolean[][] visited, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || visited[r][c] || grid[r][c] == '0') return;

        visited[r][c] = true;

        gridTraversal(grid, visited, r + 1, c, rows, cols);
        gridTraversal(grid, visited, r - 1, c, rows, cols);
        gridTraversal(grid, visited, r, c + 1, rows, cols);
        gridTraversal(grid, visited, r, c - 1, rows, cols);
    }
}