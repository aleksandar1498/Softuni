package softUniParking;
public class Car {
    String make;
    String model;
    int horsePower;
    String registrationNumber;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Car(String make, String model, int horsePower, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return
                "Make: " + this.getMake() + '\n' +
                "Model: " + this.getModel() + '\n' +
                "HorsePower: " + this.getHorsePower() +'\n'+
                "RegistrationNumber: " + this.getRegistrationNumber();
    }
}
