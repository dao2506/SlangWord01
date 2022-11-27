package CommonClass;

import java.util.ArrayList;

public class TreeWord extends Node {

    public static final Character endWord = '\0';
    public TreeWord(){
        curKey = null;
        nextNode = new ArrayList<Node>();
    }

    public TreeWord(Character key){
        curKey = key;
        nextNode = new ArrayList<Node>();
    }

    public void addNode(Node node){
        nextNode.add(node);
    }

    public void addNode(Character key){
        nextNode.add(new TreeWord(key));
    }

    public Character getCurKey(){
        return curKey;
    }

    public ArrayList<Node> getNextNode(){
        return nextNode;
    }


}
