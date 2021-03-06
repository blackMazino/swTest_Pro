package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 그래프_DAG_KOITP_02임계경로 {
/*
https://koitp.org/problem/CRITICAL_PATH/read/
	
명우가 운영하는 공장에는 N개의 공정이 있고, 각 공정 사이에는 M개 작업 관계가 있다. 
공정을 정점으로, 작업 관계를 방향성 간선으로 표현했을 때, 아래와 같은 그림이 된다:

그림 1
1->2
1->4
1->3
2->7
2->6
4->6
3->5
6->7
5->6

위 그림에서 1번 공정에서 작업이 시작되어 2번, 3번, 4번 공정에 작업한 결과물을 보낸다. 
작업한 결과물을 보내는데 걸리는 시간은 간선 가중치와 동일하며, 각 공정에서 작업하는데 걸리는 시간은 무시할 수 있을 만큼 작다. 
다만, 한 공정에서 작업을 시작하기 위해서는 이전에 필요한 작업 결과물을 다 받은 상황에서 시작할 수 있다. 
예를 들어, 6번 공정에서 작업을 시작하기 위해서는 2번 공정, 4번 공정, 5번 공정에서 작업한 결과물을 모두 받아야한다.
1번 공정에서 작업을 시작했을 때, N번 공정에서 작업을 완료하는 최소 시간을 구하는 프로그램을 작성하시오.

입력
입력의 첫 줄에 공정의 수 N과 컨베이어 벨트의 수 M이 공백으로 구분되어 주어진다. (1 ≤ N ≤ 100,000, 1 ≤ M ≤ 300,000)
그리고 다음 M개의 줄에 각 컨베이어 벨트에 대한 정보를 나타내는 세 정수가 공백으로 구분되어 주어진다. 
"a b c"라고 주어졌을 때 a번 공정에서 b번 공정으로 작업을 보내야하는데 보내는데 걸리는 시간이 c라는 것을 의미한다. 
(1 ≤ a, b ≤ N, 1 ≤ c ≤ 10,000, a ≠ b)

작업은 항상 1번 공정에서 시작하며, N번 공정에서 끝난다. 
입력으로 주어지는 정보를 그래프로 표현했을 때, 그래프는 DAG(Directed Acyclic Graph)가 되며, 1
번 정점으로 들어오는 간선의 개수는 0이고, N번 정점에서 나가는 간선의 개수 또한 0이다. 그리고 항상 작업이 완료되도록 입력이 주어진다.

출력
1번 공정에서 작업을 시작하여 N번 공정에서 작업이 완료되는데 걸리는 최소 시간을 출력한다.

7 9
1 2 4
1 3 2
1 4 3
2 6 3
2 7 5
3 5 1
4 6 4
5 6 2
6 7 5

12
*/	
	static int N,M;
	static int[]d, indegree;
	static ArrayList<Integer>[] con,conW;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        indegree = new int[N+1];
        con = new ArrayList[N+1];
        conW = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
        	con[i] = new ArrayList<>(); 
        	conW[i] = new ArrayList<>();
        }
        
        for(int i=1;i<=M;i++){
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	con[a].add(b);
        	conW[a].add(c);
        	indegree[b]++;
        }
        d = new int[N+1];
        topologicalSortByStack();        
	}
	private static void topologicalSortByStack() {
		LinkedList<Integer> stack = new LinkedList<>();
		
		for(int i=1;i<=N;i++){
			if(indegree[i]==0){
				stack.addLast(i);
			}
		}
		
		while(!stack.isEmpty()){
			int s = stack.removeLast();
			for(int i=0;i<con[s].size();i++){
				int e = con[s].get(i);
				int c = conW[s].get(i);
				indegree[e]--;
				if(indegree[e]==0){
					stack.addLast(e);
				}
				d[e] = Math.max(d[e], d[s]+c);
			}
			
		}
		System.out.println(d[N]);
	}

}
