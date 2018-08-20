import Model.FSM;
import Model.Node;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
    //test
       ArrayList<Node> b = new FSM().getFsm(); //initializes fsm
        for (int i = 0; i < b.size(); i++) {
            System.out.println(b.get(i).getsType() + " State: " + b.get(i).getState() + "\n");
            System.out.println("Links: ");
            for (int j = 0; j < b.get(i).getpLinks().size(); j++)
                System.out.println(b.get(i).getpLinks().get(j).getState());
            System.out.println("-------------------");
        }

    }


}
