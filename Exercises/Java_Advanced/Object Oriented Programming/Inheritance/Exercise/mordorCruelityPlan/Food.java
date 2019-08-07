package mordorCruelityPlan;

public enum Food {
    cram(2),
    lembas(3),
    apple(1),
    melon(1),
    honeycake(5),
    mushrooms(-10);
    private int pointsOfHappiness;

    Food(int pointsOfHappiness) {
        this.pointsOfHappiness = pointsOfHappiness;
    }

    public int getPointsOfHappiness() {
        return pointsOfHappiness;
    }
}
