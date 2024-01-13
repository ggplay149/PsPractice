package 단계별풀기.no_31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no_02 {
    //알고리즘 수업 - 깊이 우선 탐색 2
    static StringBuilder sb = new StringBuilder();
    static List<ArrayList<Integer>> graph;
    static boolean[] visit;
    static int[] visitNum;
    static int n;
    static int count=1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        graph = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        visit = new boolean[n+1];
        visitNum = new int[n+1];

        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        //배열안에 배열로 초기화
        for(int i = 0 ; i <= n ; i ++){
            graph.add(new ArrayList<Integer>());
        }

        //노드별로 인접 노드 넣어주기
        for(int i = 0 ; i < m ; i ++){
            st = new StringTokenizer(br.readLine());
            int fromNode= Integer.parseInt(st.nextToken());
            int toNode = Integer.parseInt(st.nextToken());
            graph.get(fromNode).add(toNode);
            graph.get(toNode).add(fromNode);

        }

        //들어간 인접노드들 정렬
        for(int i = 0 ; i <= n ; i ++){
            Collections.sort(graph.get(i), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
        }


        dfs(r);
        for(int i = 1 ; i < n+1 ; i ++){
            sb.append(visitNum[i]).append("\n");
        }
        System.out.print(sb);
    }

    public static void dfs(int start ){

        visit[start] = true;
        visitNum[start] = count++;
        for(int i = 0 ; i < graph.get(start).size() ; i++){
            if(!visit[graph.get(start).get(i)]){
                dfs(graph.get(start).get(i));
            }
        }
    }
}
