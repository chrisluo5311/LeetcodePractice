package tree.trie;

import java.util.LinkedList;
import java.util.List;

public class TrieMap<V> {
    // ASCII 碼個數
    private static final int R = 256;
    // 當前存在 Map 中的鍵值對個數
    private int size = 0;

    private static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] child = new TrieNode[R];
    }

    // Trie 樹根節點
    private TrieNode<V> root;

    // 增/改
    // 在Map中添加key
    public void put(String key, V value) {
        if (!containsKey(key)){
            //新增鍵值對
            size++;
        }
        root = put(root, key, value, 0);
    }

    // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
    private TrieNode<V> put(TrieNode<V> node, String key, V value, int i) {
        if (node == null) {
            // 如果樹枝不存在，新建
            node = new TrieNode<V>();
        }
        if (i == key.length()) {
            // key 的路径已插入完成，将值 val 存入节点
            node.val = value;
            return node;
        }
        char c = key.charAt(i);
        node.child[c] = put(node.child[c], key, value, i + 1);
        return node;
    }

    // 刪
    // 刪除key以及對應的值
    public void remove(String key) {
        if (!containsKey(key)){
            return;
        }
        root = remove(root, key, 0);
        size--;
    }

    private TrieNode<V> remove(TrieNode<V> node, String key, int i) {
        if (node == null) {
            return null;
        }
        if (i == key.length()) {
            // 找到了 key 对应的 TrieNode，删除 val
            node.val = null;
        } else {
            char c = key.charAt(i);
            //遞歸去子樹進行刪除
            node.child[c] = remove(node.child[c], key, i + 1);
        }
        // 后序位置，递归路径上的节点可能需要被清理
        if (node.val != null) {
            // 如果该 TireNode 存储着 val，不需要被清理
            return node;
        }
        // 检查该 TrieNode 是否还有后缀
        for (char c = 0; c < R;c++){
            if (node.child[c] != null) {
                // 只要存在一个子节点（后缀树枝），就不需要被清理
                return node;
            }
        }
        // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
        return null;
    }

    // 查
    // 搜尋key對應的值，不存在則返回null
    // get("the") = 4
    // get("tha") = null
    public V get(String key) {
        //從root開始搜索key
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            // x 為空或x的val字段為空都說明key沒有對應的值
            return null;
        }
        return x.val;
    }

    // 判断 key 是否存在在 Map 中
    // containsKey("tea") -> false
    // containsKey("team") -> true
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    // 在 Map 的所有键中搜索 query 的最短前缀
    // shortestPrefixOf("themxyz") -> "the"
    public String shortestPrefixOf(String query) {
        TrieNode<V> p = root;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                return query.substring(0, i);
            }
            char c = query.charAt(i);
            p = p.child[c];
        }

        if (p != null && p.val != null) {
            // 如果query本身就是一個鍵
            return query;
        }
        return "";
    }

    // 在 Map 的所有键中搜索 query 的最长前缀
    // longestPrefixOf("themxyz") -> "them"
    public String longestPrefixOf(String query) {
        TrieNode<V> p = root;
        //紀錄前綴最大長度
        int maxLen = 0;

        // 從節點node開始搜索key
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                return "";
            }
            if (p.val != null) {
                // 找到一個鍵是query的前綴，更新前綴的長度
                maxLen = i;
            }
            //向下搜索
            char c = query.charAt(i);
            p = p.child[c];
        }

        if (p != null && p.val != null) {
            return query;
        }

        return query.substring(0, maxLen);
    }

    // 搜索所有前缀为 prefix 的键
    // keysWithPrefix("th") -> ["that", "the", "them"]
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new LinkedList<>();
        //找到匹配prefix在Trie樹中的那個節點
        TrieNode<V> x = getNode(root, prefix);
        if (x == null) {
            return res;
        }
        // DFS遍歷以x為根的這棵Trie樹
        traverse(x, new StringBuilder(prefix), res);
        return res;
    }

    private void traverse(TrieNode<V> node, StringBuilder path, List<String> res) {
        if (node == null) {
            //到達底部
            return;
        }
        if (node.val != null) {
            //找到一個key, 添加到結果列表中
            res.add(path.toString());
        }

        //回溯算法遍歷框架
        for (char c = 0; c < R; c++) {
            // 做選擇
            path.append(c);
            traverse(node.child[c], path, res);
            //撤銷選擇
            path.deleteCharAt(path.length() - 1);
        }
    }

    // 判断是和否存在前缀为 prefix 的键
    // hasKeyWithPrefix("tha") -> true
    // hasKeyWithPrefix("apple") -> false
    public boolean hasKeyWithPrefix(String prefix) {
        return getNode(root, prefix) != null;
    }

    // 通配符 . 匹配任意字符，搜索所有匹配的键
    // keysWithPattern("t.a.") -> ["team", "that"]
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        traverse2(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    private void traverse2(TrieNode<V> node, StringBuilder path, String pattern, int i, List<String> res) {
        if (node == null) {
            return;
        }
        if (i == pattern.length()) {
            // patter匹配完成
            if (node.val != null) {
                res.add(path.toString());
            }
            return;
        }
        char c = pattern.charAt(i);
        if (c == '.') {
            // pattern[i]是通配符，可以變化成任意字符
            // 多叉樹(回溯算法)遍歷框架
            for (char j = 0 ; j < R; j++){
                path.append(j);
                traverse2(node.child[j], path, pattern, i + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        } else {
            // patter[i] 是普通字符c
            path.append(c);
            traverse2(node.child[c], path, pattern, i + 1, res);
            path.deleteCharAt(path.length() - 1);
        }

    }

    // 通配符 . 匹配任意字符，判断是否存在匹配的键
    // hasKeyWithPattern(".ip") -> true
    // hasKeyWithPattern(".i") -> false
    public boolean hasKeyWithPattern(String pattern) {
        return hasKeyWithPattern(root, pattern, 0);
    }

    public boolean hasKeyWithPattern(TrieNode<V> node, String pattern, int i) {
        if (node == null) {
            return false;
        }
        if (i == pattern.length()) {
            return node.val != null;
        }
        char c = pattern.charAt(i);
        // 沒遇到通配符(.)
        if (c != '.'){
            // 从 node.children[c] 节点开始匹配 pattern[i+1..]
            return hasKeyWithPattern(node.child[c], pattern, i + 1);
        }
        //　遇到通配符(.)
        for (char j = 0 ; j < R; j++){
            if (hasKeyWithPattern(node.child[j], pattern, i + 1)) {
                return true;
            }
        }
        // 都沒有匹配
        return false;
    }

    // 從節點 node 開始搜索key，如果存在返回對應節點，否則返回null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        // 從節點node開始搜索key
        for (int i = 0 ; i < key.length(); i++){
            if (p == null) {
                return null;
            }
            //向下搜索
            char c = key.charAt(i);
            p = p.child[c];
        }
        return p;
    }

    public int size() {
        return size;
    }
}
