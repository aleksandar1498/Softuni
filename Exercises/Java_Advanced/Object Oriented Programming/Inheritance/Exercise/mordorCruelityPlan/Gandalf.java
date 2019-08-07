package mordorCruelityPlan;


public class Gandalf {

    private int foodPoints;

    public Gandalf() {
        foodPoints=0;
    }
    public void eatFood(String food){
        try{
            foodPoints+=Food.valueOf(food).getPointsOfHappiness();
        }catch (IllegalArgumentException e){
            foodPoints-=1;
        }
    }

    public int getFoodPoints() {
        return this.foodPoints;
    }
    public String getMood(){
        if(this.foodPoints < -5){
            return "Angry";
        }else if(this.foodPoints < 0){
            return "Sad";
        }else if(this.foodPoints < 15){
            return "Happy";
        }
        return "JavaScript";
    }
}
