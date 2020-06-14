public class Percolation {

    public static int timing = 1;

    // given an n-by-n matrix of open sites, return an n-by-n matrix
    // of sites reachable from the top
    public static boolean[][] flow(boolean[][] isOpen, int[][] discoveryTimes, int[][] finishingTimes) {
        int n = isOpen.length;
        boolean[][] isFull = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            flow(isOpen, isFull, 0, j, discoveryTimes, finishingTimes);
        }
        return isFull;
    }

    // determine set of full sites using depth first search and mark the time of discovering and finishing of each site
    public static void flow(boolean[][] isOpen, boolean[][] isFull, int i, int j, int[][] discoveryTimes, int[][] finishingTimes) {
        int n = isOpen.length;

        // base cases
        if (i < 0 || i >= n) return;    // invalid row
        if (j < 0 || j >= n) return;    // invalid column
        if (!isOpen[i][j]) return;      // not an open site
        if (isFull[i][j]) return;       // already marked as full

        // mark i-j as full
        isFull[i][j] = true;
        discoveryTimes[i][j] = timing++;

        flow(isOpen, isFull, i+1, j, discoveryTimes, finishingTimes);   // down
        flow(isOpen, isFull, i, j+1, discoveryTimes, finishingTimes);   // right
        flow(isOpen, isFull, i, j-1,  discoveryTimes, finishingTimes);   // left
        flow(isOpen, isFull, i-1, j,  discoveryTimes, finishingTimes);   // up

        finishingTimes[i][j] = timing++;
    }

    public static void print(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        StdOut.println(m + " " + n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                StdOut.printf("%2d ", a[i][j]);
            }
            StdOut.println();
        }
    }

    // does the system percolate?
    public static boolean percolates(boolean[][] isOpen, int[][] discoveryTimes, int[][] finishingTimes) {
        int n = isOpen.length;
        boolean[][] isFull = flow(isOpen, discoveryTimes, finishingTimes);
        for (int j = 0; j < n; j++) {
            if (isFull[n-1][j]) return true;
        }
        return false;
    }

    // test client
    public static void main(String[] args) {
        boolean[][] isOpen = StdArrayIO.readBoolean2D();

        int n = isOpen.length;
        int[][] discoveryTimes = new int[n][n];
        int[][] finishingTimes = new int[n][n];

        StdArrayIO.print(flow(isOpen, discoveryTimes, finishingTimes));
        timing = 1;
        StdOut.println(percolates(isOpen, discoveryTimes, finishingTimes));

        StdOut.println("Discovery times:");
        print(discoveryTimes);
        StdOut.println("Finishing Times:");
        print(finishingTimes);
    }

}
