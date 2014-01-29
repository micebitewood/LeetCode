public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if (words == null || words.length == 0)
            return res;
        if (L == 0) {
            res.add("");
            return res;
        }
        Queue<String> queue = new LinkedList<String>();
        int length = 0;
        for (String word: words) {
            if (word.length() + length > L) {
                add(res, queue, length, L);
                length = 0;
            }
            queue.add(word);
            length += word.length() + 1;
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 0) {
            sb.append(queue.poll() + " ");
        }
        sb.delete(sb.length() - 1, sb.length());
        while (sb.length() < L)
            sb.append(" ");
        res.add(sb.toString());
        return res;
    }
    
    private void add(ArrayList<String> res, Queue<String> queue, int length, int L) {
        int size = queue.size();
        length -= size;
        int spaces = L - length;
        StringBuilder sb = new StringBuilder();
        while (size > 0) {
            sb.append(queue.poll());
            if (size > 1) {
                int count = spaces / (size - 1);
                if (count * (size - 1) < spaces)
                    count++;
                spaces -= count;
                for (int i = 0; i < count; i++) {
                    sb.append(" ");
                }
            }
            size--;
        }
        while (sb.length() < L) {
            sb.append(" ");
        }
        res.add(sb.toString());
    }
}