import java.util.*;

public class AdjListSolve {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		int V = scan.nextInt();

		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		//인접리스트 작성
		for(int i=1; i<=M; i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			adjList.get(from).add(to);
			adjList.get(to).add(from);	
		}
		

		//인접리스트 오름차순 정렬
		for(int i=1; i<=N; i++) {
			Collections.sort(adjList.get(i));
		}

		//stack_dfs(V);
		recursive_dfs(V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(V);
	}



	//stack 이용 dfs
	static public void stack_dfs(int v) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(v);

		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if(visited[cur]) continue;
			else {
				visited[cur] = true;
				System.out.print(cur + " ");
				for (int i = adjList.get(cur).size()-1; i >=0; i--)	{
					int next = adjList.get(cur).get(i);
					if(!visited[next]) {
						adjList.get(next);
						stack.push(next);
					}
				}
			}
		}
		System.out.println();
	}
	
	static public void recursive_dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int i : adjList.get(v)) {
			if (!visited[i]) {
				recursive_dfs(i);
			}
		}
	}

	static public void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur + " ");
			for(int i : adjList.get(cur)) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		System.out.println();
	}
}

