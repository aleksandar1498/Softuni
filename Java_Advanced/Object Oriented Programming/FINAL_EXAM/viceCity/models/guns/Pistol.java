package viceCity.models.guns;

public class Pistol extends BaseGun {
    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public boolean canFire() {
        // check if the current bullets are enough
        if(super.currentBullets-1 >= 0){
            return true;
        }else return super.reload();
    }

    @Override
    public int fire() {
        //TODO CHECK
        int shotsBullets = 0;
        if (this.canFire()) {
            super.currentBullets--;
            shotsBullets = 1;
        }
        return shotsBullets;
    }
}
