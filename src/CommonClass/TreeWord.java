package CommonClass;

import java.util.ArrayList;

public class TreeWord extends Node {


    public static final Character endWord = '\0';
    public TreeWord(){
        curKey = null;
        nextNode = new ArrayList<TreeWord>();
    }

    public TreeWord(Character key){
        curKey = key;
        nextNode = new ArrayList<TreeWord>();
    }

    public void addNode(TreeWord treeWord){
        nextNode.add(treeWord);
    }

    public void addNode(Character key){
        nextNode.add(new TreeWord(key));
    }

    public Character getCurKey(){
        return curKey;
    }

    public ArrayList<TreeWord> getNextNode(){
        return nextNode;
    }


    public void addEndWord(){
        nextNode.add(new TreeWord(endWord));
    }
}
