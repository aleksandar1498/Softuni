import java.util.*;

class Person{
    Company company=null;
    Car car=null;
    String name;
    List<Person> children;
    List<Person> parents;
    List<Pokemon> pokemons;
    String birthday;
    
    public Person(){
        children=new ArrayList<>();
        parents=new ArrayList<>();
        pokemons=new ArrayList<>();
    }
    public Person(String name,String birthday){
        this();
        this.name=name;
        this.birthday=birthday;
    }
    public String getName(){
        return this.name;
    }
    public String getBirthday(){
        return this.birthday;
    }
    public void setCompany(Company company){
        this.company=company;
    }
    public void setCar(Car car){
        this.car=car;
    }
    public void addChildren(Person p){
        if(children.contains(p)){
            children.set(children.indexOf(p),p);
        }else{
            children.add(p);
        }
    }
    public List<Person> getChildren(){
        return this.children;
    }
    public void addParent(Person p){
        if(parents.contains(p)){
            parents.set(parents.indexOf(p),p);
        }else{
            parents.add(p);
        }
    }
    
    public List<Person> getParents(){
        return this.parents;
    }
    
    public void addPokemon(Pokemon p){
        if(pokemons.contains(p)){
            pokemons.set(pokemons.indexOf(p),p);
        }else{
            pokemons.add(p);
        }
    }
    
    public List<Pokemon> getPokemons(){
        return this.pokemons;
    }
     
    public void printDetails(){
        System.out.print("Company:"+((company != null)?company.toString():"\n")+""); 
        System.out.print("Car:"+((car != null)?car.toString():"\n")+"");
        System.out.println("Pokemon:");
        this.getPokemons().forEach(x -> System.out.println(x.toString()));
        System.out.println("Parents:");
        this.getParents().forEach(x -> System.out.println(x.toString()));
        System.out.println("Children:");
        this.getChildren().forEach(x -> System.out.println(x.toString()));
    }
    @Override
    public boolean equals(Object p){
        
        if(p instanceof Person){
            Person current=(Person) p;
            return this.getName().equals(current.getName());
        }
        
        return false;        
    }
    @Override
    public String toString(){
        return String.format("%s %s",this.getName(),this.getBirthday());
    }
}