package Model;

import java.util.ArrayList;

public class PathFinder {
    private ArrayList<Node> fsm;
    private ArrayList<Node> paths;
    private ArrayList<Node> shortestPaths;

    public PathFinder(ArrayList<Node> fsm){
        this.fsm = fsm;
        paths = new ArrayList<>();
        shortestPaths = new ArrayList<>();
//        pathFinding(); //Incomplete Modified DFS (bobo version)
        BFS();
    }

    //Panghanap ng pandesal
    private void BFS(){
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Node> visited = new ArrayList<>();
        Node pStart =null;
        Node pHead = pStart;
        if (pStart == null)
            pHead = cloneNode(fsm.get(0));
        list.add(pHead);

        while(!list.isEmpty()) {
            Node node = list.get(0);
            list.remove(list.get(0));
            if (!(node.getsType().equals("final") || node.getsType().equals("dead"))) {
                visited.add(node);
                for (int j = 0; j < node.getpLinks().size(); j++) {
                    Node n = cloneNode(node.getpLinks().get(j));
                    if(!isVisited(n, node) && !((n.getsType().equals("dead")))) {
                        n.setpPrev(node);
                        list.add(n);
                    }
                }
            } else if (node.getsType().equals("final")) {
                paths.add(node);
                if(countPath(node) <9)
                    shortestPaths.add(node);
            }
        }
        displayShortestPaths();
        System.out.println("List of all possible solutions for the given fsm (NO REPETITIVE STATES): ");
        display();
    }

    private void displayShortestPaths(){
        System.out.println("List of shortest paths for the given fsm: ");
        for (int i = 0; i < shortestPaths.size(); i++)
            displayStates(i, shortestPaths.get(i));
        System.out.println();
    }

    private int countPath(Node node){
        Node pTemp = node;
        int i;
        for (i = 0; pTemp != null; i++)
            pTemp = pTemp.getpPrev();
        return i;
    }


    //pang-isahan lang
    private boolean isVisited(ArrayList<Node> visited, Node n){
        for (int i = 0; i < visited.size(); i++) {
            if(visited.get(i).getState().equals(n.getState()))
                return true;
        }
        return false;
    }

    private boolean isVisited(Node n, Node node){
        Node pHead = node;
        while(pHead != null){
            if(pHead.getState().equals(n.getState()))
                return true;
            pHead = pHead.getpPrev();
        }
        return false;
    }

    //displaying solution
    private void display(){
        for (int i = 0; i < paths.size(); i++) {
            Node pLink = paths.get(i);
            displayStates(i, pLink);
        }
    }


    //for debugging
    private void displayStates(int i, Node node){
        String str = i+1 + ". ";
            while(node != null){
                str += node.getState();
                if(node.getpPrev() != null)
                    str+="<-";
                node = node.getpPrev();
            }
            System.out.println(str);
    }
    public String displayStatez(int i, Node node){
        String str = "";
        while(node != null){
            str += node.getState();
            if(node.getpPrev() != null)
                str+="<-";
            node = node.getpPrev();
        }
        return str;
    }


    //Incomplete Modified dfs (Bobo version)
//    private void pathFinding(){
//        ArrayList<Node> past = new ArrayList<>();
//        Node pStart = null;
//        Node pHead = null;
//        Node pTemp = null;
//
//        while(past.size() < 22){
//            if(pStart == null) {
//                pHead = pTemp = pStart = cloneNode(fsm.get(0)); //inits the start node
//            }
//
//            //path find, gets next node
//            pHead.setpNext(nextNode(past, pHead));
//            pHead = pHead.getpNext();
//
//            if(pHead == null){
//                pHead = backtracking(pTemp, past);
//
//            }
//
//            pHead.setpPrev(pTemp);
//            pTemp = pHead;
//
//            if(pHead.getsType().equals("final")){
//                System.out.println(pHead.getState());
//                paths.add(pStart);
//                displaySolution();
//                pStart = null;
//            }else if(pHead.getState().equals("000001") || pHead.getState().equals("111110"))
//                pHead = pHead.getpPrev();
//        }
//        displaySolution();
//    }
//
//
//
//    private Node nextNode(ArrayList<Node> past, Node head){
//        Node fState = findFinal(head);
//        if(fState == null)
//            for (int i = 0; i < head.getpLinks().size(); i++) {
//            if(!head.getpLinks().get(i).getsType().equals("dead") && !pastFound(past, head.getpLinks().get(i))) {
//                past.add(head.getpLinks().get(i));
//                return head.getpLinks().get(i);
//            }
//        } else{
//                return fState;
//            }
//
//        return null;
//    }
//
//    private boolean pastFound(ArrayList<Node> past, Node state){
//            for (int i = 0; i < past.size(); i++) {
//                if (!state.getsType().equals("final") && past.get(i).getState().equals(state.getState()))
//                    return true;
//            }
//
//        return false;
//    }
//
//    private void displaySolution(){
//        for (int i = 0; i < paths.size(); i++) {
//          Node pStart = paths.get(i);
//          while(pStart != null){
//              if(!pStart.getsType().equals("final"))
//                System.out.print(pStart.getState() + "-> ");
//              else System.out.println(pStart.getState());
//              pStart = pStart.getpNext();
//          }
//            System.out.println();
//        }
//    }
//
////    private Node getpStart(Node pHead){
////        while(pHead.getpPrev() != null) {
////            System.out.print(pHead.getState() + "<- ");
////            pHead = pHead.getpPrev();
////        }
////        System.out.print(pHead.getState() + "<- ");
////
////        System.out.println();
////        return pHead;
////    }
//
//    private Node findFinal(Node state){
//        for (int i = 0; i < state.getpLinks().size(); i++) {
//            if(state.getpLinks().get(i).equals("final"))
//                return state.getpLinks().get(i);
//        }
//        return null;
//    }
//
    private Node cloneNode(Node node){
        return new Node(node);
    }
//
//    private Node backtracking(Node pHead, ArrayList<Node> past){
//        Node pNext;
//        Node pPrev = pHead.getpPrev();
//        do{
//            pNext = pPrev.getpPrev();
//            pNext = nextNode(past, pNext);
//            pPrev = pPrev.getpPrev();
//        }while(pNext == null);
//        return pNext;
//    }

    //insert this code in main to display all sol
//    public static void main(String[] args) {
//        PathFinder a = new PathFinder(new FSM().getFsm());
//    }

    public ArrayList<Node> getPaths() {
        return paths;
    }
    public ArrayList<Node> getShortestPaths() {
        return shortestPaths;
    }
}
