class Pokemon{
    String name;
    String element;
    int health;
    public Pokemon(String name,String element,int health){
        this.name=name;
        this.element=element;
        this.health=health;
    }
    public String getElement(){
        return this.element;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health=health;
    }
    public boolean survivedAttack(){
        if(this.getHealth()-10 > 0){
            this.setHealth(this.getHealth()-10);
            return true;
        }
        return false;
    }
}