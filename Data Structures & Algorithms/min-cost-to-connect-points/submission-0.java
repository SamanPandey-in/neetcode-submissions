//Prisms algo
// Start with any point
// find cheapest available edge
// add new point to mst -> cost adds
// add edge to PQ
// repeat
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] vis = new boolean[n];
        int ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b [1]);

        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], cost = curr[1];

            if (vis[u]) {
                continue;
            }

            vis[u] = true;
            ans += cost;

            for (int v = 0; v < n; v++) {
                if (!vis[v]) pq.offer(new int[]{v, dist(points[u], points[v])});
            }
        }
        return ans;
    }
    private int dist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
