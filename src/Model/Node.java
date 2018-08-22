package Model;

import java.util.ArrayList;

public class Node {
    private ArrayList<Node> pLinks;
    private Node pPrev;
    private Node pNext;
    private String state;
    private String sType;
    private ArrayList<Node> visited;

    public Node(String state, String sType, Node pPrev){
        this.state = state;
        this.sType = sType;
        this.pPrev = pPrev;
        this.pNext = null;
        pLinks = new ArrayList<>();
        visited = new ArrayList<>();
    }

    public Node(Node node){
        this.state = node.getState();
        this.sType = node.getsType();
        this.pPrev = node.getpPrev();
        this.pNext = node.getpNext();
        pLinks = (ArrayList<Node>) node.getpLinks().clone();
    }

    public void setVisited(ArrayList<Node> visited) {
        this.visited = visited;
    }

    public ArrayList<Node> getVisited() {
        return visited;
    }

    public ArrayList<Node> getpLinks() {
        return pLinks;
    }

    public void setpLink(ArrayList<Node> pLink) {
        this.pLinks = pLinks;
    }

    public void insertLink(Node pLink){ pLinks.add(pLink);}

    public Node getpPrev() {
        return pPrev;
    }

    public void setpPrev(Node pPrev) {
        this.pPrev = pPrev;
    }

    public String getState() {
        return state;
    }

    public String getsType() {
        return sType;
    }

    public Node getpNext() {
        return pNext;
    }

    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }

    public void setState(String state) {
        this.state = state;
    }


}
