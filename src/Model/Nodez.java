package Model;

import java.util.ArrayList;

public class Nodez {
    public Nodez parent; // Parent of the node
    public State data; // State of the node
    public ArrayList<Nodez> children; // Children of the node
    public int level; // Depth of the node
    public String move;

    public Nodez(State data) {
        parent = null;
        this.data = data;
        children = new ArrayList<Nodez>();
        level = 0;
        move = "";
    }

    public boolean isAncestor() {
        Nodez n = parent;
        boolean ret = false;
        while (n != null)
        {
            if (data.compare(n.data))
            {
                ret = true;
                break;
            }
            n = n.parent;
        }

        return ret;
    }
}
