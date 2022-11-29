package CommonClass;

// nguồn tham khảo: https://leduythuccs.github.io/2018-05-23-c-u-tr-c-d-li-u-trie/
// Trong bài viết gốc tác giả dùng ngôn ngữ C++, Lê Phương Đào (sinh viên làm đồ án này) đã viết lại bằng java
// và chỉnh sửa để phù hợp với bài toán cần xử lí hiện tại.
public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public Trie(TrieNode rootNode){
        root = rootNode;
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char l: word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public boolean isEmpty() {
        return root == null  ;
    }
    public boolean find(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public void delete(String word) {
        delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
}
