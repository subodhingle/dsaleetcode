import java.util.*;

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;

        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pb] < rank[pa]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        DSU dsu = new DSU(c + 1);

        // Build DSU
        for (int[] e : connections) {
            dsu.union(e[0], e[1]);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        int[] offCount = new int[c + 1];

        // Count how many times node goes offline
        for (int[] q : queries) {
            if (q[0] == 2) {
                offCount[q[1]]++;
                online[q[1]] = false;
            }
        }

        // Component -> TreeSet of ONLINE nodes
        Map<Integer, TreeSet<Integer>> comp = new HashMap<>();

        for (int i = 1; i <= c; i++) {
            if (online[i]) {
                int root = dsu.find(i);
                comp.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        // Reverse processing
        for (int i = queries.length - 1; i >= 0; i--) {
            int type = queries[i][0];
            int x = queries[i][1];

            int root = dsu.find(x);

            if (type == 1) {
                if (online[x]) {
                    ans.add(x);
                } else {
                    TreeSet<Integer> set = comp.get(root);
                    if (set == null || set.isEmpty()) ans.add(-1);
                    else ans.add(set.first());
                }
            } else {
                // Reverse offline → decrease count
                offCount[x]--;

                if (offCount[x] == 0) {
                    online[x] = true;
                    comp.computeIfAbsent(root, k -> new TreeSet<>()).add(x);
                }
            }
        }

        Collections.reverse(ans);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);

        return res;
    }
}