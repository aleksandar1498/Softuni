package arena;

public class Weapon {
    int size;
    int solidity;
    int sharpness;

    public Weapon(int size, int solidity, int sharpness) {
        this.size = size;
        this.solidity = solidity;
        this.sharpness = sharpness;
    }

    public int getSize() {
        return size;
    }

    public int getSolidity() {
        return solidity;
    }

    public int getSharpness() {
        return sharpness;
    }
}
