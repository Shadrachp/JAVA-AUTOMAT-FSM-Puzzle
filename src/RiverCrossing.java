import model.Nodez;
import model.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class RiverCrossing {
    private String[] moves = { "S", "SW", "SM", "SC", "SL", "SG",
                                        "SWM", "SWC", "SWL", "SWG",
                                                "SMC", "SML", "SMG",
                                                "SLC", "SLG", "SCG"};
    private ArrayList<Nodez> queue;
    private ArrayList<Nodez> solutions;
    private Nodez root;

    public RiverCrossing() {
        queue = new ArrayList<Nodez>();
        solutions = new ArrayList<Nodez>();
    }

    public void startBreadthFirstSearch()
    {
        solutions = new ArrayList<Nodez>(); // Initialize solutions to zero
        TreeSet<String> left = new TreeSet<String>();
        left.add("W");
        left.add("M");
        left.add("C");
        left.add("L");
        left.add("G");
        left.add("S");

        State inits = new State("left", left, new TreeSet<String>());
        root = new Nodez(inits);
        root.level = 0;
        queue.add(root);

        while (!queue.isEmpty())
        {
            Nodez n = queue.remove(0);
            System.out.println("Processing Level " + n.level + " " + n.data);
            for (String m : moves)
            {

                State s = n.data.transits(m);

                if (s != null && s.isValid()) // Check if it is allowable state
                {

                    Nodez child = new Nodez(s);
                    child.parent = n;
                    child.level = n.level + 1;
                    child.move = m + " moves " + child.data.getSpaceship();

                    // Check that a node doesn't occur already as ancestor to
                    // prevent cycle in the graph
                    if (!child.isAncestor())
                    {
                        n.children.add(child);

                        if (child.data.isSolution() == false)
                        {
                            queue.add(child);
                            System.out.println("Adding state " + child.data);
                        }
                        else
                        {
                            solutions.add(child);
                            System.out.println("Found solution " + child.data);

                        }
                    }

                }

            }

        }
    }

    public void printBFSGraph()
    {
        ArrayList<Nodez> queue = new ArrayList<Nodez>();

        queue.add(root);

        while (!queue.isEmpty())
        {
            Nodez n = queue.remove(0);
            System.out.println("Level " + n.level + " " + n.data);

            ArrayList<Nodez> adjlist = n.children;
            for (Nodez e : adjlist)
            {
                queue.add(e);
            }

        }

    }

    public void printSolution(){
        System.out.println("No. of solutions:  " + solutions.size());
        ArrayList<Nodez> stack;

        Iterator<Nodez> iter = solutions.iterator();
        int i = 1;
        while (iter.hasNext())
        {
            stack = new ArrayList<Nodez>();
            Nodez n = iter.next();
            stack.add(n);

            n = n.parent;
            while (n != null)
            {
                stack.add(n);
                n = n.parent;
            }
            System.out.println("Solution " + i);
            printSequence(stack);
            i++;
        }

    }

    private void printSequence(ArrayList<Nodez> stack) {
        StringBuffer buf = new StringBuffer();
        buf.append("No. of moves: ");
        buf.append(stack.size() - 1);
        buf.append("\n");
        for (int i = stack.size() - 1; i >= 0; i--)
        {
            Nodez n = stack.get(i);
            buf.append(n.data.toString());
            if (i != 0)
            {
                buf.append("--");
                buf.append(stack.get(i - 1).move);
                buf.append("->>");

            }
        }

        System.out.println(buf.toString());

    }
}
