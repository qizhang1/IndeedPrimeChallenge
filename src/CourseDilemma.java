import java.util.*;

/**  
* Course Dilemma
* @author Qi Zhang
* @version Jun 13, 2015.
*/
public class CourseDilemma {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numTestCases = stdin.nextInt();

		test:
		for (int i = 1; i <= numTestCases; i++) {
			int numCourses = stdin.nextInt();
			int numPrereq = stdin.nextInt();

			// construct 2D graph matrix
			int[][] graph = new int[numCourses][numCourses];
			for (int j = 0; j < numPrereq; j++) {
				int u = stdin.nextInt(); // to
				int v = stdin.nextInt(); // from
				graph[v][u] = 1;
			}
			
			// course set -- track remaining courses
			HashSet<Integer> remainingCourses = new HashSet<>();
			for (int j = 0; j < numCourses; j++){
				remainingCourses.add(j);
			}
			
			int numSemester = 0;
			
			while (!remainingCourses.isEmpty()){
				ArrayList<Integer> zeroInDegreeNodes = getZeroIndegreeNode(graph, remainingCourses);
				if (zeroInDegreeNodes.size() == 0){
					System.out.printf("Case %d: Never Ends%n", i);
					continue test;
				}
				numSemester++;
				removeZeroIndegreeNode(graph, zeroInDegreeNodes, remainingCourses);
			}
			System.out.printf("Case %d: %d semester(s)%n", i, numSemester);			
		}
		stdin.close();
	}

	/**  
	* get 0 indegree courses
	* @param graph
	* @param set -- remaining courses set
	* @return list of 0 indegree courses
	*/
	private static ArrayList<Integer> getZeroIndegreeNode(int[][] graph, HashSet<Integer> set) {
		
		ArrayList<Integer> result = new ArrayList<>();
		outer:
		for (int col : set){
			for (int row = 0; row < graph.length; row++){
				if (graph[row][col] == 1){
					continue outer;
				}
			}
			result.add(col);
		}
		return result;
	}
	
	/**  
	* modify graph to remove 0 indegree courses. 
	* courses are also removed from remaining courses set
	* @param graph
	* @param set -- remaining courses set
	* @param zeroInDegreeNodes
	*/
	private static void removeZeroIndegreeNode(int[][] graph,
			ArrayList<Integer> zeroInDegreeNodes, HashSet<Integer> set) {
		
		for (int n : zeroInDegreeNodes) {
			for (int col = 0; col < graph.length; col++) {
				graph[n][col] = 0;
			}
			set.remove(n);
		}
	}
}
