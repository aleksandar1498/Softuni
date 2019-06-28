package pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {

        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);

    }

    private void setFlourType(String flourType) {
        try {
         FlourType.valueOf(flourType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType=flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
          BakingTechnique.valueOf(bakingTechnique);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique=bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    public double calculateCalories(){
        return (this.weight*2)*(BakingTechnique.valueOf(this.bakingTechnique).getCalories()*FlourType.valueOf(this.flourType).getCalories());
    }
}
