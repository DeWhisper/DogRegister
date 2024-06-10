import java.util.Comparator;

//Erik Blomkvist erbl4920

public class DogNameComparator implements Comparator<Dog>{

@Override
    public int compare(Dog first, Dog second) {
        
        return first.getName().compareTo(second.getName());

    } 
}
