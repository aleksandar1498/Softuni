package panzer.models.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Modelable;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class Vehicles implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private long attack;
    private long defense;
    private long hitPoints;
    private Assembler assembler;
    private Map<String,Part> parts;

    public Vehicles(String model, double weight, BigDecimal price, long attack, long defense, long hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.assembler = new VehicleAssembler();
        this.parts = new LinkedHashMap<>();
    }

    @Override
    public double getTotalWeight() {
        return this.weight+this.assembler.getTotalWeight();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price.add(this.assembler.getTotalPrice());
    }

    @Override
    public long getTotalAttack() {
        return this.attack+this.assembler.getTotalAttackModification();
    }

    @Override
    public long getTotalDefense() {
        return this.defense+this.assembler.getTotalDefenseModification();
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints+this.assembler.getTotalHitPointModification();
    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.parts.put(arsenalPart.getModel(),arsenalPart);
         this.assembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.parts.put(shellPart.getModel(),shellPart);
        this.assembler.addShellPart(shellPart);
    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.parts.put(endurancePart.getModel(),endurancePart);
        this.assembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() {
        return this.parts.values();
    }

    @Override
    public String getModel() {
        return this.model;
    }
    @Override
    public String toString() {

        List<Part> partsToArray = StreamSupport.stream(this.getParts().spliterator(),false).collect(Collectors.toList());

        return String.format("%s - %s", this.getClass().getSimpleName(), this.getModel()) +
                System.lineSeparator() +
                String.format("Total Weight: %.3f", this.getTotalWeight()) +
                System.lineSeparator() +
                String.format("Total Price: %.3f", this.getTotalPrice()) +
                System.lineSeparator() +
                String.format("Attack: %d", this.getTotalAttack()) +
                System.lineSeparator() +
                String.format("Defense: %d", this.getTotalDefense()) +
                System.lineSeparator() +
                String.format("HitPoints: %d", this.getTotalHitPoints()) +
                System.lineSeparator() +
                String.format("Parts: %s", (parts.size() > 0) ? parts.values().stream().map(Modelable::getModel).collect(Collectors.toList()).toString().replaceAll("[\\[\\]]", "") : "None");
    }
}
