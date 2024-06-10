//Erik Blomkvist erbl4920

public class Dog {
    
    // Constant default tail length for taxes
    private static final double DACHSHUND_TAIL_LENGTH = 3.7;

    private String name;
    private String breed;
    private int age;
    private int weight;
    private double tailLength;
    private Owner owner;

    /*
     * Constructs Dog with all the attributes that it needs.
     */
    public Dog(String name, String breed, int age, int weight)
    {
        this.name = name.toUpperCase();
        this.breed = breed.toUpperCase();
        this.age = age;
        this.weight = weight;
        calculateTailLength();
    }
    // Getters 
    public String getName()
    {
        return name;
    }
    public String getBreed()
    {
        return breed;
    }
    public int getAge()
    {
        return age;
    }
    public int getWeight()
    {
        return weight;
    }
    public double getTailLength()
    {
        return tailLength;
    }
    public Owner getOwner(){
        return owner;
    }
    /*
     * Calculates tail length based on the dogs breed, or weight and age.
     */
    private void calculateTailLength() 
    {
        if (!breed.equalsIgnoreCase("TAX") && !breed.equalsIgnoreCase("DACHSHUND")) {
            tailLength = age * (weight / 10.0);
        } else {
            tailLength = DACHSHUND_TAIL_LENGTH;
        } 
    }
    /*
     * Increase the dogs age, and updates the tail length.
     */
    public void increaseAge()
    {
        if(age < Integer.MAX_VALUE){
          age++;  
          calculateTailLength();
        }
    }
    /*
     * Sets the owner of the dog.
     * If the the new owner is null it instead removes the current owner.
     * If the dog has no owner it will set the newOwner as its owner.
     * @param newOwner The new owner for the dog
     * @return True if the owner is successfully set, false otherwise.
     */
    public boolean setOwner(Owner newOwner){
        if(newOwner == null){   //If new owner is null
            if(this.owner != null){ //If dog has a owner
                owner.removeDog(this);  //Remove dog
            }
            this.owner = null;  
            return true;
        } else if(this.owner == null){
                newOwner.addDog(this);
                this.owner = newOwner;
                return true;
            }
            return false;
        }
    /*
     * @return A formatted string with the dogs attributes.
     */
        public String toString(){
            if(owner == null){
                return String.format("%s %s %d %d %.1f", name, breed, age, weight, getTailLength());
            }
            else{
                return String.format("%s %s %d %d %.1f %s", name, breed, age, weight, getTailLength(), owner.getName());
            }
    }
}