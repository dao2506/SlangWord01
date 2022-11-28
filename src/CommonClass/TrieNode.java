package CommonClass;


import java.util.ArrayList;
import java.util.HashMap;

// nguồn tham khảo: https://leduythuccs.github.io/2018-05-23-c-u-tr-c-d-li-u-trie/
// Trong bài viết gốc tác giả dùng ngôn ngữ C++, Lê Phương Đào (sinh viên làm đồ án này) đã viết lại bằng java
// và chỉnh sửa để phù hợp với bài toán cần xử lí hiện tại.
public class TrieNode {
    HashMap<Character, TrieNode> children;
    Character key;
    boolean isWord;
}

