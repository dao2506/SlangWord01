package CommonClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HandleTreeWord {
    public static TreeWord root;
    public static void DFS(TreeWord root){
        if (root == null){
            return;
        }
        Queue<TreeWord> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            while (n>0){
                TreeWord p = q.poll();
                assert p != null;
                System.out.println(p.getCurKey());
                ArrayList<TreeWord> pNextTreeWord = p.getNextNode();
                for (TreeWord treeWord : pNextTreeWord) {
                    q.offer(treeWord);
                }
                n--;
            }
        }

    }

    public static void main(String[] args) {
        root = new TreeWord('S');
        TreeWord leaf = new TreeWord(TreeWord.endWord);

        TreeWord treeWord1 = new TreeWord('&');
        TreeWord treeWord1Child1 = new TreeWord('D');
        treeWord1Child1.addNode(leaf);
        TreeWord treeWord1Child2 = new TreeWord('M');
        treeWord1Child2.addEndWord();
        treeWord1.addNode(treeWord1Child1);
        treeWord1.addNode(treeWord1Child2);





        DFS(root);
    }
}
