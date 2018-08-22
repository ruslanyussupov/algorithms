import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashSet;

public class WordLadder {

	private static final ArrayList<String> WORDS = 
	new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log", "hit", "cog"));
	
	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> graph = getGraph(WORDS);
		for (String key : graph.keySet()) {
			System.out.println(key + " = " + graph.get(key));
		}
		bfs(graph, "hit", "cog");
	}

	private static HashMap<String, ArrayList<String>> getGraph(ArrayList<String> words) {
		HashMap<String, ArrayList<String>> graph = new HashMap<>();

		if (words == null || words.size() == 0) {
			return null;
		}

		for (String word : words) {
			graph.put(word, new ArrayList<String>());
		}

		while (!words.isEmpty()) {

			ArrayList<String> neighbours = new ArrayList<>();
			String first = words.get(0);
			char[] firstChars = first.toCharArray();

			for (int i = 1; i < words.size(); i++) {
				String word = words.get(i);
				char[] wordChars = word.toCharArray();
				if (firstChars[0] == wordChars[0] && firstChars[1] == wordChars[1]) {
					graph.get(first).add(word);
					graph.get(word).add(first);
					continue;
				}
				if (firstChars[0] == wordChars[0] && firstChars[2] == wordChars[2]) {
					graph.get(first).add(word);
					graph.get(word).add(first);
					continue;
				}
				if (firstChars[1] == wordChars[1] && firstChars[2] == wordChars[2]) {
					graph.get(first).add(word);
					graph.get(word).add(first);
				}
			}

			words.remove(0);

		}

		return graph;
	}

	private static bfs(HashMap<String, ArrayList<String>> graph, 
		String start, String end) {
		Queue<String> searchQueue = new ArrayDeque<>(graph.get(start));
		HashSet<String> searched = new HashSet<>();
		searched.add(start);
		String path = start;

		while(!searchQueue.isEmpty()) {
			String word = searchQueue.poll();
			if (!searched.contains(word)) {
				path = path + " -> " + word;
				if (word.equals(end)) {
					System.out.println(path);
					return;
				} else {
					searched.add(word);
					searchQueue.addAll(graph.get(word));
				}
			}
		}
	}

}