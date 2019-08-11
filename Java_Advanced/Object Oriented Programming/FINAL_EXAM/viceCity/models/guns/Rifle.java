package viceCity.models.guns;

public class Rifle extends BaseGun {
    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public boolean canFire() {
        // check if the current bullets are enough
        if(super.currentBullets-50 >= 0){
            return true;
        }else return super.reload();
    }

    @Override
    public int fire() {
        //TODO CHECK
        int shotsBullets = 0;
        if (this.canFire()) {
            super.currentBullets-=50;
            shotsBullets = 50;
        }
        return shotsBullets;
    }
}
