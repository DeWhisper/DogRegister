//Erik blomkvist erbl4920

import java.util.ArrayList;

public class Owner implements Comparable<Owner>
{
    private String name;
    private ArrayList<Dog> dogs;

    /*
     *  Constructs a new Owner with the Owner name
     */
    public Owner(String name){
        this.name = name.toUpperCase();
        this.dogs = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    @Override
    public int compareTo(Owner secondOwner) {
        return this.name.compareToIgnoreCase(secondOwner.getName());
    }
    /*
     * Adds dog to Owner's dog arraylist if the dog lacks owner.
     * @param dog, The dog to be added
     * @return True if dog is added, false otherwise.
     */

    public boolean addDog(Dog dog){
        if(dog != null && !dogs.contains(dog) && dog.getOwner() == null){   //Checks if dog already is in list and has no owner
            dogs.add(dog);
            dog.setOwner(this);
            return true;
            }
        return false;
        }
    /*
     * Removes dog from Owner's dog arraylist if dog exist in array.
     * @param dog, The dog to be removed
     * @return True if dog is removed, false otherwise.
     */
    public boolean removeDog(Dog dog){

        if (dog != null && dogs.contains(dog)) {   //If the dog is owned by this owner
            dogs.remove(dog);
            dog.setOwner(null);
            return true;
        }
        return false;
    }
    /* 
     * Return the sorted dog arraylist based on their name.
     * @return A sorted list of the Owner's dogs.
    */
    public ArrayList<Dog> getDogs(){
        return new ArrayList<>(dogs);
    }
    /*
     * Return a string repesentation of the Owners name,
     * and all the dogs that the owner might own.
     */
    public String toString()
    {
        if(dogs.isEmpty()){
            return name;
        }
        else{
            StringBuilder dogNames = new StringBuilder();
            // Appends each dog that the owner owns, and a space to separate.
            for (Dog dog : dogs) {
                dogNames.append(dog.getName()).append(" ");
            }
            // Delets trailing space that follows the last dog.
            dogNames.delete(dogNames.length() - 1, dogNames.length());
            return String.format("%s %s", name, dogNames);
        }
    }
}