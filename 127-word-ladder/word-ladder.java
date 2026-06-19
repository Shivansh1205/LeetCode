class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        // corner cases
        if (beginWord.equals(endWord)) return 1;
        else if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>(); // mark visited at Generation
        queue.offer(beginWord);
        wordSet.remove(beginWord);

        // bfs
        int size = queue.size();
        int dist = 1;

        while (size > 0) {
            for (int idx = 0; idx < size; idx++) { // poll per level
                char[] word = (queue.poll()).toCharArray();

                // traverse nei of word
                for (int i = 0; i < word.length; i++) {
                    char original = word[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original) continue;

                        word[i] = c;
                        String nei = new String(word);
                        if (nei.equals(endWord)) return dist + 1;

                        // check if nei is valid (in graph && not visited)
                        if (wordSet.contains(nei)) {
                            // mark visited at generation
                            queue.offer(nei);
                            wordSet.remove(nei);
                        }
                    }

                    // IMPORTANT! put back
                    word[i] = original;
                }
            }

            size = queue.size();
            dist++;
        }

        return 0;
    }
}