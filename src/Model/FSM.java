package Model;

import java.util.ArrayList;

public class FSM {
    private ArrayList<Node> fsm;

    public FSM(){
        createFSM();
    }

    private void createFSM(){
        fsm = new ArrayList<>();
        fsm.add(createState("000000", "start")); //starting state
        fsm.add(createState("100110", "node"));
        fsm.add(createState("000010", "node"));
        fsm.add(createState("110110", "node"));
        fsm.add(createState("010000", "node"));
        fsm.add(createState("111010", "node"));
        fsm.add(createState("001000", "node"));
        fsm.add(createState("101110", "node"));
        fsm.add(createState("000100", "node"));
        fsm.add(createState("100111", "node"));
        fsm.add(createState("000001", "node"));

        //left
        fsm.add(createState("111111", "final")); //goal/accepting state
        fsm.add(createState("011001", "node"));
        fsm.add(createState("111101", "node"));
        fsm.add(createState("001001", "node"));
        fsm.add(createState("101111", "node"));
        fsm.add(createState("000101", "node"));
        fsm.add(createState("110111", "node"));
        fsm.add(createState("010001", "node"));
        fsm.add(createState("111011", "node"));
        fsm.add(createState("011000", "node"));
        fsm.add(createState("111110", "node"));
        fsm.add(createState("-1", "dead"));


        //q17
        findState("000000").insertLink(findState("100110"));

        //q16
        findState("100110").insertLink(findState("000010"));
        findState("100110").insertLink(findState("000100"));
        findState("100110").insertLink(findState("000000"));

        //q19
        findState("000010").insertLink(findState("110110"));//q20
        findState("000010").insertLink(findState("100111"));//q14
        findState("000010").insertLink(findState("101110"));//q21
        findState("000010").insertLink(findState("100110"));//q16
        findState("000010").insertLink(findState("111010"));//q18

        //q20
        findState("110110").insertLink(findState("000010"));
        findState("110110").insertLink(findState("000100"));
        findState("110110").insertLink(findState("010000"));

        //q10
        findState("010000").insertLink(findState("110110"));
        findState("010000").insertLink(findState("111010"));

        //q18
        findState("111010").insertLink(findState("000010"));//q19
        findState("111010").insertLink(findState("001000"));//q9
        findState("111010").insertLink(findState("010000"));//q10
        findState("111010").insertLink(findState("011000"));//q7

        //q9
        findState("001000").insertLink(findState("101110"));
        findState("001000").insertLink(findState("111010"));

        //q21
        findState("101110").insertLink(findState("000010"));
        findState("101110").insertLink(findState("001000"));
        findState("101110").insertLink(findState("000100"));

        //q15
        findState("000100").insertLink(findState("100111"));//q14
        findState("000100").insertLink(findState("100110"));//q16
        findState("000100").insertLink(findState("110110"));//q20
        findState("000100").insertLink(findState("101110"));//q21

        //q14
        findState("100111").insertLink(findState("000100"));//q15
        findState("100111").insertLink(findState("000001"));//q24
        findState("100111").insertLink(findState("000010"));//q19
        findState("100111").insertLink(findState("000101"));//q13

        //q24
        findState("000001").insertLink(findState("100111"));//q14


        //q13
        findState("000101").insertLink(findState("100111"));//q14
        findState("000101").insertLink(findState("110111"));//q11
        findState("000101").insertLink(findState("101111"));//q12
        findState("000101").insertLink(findState("111101"));//q4

        //q11
        findState("110111").insertLink(findState("000101"));//q13
        findState("110111").insertLink(findState("010001"));//q6

        //q12
        findState("101111").insertLink(findState("000101"));//q13
        findState("101111").insertLink(findState("001001"));//q5

        //q5
        findState("001001").insertLink(findState("101111"));//q12
        findState("001001").insertLink(findState("111101"));//q4
        findState("001001").insertLink(findState("111011"));//q3

        //q4
        findState("111101").insertLink(findState("011001"));//q2
        findState("111101").insertLink(findState("001001"));//q5
        findState("111101").insertLink(findState("010001"));//q6
        findState("111101").insertLink(findState("011000"));//q7
        findState("111101").insertLink(findState("000101"));//q13

        //q6
        findState("010001").insertLink(findState("111011"));//q3
        findState("010001").insertLink(findState("111101"));//q4
        findState("010001").insertLink(findState("110111"));//q11

        //q3
        findState("111011").insertLink(findState("011000"));//q7
        findState("111011").insertLink(findState("010001"));//q6
        findState("111011").insertLink(findState("001001"));//q5
        findState("111011").insertLink(findState("011001"));//q2

        //q7
        findState("011000").insertLink(findState("111010"));//q18
        findState("011000").insertLink(findState("111110"));//q8
        findState("011000").insertLink(findState("111101"));//q4
        findState("011000").insertLink(findState("111011"));//q3

        //q8
        findState("111110").insertLink(findState("011000"));//q7

        //q2
        findState("011001").insertLink(findState("111101"));//q4
        findState("011001").insertLink(findState("111011"));//q3
        findState("011001").insertLink(findState("111111"));//q0

        //q0 final state, game should stop when this state reached

        //link all states to dead state
        for (int i = 0; i < fsm.size(); i++) {
            if(!fsm.get(i).getsType().equals("dead"))
                fsm.get(i).insertLink(findState("-1"));
        }
        System.out.println("success");
    }

    private Node createState(String state, String sType){
        Node node = new Node(state, sType, null);
        return node;
    }

    private Node findState(String state){
        for (int i = 0; i < fsm.size(); i++) {
            if(fsm.get(i).getState().equals(state))
                return fsm.get(i);
        }
        return null;
    }

    public ArrayList<Node> getFsm() {
        return fsm;
    }
}