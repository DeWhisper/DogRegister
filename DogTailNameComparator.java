import java.util.Comparator;

//Erik Blomkvist erbl4920

public class DogTailNameComparator implements Comparator<Dog> 
{
    @Override
    public int compare(Dog first, Dog second) {

        //Get the int result of the comparison
        int tailComparison = Double.compare(first.getTailLength(), second.getTailLength());

        //If the tailLengths are not the same
        if(tailComparison != 0)
        {
            return tailComparison;
        }
        else
        {
            //Return the comparison of their names instead.
            return first.getName().compareTo(second.getName());
        }
    }

}