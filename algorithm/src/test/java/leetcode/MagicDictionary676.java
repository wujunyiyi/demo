package leetcode;

/**
 * @author Adam Wu
 * @date 2022-07-11 15:24:23
 */
public class MagicDictionary676 {
    Trie root;
    boolean flag = false;

    public MagicDictionary676() {
        root = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String dic : dictionary) {
            Trie node = root;
            for (char c : dic.toCharArray()) {
                Trie[] n = node.children;
                int i = c - 'a';
                if (n[i] == null) n[i] = new Trie();
                node = n[i];
            }
            node.isEnd = true;
        }
    }

    public boolean search(String searchWord) {
        dfs(searchWord, 0, root, false);
        return flag;
    }

    boolean dfs(String word, int pos, Trie node, boolean diff) {
        if (pos == word.length()) {
            if (diff && node.isEnd)
                flag = true;

            return diff && node.isEnd;
        }

        int idx = word.charAt(pos) - 'a';

        if (diff) {
            if (node.children[idx] != null) {
                return dfs(word, pos + 1, node.children[idx], diff);
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    if (idx != i) {
                        return dfs(word, pos + 1, node.children[i], true);
                    } else {
                        dfs(word, pos + 1, node.children[i], diff);
                    }
                }
            }
        }

        return false;
    }

    class Trie {
        boolean isEnd;
        Trie[] children;

        public Trie() {
            this.isEnd = false;
            this.children = new Trie[26];
        }
    }

    public static void main(String[] args) {
        MagicDictionary676 m = new MagicDictionary676();
        m.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(m.search("leetcoded"));
    }
}
