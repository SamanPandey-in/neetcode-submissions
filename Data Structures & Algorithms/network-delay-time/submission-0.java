class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int[] t : times) adj.get(t[0]).add(new int[]{t[1], t[2]});

        int[] time = new int[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        time[k] = 0;
        pq.offer(new int[]{0, k}); //{time, src}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int curDist = curr[0], node = curr[1];


            if (curDist > time[node]) continue;

            for (int[] it : adj.get(node)) {
                int nextNode = it[0];
                int wt = it[1];

                if (time[node] + wt < time[nextNode]) {
                    time[nextNode] = time[node] + wt;
                    pq.offer(new int[]{time[nextNode], nextNode});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (time[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, time[i]);
        }
        return ans;


    }
}