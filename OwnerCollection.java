import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class OwnerCollection {

    //Erik Blomkvist erbl4920

    private Owner[] owners;
    
    public OwnerCollection() {
        owners = new Owner[0];
    }
    /*
     * Adds owner to the collection if owners names doesn't already exist.
     * @param owner The owner to be added
     * @True if the owner was added, false if name already exist in array.
     */
    public boolean addOwner(Owner owner){
        if(containsOwner(owner.getName()) || owner == null){
            return false;
        } else{
            owners = Arrays.copyOf(owners, owners.length + 1);
            owners[owners.length - 1] = owner;
            return true;
        }
    }
    /*
     * Removes an owner from the collection with its name.
     * @param name The name of the owner to be removed.
     * @return True if the owner was removed, false if owner cant be found.
     */
    public boolean removeOwner(String name){

        //Checks requirements and then gets Index for desired index.
        if(!containsOwner(name) || !getOwner(name).getDogs().isEmpty() || name == null){
            return false;
        } else{  
            //The code copies over the old values from the old array to the new array, only skipping the undesired value.
            Owner[] ownerCopy = new Owner[owners.length - 1];
            for(int i = 0, counter = 0; i < owners.length; i++){
                //If 'i' is not equal to the owner index, we add it to the new array.
                if(!owners[i].getName().equalsIgnoreCase(name)){
                    ownerCopy[counter++] = owners[i];
                }
            }
            //sets the old array to the new array.
            owners = ownerCopy;
            return true;
        }
    }
    // Removes owner from the collection.
    public boolean removeOwner(Owner owner){
        if(!owner.getDogs().isEmpty() || owner == null){
            return false;
        }
        return removeOwner(owner.getName());
    }
    /*
     * Check if owner is in collection with its name.
     * @param name The name of the owner.
     * @return True if owner is in collection, false otherwise.
     */
    public boolean containsOwner(String name){
        for(Owner owner : owners){
            if(owner.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    // Checks if owner is in collection.
    public boolean containsOwner(Owner owner){
        if(owner == null){
            return false;
        }
        return containsOwner(owner.getName());
    }
    /*
     * Gets a specified owner with its name
     * @param name The owners name.
     * @return Owner The owner with the name, null if owner was not found.
     */
    public Owner getOwner(String name){
        if(containsOwner(name)){
            for (Owner owner : owners) {
                if(owner.getName().equalsIgnoreCase(name)){
                    return owner;
                }
            }
        }
        return null;
    }
    /*
     * @return Gets a arraylist of all the owners in the collection.
     */
    public ArrayList<Owner> getOwners(){
        ArrayList<Owner> ownerList = new ArrayList<>(Arrays.asList(owners));
        ownerList.sort(Comparator.naturalOrder());
        return ownerList;
    }
}