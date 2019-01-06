package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
743. Network Delay Time


There are N network nodes, labelled 1 to N.
Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

1에서 N까지 레이블이 지정된 N 개의 네트워크 노드가 있습니다.
주어진 시간, 방향 edge [i] = (u, v, w)로 이동 시간 목록, 여기서 u는 소스 노드, v는 대상 노드, w는 신호가 이동하는 데 걸리는 시간 타겟팅 할 소스.
이제 우리는 특정 노드 K로부터 신호를 보냅니다. 모든 노드가 신호를 수신하는 데 시간이 얼마나 걸립니까? 불가능할 경우 -1을 반환합니다.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.
Accepted
 */
public class Network_Delay_Time_743 {
	public static void main(String[] args) {
        Solution sol = new Solution();
	}
}

class Solution {
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[2], edge[1]});
        }
        for (int node : graph.keySet()) {
            Collections.sort(graph.get(node), (a, b) -> a[0] - b[0]);
        }
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);

        DFS(graph, K, 0);
        int ans = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }

    // 깊이우선탐색(DFS, Depth-First Search)
    public void DFS(Map<Integer, List<int[]>> graph, int node, int elapsed) {
        if (elapsed >= dist.get(node)) return;
        dist.put(node, elapsed);
        if (graph.containsKey(node))
            for (int[] info: graph.get(node))
                DFS(graph, info[1], elapsed + info[0]);
    }
    /*
           그래프 탐색 : 하나의 정점부터 시작해서 차례로 모든 정점들을 한 번씩 방문
           * 깊이우선탐색(DFS, Depth-First Search)
           루트 노드 혹은 다른 임의 노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법 (깊게 탐색하는 것이다)
           보통 모든 노드를 방문하고자 하는 경우 이 방법을 많이 사용함
           단순 검색 속도 자체는 너비 우선 탐색 (BFS)에 비해서 느리다 (대신 더 간단함)

           * 특징
           1. 자기 자신을 호출하는 순환 알고리즘 형태
           2. 전위 순회를 포함한 다른 형태의 트리 순회는 모두 DFS의 한 종류이다.
           3. 그래프 탐색의 경우, 어떤 노드를 방문했었는지 여부를 반드시 검사해야함 (검사하지않으면, 무한루프에 빠질 수 있음)
     */
}


