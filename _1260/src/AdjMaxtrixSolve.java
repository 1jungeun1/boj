import java.util.*;

public class AdjMaxtrixSolve {
	static boolean visited[], adjTable[][];
	static public void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int V = scan.nextInt();
		adjTable = new boolean[N+1][N+1];
		visited = new boolean[N+1];
		
		//인접행렬 작성
		for(int i = 1; i <= M; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			
			adjTable[x][y] = true;
			adjTable[y][x] = true;
		}
		
		
		dfs(V, N);
		visited = new boolean[N+1];
		System.out.println();
		bfs(V, N);
		
	}
	
	static void dfs(int v, int n) {
		visited[v] = true;
		System.out.print(v + " ");
		for(int i = 1; i <= n; i++) {
			if(!visited[i] && adjTable[v][i]) {
				dfs(i, n);
			}
		}
	}
	
	static void bfs(int v, int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			
			for(int i = 1; i <= n; i++) {
				if(adjTable[cur][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
