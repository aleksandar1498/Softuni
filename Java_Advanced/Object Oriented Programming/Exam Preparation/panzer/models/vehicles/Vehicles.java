package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;

public abstract class Vehicles implements Vehicle {

    private String model;
    private double totalWeight;
    private BigDecimal totalPrice;
    private long totalAttack;
    private long totalDefense;
    private long totalHitPoints;
    private Assembler assembler;

     Vehicles(String model, double totalWeight, BigDecimal totalPrice, long totalAttack, long totalDefense, long totalHitPoints) {
        this.model = model;
        this.totalWeight = totalWeight;
        this.totalPrice = totalPrice;
        this.totalAttack = totalAttack;
        this.totalDefense = totalDefense;
        this.totalHitPoints = totalHitPoints;
        this.assembler = new VehicleAssembler();
    }

    @Override
    public double getTotalWeight() {
        return this.totalWeight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    @Override
    public long getTotalAttack() {
        return this.totalAttack;
    }

    @Override
    public long getTotalDefense() {
        return this.totalDefense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.totalHitPoints;
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return null;
    }

    @Override
    public String getModel() {
        return this.model;
    }
}
