package class_swProblemSolving;
 
import java.io.BufferedReader;  
import java.io.FileInputStream; 
import java.io.InputStreamReader;   
import java.util.ArrayList; 
import java.util.Comparator;    
import java.util.PriorityQueue; 
import java.util.StringTokenizer;   
 
public class PreviousSolving2_01_Graph_인터스텔라 {
/*
우주 여행이 보편화된 미래에 인류는 N개의 행성을 지구화하여 살고 있다. 
행성들은 1번부터 N번까지 번호가 붙어 있다. 물론 이때도 두 행성 사이를 여행할 때는 최단 경로를 사용하고 싶어 할 것이다. 
모든 두 행성의 쌍 간에 직접 여행이 가능하면 좋겠지만 우주에는 블랙홀, 성운, 감마선 지대 등이 있어서 직접 여행이 불가능한 경우가 많이 있다. 우리는 직접 여행이 가능한 모든 M개의 쌍들을 알고 있으며 이 쌍들 간에 여행하는 데 필요한 시간도 알고 있다. 
시간은 어떤 단위시간으로 자연수로 표시될 것이다.
여러분이 사용할 우주선에는 특별히 K개의 워프 패킷이 있어서 워프 패킷을 사용하여 기존에 여행이 가능한 행성의 쌍에 한하여
 1 단위 시간에 여행을 할 수 있다. 사용 가능한 워프 패킷의 개수는 최대 2개이다. 주어진 워프 패킷을 모두 사용할 필요는 없다.
위의 그림에서 원은 행성, 원 안의 수는 행성의 번호, 선은 직접 여행이 가능한 행성의 쌍, 선 옆의 수는 그 소요 시간을 나타낸다. 
이 예에서 1번 행성에서 4번 행성으로 여행하려고 한다고 하자. 사용 가능한 워프 패킷의 개수가 0개인 경우 최소 시간은 9가 될 것이다.
사용 가능한 워프 패킷이 1개인 경우 최소 시간은 7이 된다. 
마지막으로, 사용 가능한 워프 패킷의 개수가 2개인 경우 최소 시간은 4가 된다.
행성의 수와 여행이 가능한 행성들의 쌍 및 그 여행 시간, 그리고 사용 가능한 워프 패킷의 개수를 입력으로 받아, 두 행성 사이를 여행하는 최단 시간을 계산하는 프로그램을 작성하라.
[입력]
첫째 줄에 테스트 케이스의 개수 T가 주어지고, 이후 차례로 T개 테스트 케이스가 주어진다. 
각 케이스의 첫째 줄에는 행성의 개수를 나타내는 자연수 N과 여행 가능한 행성의 쌍의 개수인 M, 그리고 워프 패킷의 개수 K가 주어진다. (2 ≤ N ≤ 100,000, 1 ≤ M ≤ 200,000, 0 ≤ K ≤ 2) 
행성들은 1번부터 N번까지 번호가 붙어 있다. 다음 M개의 줄에는 각각 하나씩의 여행 가능한 행성의 쌍이 주어진다.
즉, 각 줄에는 세개의 자연수가 주어지는데, 첫 두 수는 행성의 번호이고 세번째 수는 두 행성 간을 여행하는 데 걸리는 시간이다.
행성 간을 여행하는 데 걸리는 시간은 1 이상 100,000 이하의 자연수이다. 
한 줄에 있는 두 행성의 번호는 항상 다르며, 동일한 행성의 쌍은 최대 한번만 주어진다. 
임의의 두 행성 간에 (필요하면 다른 행성을 거쳐서) 여행할 수 있는 방법이 항상 존재함이 보장된다. 
마지막 줄에는 여행하는 거리를 계산하고 싶은 두 행성의 번호가 주어진다.
[출력]
각각의 테스트 케이스에 대하여 #x (x는 1부터 시작하는 테스트 케이스의 번호)를 출력하고 공백을 하나 둔 다음, 두 행성 사이를 여행하는 최단 시간을 하나의 자연수로 출력한다. 출력할 값은 32비트 정수 변수로 표현할 수 있는 범위를 넘을 수 있음에 주의하라.
[입출력 예]
(입력)
3
6 6 0
1 2 3
5 1 2
5 6 5
3 4 3
6 4 6
2 3 3
1 4
6 6 1
1 2 3
5 1 2
5 6 5
3 4 3
6 4 6
2 3 3
4 1
6 6 2
1 2 3
5 1 2
5 6 5
3 4 3
6 4 6
2 3 3
1 4
 
(출력)
#1 9
#2 7
#3 4
*/  
    static int T,N,M,K,start,end,a,b,c; 
    static ArrayList<Integer>[] con = new ArrayList[100000+1];    
    static ArrayList<Integer>[] conv = new ArrayList[100000+1];   
          
