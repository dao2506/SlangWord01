package CommonClass;

// nguồn tham khảo: https://leduythuccs.github.io/2018-05-23-c-u-tr-c-d-li-u-trie/
// Trong bài viết gốc tác giả dùng ngôn ngữ C++, Lê Phương Đào (sinh viên làm đồ án này) đã viết lại bằng java
// và chỉnh sửa để phù hợp với bài toán cần xử lí hiện tại.
public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public Trie(Character rootKey){
        root = new TrieNode(rootKey);
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
}
