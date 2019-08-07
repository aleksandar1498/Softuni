class Pokemon{
    String pokemonName;
    String pokemonType;
    public Pokemon(String pokemonName,String pokemonType){
        this.pokemonName=pokemonName;
        this.pokemonType=pokemonType;
    }
    public String getPokemonName(){
        return this.pokemonName;
    }
    public String getPokemonType(){
        return this.pokemonType;
    }
    @Override
    public boolean equals(Object p){
        
        if(p instanceof Pokemon){
            Pokemon current=(Pokemon) p;
            return this.getPokemonName().equals(current.getPokemonName());
        }
        
        return false;        
    }
     @Override
    public String toString(){
      
        return String.format("%s %s",this.getPokemonName(),this.getPokemonType());
    }
}