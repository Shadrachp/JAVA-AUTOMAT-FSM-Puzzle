package Model;

import java.util.ArrayList;

public class Node {
    private ArrayList<Node> pLinks;
    private Node pPrev;
    private String state;
    private String sType;

    public Node(String state, String sType, Node pPrev){
        this.state = state;
        this.sType = sType;
        this.pPrev = pPrev;
        pLinks = new ArrayList<>();
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

    public void setState(String state) {
        this.state = state;
    }


}
