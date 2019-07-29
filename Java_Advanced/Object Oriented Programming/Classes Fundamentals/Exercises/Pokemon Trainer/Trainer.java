import java.util.*;

class Trainer {
    String name;
    int badges=0;
    List<Pokemon> pokemons;
    public Trainer(String name){
       this.name=name;
       this.pokemons=new ArrayList<>();
    }
    public List<Pokemon> getPokemons(){
        return this.pokemons;
    }
    public void addBadge(){
        this.badges++;
    }
    public int getBadges(){
        return this.badges;
    }
    public void trainPokemons(String element){
        if(this.getPokemons().stream().filter(p -> p.getElement().equals(element)).count() > 0){
            this.addBadge();
        }else{
            for(int i=0;i<pokemons.size();i++){
                if(!pokemons.get(i).survivedAttack()){
                    pokemons.remove(i);
                    i--;
                }
            }
        }
    }
    @Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Trainer))
			return false;	
		if (obj == this)
			return true;
		return this.name.equals(((Trainer) obj).name);
	}
	@Override
	public int hashCode(){
		return name.length();//for simplicity reason
	}

    
}