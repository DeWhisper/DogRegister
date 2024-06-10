import java.util.ArrayList;


//Erik Blomkvist erbl4920

public class DogCollection {
    
    private ArrayList<Dog> dogs = new ArrayList<>();

    /*
     * Adds dog to collection arraylist aslong as the dog name doesn't
     * already exist in the collection arraylist.
     * @param dog The dog to be added.
     * @retrun True if the dog got added, false if the dog name already exist.
     */
    public boolean addDog(Dog dog){

        if(containsDog(dog) || dog == null){
            return false;
        }
        dogs.add(dog);
        return true;
    }
    /*
     * Removes a dog from the collection with its name.
     * @param name The name of the dog to be removed.
     * @return True if dog got removed, false if dog with the name wasn't found.
     */
    public boolean removeDog(String name){
        for (Dog dog : dogs) {
            if(dog.getName().equalsIgnoreCase(name)){
                return removeDog(dog);
            }
        }
        return false;
    } 
    // Removes dog from the collection.
    public boolean removeDog(Dog dog){
        if(dog != null && containsDog(dog) && dog.getOwner() == null){
            dogs.remove(dog);
            dog.setOwner(null);
            return true;
        }
        return false;
    }
    /*
     * Checks if dog is in collection based on its name.
     * @param name The name of the dog.
     * @return True if dog is in collection, false otherwise.
     */
    public boolean containsDog(String name){
        for(Dog dog : dogs){
            if(dog.getName().equalsIgnoreCase(name)){
                return true;
            }
        }

        return false;
    }
    // Checks if dog is in collection.
    public boolean containsDog(Dog dog){
        if(dog == null){
            return false;
        }
        return containsDog(dog.getName());
    }
    /*
     * Gets a specific dog from the collection.
     * @param name The name of the dog.
     * @return The dog with the name, else null if not found.
     */
    public Dog getDog(String name){
        for (Dog dog : dogs) {
            if(dog.getName().equalsIgnoreCase(name)){
                return dog;
            }
        }
        return null;
    }
    /*
     * Gets a sorted list of all the dogs in the collection.
     * @return A sorted list of all the dogs.
     */
    public ArrayList<Dog> getDogs(){
        ArrayList<Dog> sortedDogs = new ArrayList<>(dogs);
        DogSorter.sortDogs(new DogNameComparator(), sortedDogs);
        return sortedDogs;
    }
    /*
     * Gets filtered and sorted list of all the dogs based on tail length.
     * @param tailLength The minium tail length for filtering.
     * @return A filtered and sorted list of all the dogs.
     */
    public ArrayList<Dog> getDogsByTailLength(double tailLength){
        ArrayList<Dog> filteredDogs = new ArrayList<>(dogs);

        //lamda
        filteredDogs.removeIf(dog -> dog.getTailLength() < tailLength);

        DogSorter.sortDogs(new DogTailNameComparator(), filteredDogs);
        return filteredDogs;
    }
}