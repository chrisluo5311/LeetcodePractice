package tree.leetcode;

import java.util.*;

public class WordLadder_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        int len = beginWord.length();
        // build genric list first => {generic word, List of old words(neighbors)}
        // { "*ot", ["hot", "dot", "lot"}
        // { "*og", ["log", "dog", "cog"]}
        // O(MN)
        Map<String, List<String>> comboList = new HashMap<>();
        wordList.forEach(word -> {
            for (int i = 0 ; i < len ; i++) {
                String genericWord = word.substring(0, i) + "*" + word.substring(i+1,len);
                List<String> neighbors = comboList.getOrDefault(genericWord, new ArrayList<>());
                neighbors.add(word);
                comboList.put(genericWord, neighbors);
            }
        });

        // queue for bfs
        // <Word, level> => level is tree height
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        // track visited word
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            // pull from queue
            Pair<String, Integer> curr = queue.poll();
            String currWord = curr.getKey();
            Integer level = curr.getValue();
            for (int i = 0 ; i < len ; i++) {
                String genericWord = currWord.substring(0,i) + "*" + currWord.substring(i+1,len);
                List<String> neighbors = comboList.getOrDefault(genericWord, new ArrayList<>());
                for (String neighbor: neighbors) {
                    // reach the destination
                    if (neighbor.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.containsKey(neighbor)) {
                        // put new neighbor into queue
                        queue.add(new Pair(neighbor, level+1));
                        // mark as visited
                        visited.put(neighbor, true);
                    }
                }
            }
        }
        return 0;
    }

    private class Pair<T, T1> {
        private T key;
        private T1 value;

        public Pair(T key, T1 value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public T1 getValue() {
            return value;
        }
    }
}
