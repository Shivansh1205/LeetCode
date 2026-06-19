import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);

        if (!st.contains(endWord)) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        st.remove(beginWord);

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            String word = curr.word;
            int steps = curr.steps;

            if (word.equals(endWord)) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;

                    String newWord = new String(arr);

                    if (st.contains(newWord)) {
                        st.remove(newWord);
                        q.offer(new Pair(newWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}