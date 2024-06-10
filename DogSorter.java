import java.util.ArrayList;
import java.util.Comparator;

//Erik Blomkvist erbl4920

public class DogSorter{

    public static int sortDogs(Comparator<Dog> comparator, ArrayList<Dog> dog){
        int totalSwaps = 0;

        //Goes through the whole arraylist
        for(int i = 0; i < dog.size(); i++){
            //Gets the comparison of each dog.
            int index = nextDog(comparator, dog, i);

            //If the dog should swap
            if(index != i){
                swapDogs(dog, i, index);
                totalSwaps++;
            }
        }
        //return the amount of swaps made.
        return totalSwaps;
    }
    
    private static ArrayList<Dog> swapDogs(ArrayList<Dog> arrayList, int firstIndex, int secondIndex){
        //Stores the first index in a temporary dog.
        Dog tempDog = arrayList.get(firstIndex);

        //Replaces the first dog with the second.
        arrayList.set(firstIndex, arrayList.get(secondIndex));
        //Replaces the second dog with the temp dog.
        arrayList.set(secondIndex, tempDog);

        return arrayList;
    }
    private static int nextDog(Comparator<Dog> comparator, ArrayList<Dog> dog, int startIndex){
        int index = startIndex;

        //Startindex + 1 to ensure that it dont compare to itself on first loop.
        for(int i = startIndex + 1; i < dog.size(); i++){
            //If comparsion gives -1
            if(comparator.compare(dog.get(i), dog.get(index)) < 0){
                //Index i is next dog
                index = i;
            }
        }
        return index;
    }
}