package Model;

import java.util.TreeSet;

public class State {
    private String spaceship;
    private TreeSet<String> left, right;

    public State(String spaceship, TreeSet<String> left, TreeSet<String> right) {
        this.spaceship = spaceship;
        this.left = left;
        this.right = right;
    }

    public boolean checkValid(TreeSet<String> s) {

        //Human && Lion
        if((s.contains("M") || s.contains("W")) && s.contains("L") && (s.contains("S") == false))
            return false;
        //Human && Cow
        if((s.contains("M") || s.contains("W")) && s.contains("C") && (s.contains("S") == false))
            return false;
        //Lion && Cow
        if(s.contains("L") && s.contains("C") && (s.contains("S") == false))
            return false;
        //Cow && Grain
        if(s.contains("C") && s.contains("G") && (s.contains("S") == false))
            return false;

        return true;
    }

    public boolean isValid() {
        if(checkValid(left) && checkValid(right))
            return true;
        else
            return false;
    }

    public boolean isSolution() {
        if(left.isEmpty() && right.contains("M") && right.contains("W")
                && right.contains("L") && right.contains("C")
                && right.contains("G") && right.contains("S"))
            return true;
        else
            return false;
    }

    public State transits(String move) {
        String nSpaceship;
        TreeSet<String> nLeft = new TreeSet<>();
        TreeSet<String> nRight = new TreeSet<>();

        if(spaceship.equalsIgnoreCase("left"))
            nSpaceship = "right";
        else
            nSpaceship = "left";

        copylist(left, nLeft);
        copylist(right, nRight);

        for (int i = 0; i < move.length(); i++)
        {
            String item = move.substring(i, i + 1);
            if (spaceship.equalsIgnoreCase("left"))
            {
                if (nLeft.remove(item))
                    nRight.add(item);
                else
                    return null; // return null if the move contains
                // occupants that are not present.
            }
            else
            {
                if (nRight.remove(item))
                    nLeft.add(item);
                else
                    return null; // return null if the move contains
                // occupants that are not present.
            }
        }

        return new State(nSpaceship, nLeft, nRight);
    }

    public void copylist(TreeSet<String> source, TreeSet<String> destination) {
        for(String s : source)
            destination.add(s);
    }

    public boolean compare(State s)
    {
        TreeSet<String> tmp;

        if (!s.getSpaceship().equalsIgnoreCase(spaceship))
            return false;

        tmp = s.getLeft();
        for (String e : left)
        {
            if (!tmp.contains(e))
                return false;
        }

        tmp = s.getRight();
        for (String e : right)
        {
            if (!tmp.contains(e))
                return false;
        }

        return true;
    }

    public String getSpaceship()
    {
        return spaceship;
    }

    public TreeSet<String> getLeft()
    {
        return left;
    }

    public TreeSet<String> getRight()
    {
        return right;
    }

    @Override
    public String toString()
    {
        StringBuffer ret = new StringBuffer();
        ret.append("{L:");

        for (String e : left)
            ret.append(e);

        ret.append(" ");
        ret.append("R:");

        for (String e : right)
            ret.append(e);

        ret.append("}");
        return ret.toString();
    }
}
