import java.util.Comparator;

//Erik Blomkvist erbl4920

public class DogTailComparator implements Comparator<Dog>
{

    @Override
    public int compare(Dog first, Dog second) {
        
        if(first.getTailLength() < second.getTailLength())
        {
            return -1;
        }
        
        if(first.getTailLength() > second.getTailLength())
        {
            return 1;
        }
        return 0;

    }
}
