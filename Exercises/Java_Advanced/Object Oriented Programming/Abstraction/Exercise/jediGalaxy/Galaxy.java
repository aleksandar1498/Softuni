package jediGalaxy;

public class Galaxy {
    private Star[][] galaxy;

    public Galaxy(int row, int col) {
        this.galaxy = new Star[row][col];
        initiateGalaxy();
    }

    public void printGalaxy() {
        for (int row = 0; row < galaxy.length; row++) {
            for (int col = 0; col < galaxy[row].length; col++) {
                System.out.print(galaxy[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void initiateGalaxy() {
        int val = 0;
        for (int row = 0; row < galaxy.length; row++) {
            for (int col = 0; col < galaxy[row].length; col++) {
                this.galaxy[row][col] = new Star(val++);
            }
        }
    }

    public long collectStars(Galaxy galaxy, int ivoX, int ivoY) {
        long result = 0;
        while (ivoX >= 0 && ivoY < this.galaxy[1].length) {
            if (ivoX < this.galaxy.length && ivoY >= 0 && ivoY < this.galaxy[0].length && isInRange(ivoX,ivoY)) {
                result += this.galaxy[ivoX][ivoY].val;
            }

            ivoY++;
            ivoX--;
        }
        return result;
    }
    public  void destroy(int evilX,int evilY){
        while (evilX >= 0 && evilY >= 0) {
            if ( evilX < galaxy.length && evilY < galaxy[0].length && isInRange(evilX,evilY)) {
                galaxy[evilX][evilY].setVal(0);
            }
            evilX--;
            evilY--;
        }
    }

    private boolean isInRange(int row, int col) {
        return (row >= 0 && row < this.galaxy.length) && (col >= 0 && col < this.galaxy[row].length);
    }
}