    static long D[][];// = new long[100000+1][2+1]; 
          
    public static void main(String[] args) throws Exception {   
        //System.setIn(new FileInputStream("input.ini")); 
        //System.setIn(new FileInputStream("sample_input.ini"));  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st; 
        T = Integer.parseInt(br.readLine());    
              
              
        for(int i=1;i<=100000;i++) { 
            con[i] = new ArrayList<Integer>();    
            conv[i] = new ArrayList<Integer>();   
        }   
              
        for(int tc=1;tc<=T;tc++) {   
            st = new StringTokenizer(br.readLine());    
            N = Integer.parseInt(st.nextToken());     
            M = Integer.parseInt(st.nextToken());   
            K = Integer.parseInt(st.nextToken());   
            /*  
            con = new ArrayList[N+1];   
            conv = new ArrayList[N+1];  
                  
            for(int i=1;i<=N;i++) {  
                con[i] = new ArrayList<Integer>();    
                conv[i] = new ArrayList<Integer>();   
            }   
            */  
                  
            for(int i=1;i<=100000;i++) { 
                con[i].clear(); 
                conv[i].clear();    
            }   
                  
                  
                  
            for(int i=1;i<=M;i++) {  
                st = new StringTokenizer(br.readLine());    
                a = Integer.parseInt(st.nextToken());   
                b = Integer.parseInt(st.nextToken());   
                c = Integer.parseInt(st.nextToken());   
                      
                con[a].add(b); con[b].add(a);   
                conv[a].add(c); conv[b].add(c); 
            }   
                  
            st = new StringTokenizer(br.readLine());    
            start = Integer.parseInt(st.nextToken());   
            end = Integer.parseInt(st.nextToken()); 
                  
            D = new long[N+1][K+1]; 
                  
                  
            for(int i=1;i<N+1;i++) { 
                for(int j=0;j<K+1;j++) { 
                    D[i][j] = Long.MAX_VALUE;   
                }   
            }   
                  
            PriorityQueue<long[]> Q = new PriorityQueue<>(10, new Comparator<long[]>() {  
                public int compare(long[] o1, long[] o2) {  
                    return (int)(o1[0]-o2[0]);  
                }   
            }); 
                  
            for(int j=0;j<=K;j++) {  
                D[start][j] = 0;    
            }   
                  
            Q.add(new long[]{0, start, 0}); 
      
            boolean arrive = false ;    
            while( !Q.isEmpty() && !arrive ) {  
                long d = Q.peek()[0];   
                int q = (int)Q.peek()[1];   
                int p_cnt = (int)Q.peek()[2];   
                      
                Q.poll();   
                      
                if(D[q][p_cnt] != d) continue;  
                      
                if(D[end][p_cnt] == d) break;   
                      
                for(int i=0;i<con[q].size();i++) {   
                    int t = con[q].get(i);  
                    int v = conv[q].get(i); 
                          
                    if ( D[t][p_cnt] > D[q][p_cnt] + v ) {   
                        D[t][p_cnt] = D[q][p_cnt] + v;  
                              
                        Q.add(new long[]{D[t][p_cnt], t, p_cnt});   
                    }   
                          
                    if ( ( p_cnt < K ) &&    
                         ( D[t][p_cnt+1] > D[q][p_cnt] + 1 ) ) { 
                        D[t][p_cnt+1] = D[q][p_cnt] + 1;    
                              
                        Q.add(new long[]{D[t][p_cnt+1], t, p_cnt+1});   
                    }   
                }   
            }   
                  
            long ans = Long.MAX_VALUE;  
            for(int i=0;i<=K;i++) {  
                ans = Math.min(ans, D[end][i]); 
            }   
                  
            System.out.println("#"+tc+" "+ans); 
        }   
    } 
}