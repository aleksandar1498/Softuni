package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
	private List<Pet> data;
	private int capacity;
	public Clinic(int capacity) {
		this.capacity = capacity;
		this.data = new ArrayList<Pet>();
	}
	
	public void add(Pet pet) {
		if(this.getData().size()+1 <= this.getCapacity()) {
			this.data.add(pet);
		}
	}
	
	public boolean remove(String name) {
		for(int i = 0;i < data.size();i++) {
			if(this.data.get(i).getName().equals(name)) {
				this.data.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Pet getPet(String name,String owner) {
		return this.data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner)).findFirst().orElse(null);
	}
	
	public Pet getOldestPet() {
		return this.data.stream().sorted((a,b) -> {
			return b.getAge() - a.getAge();
		}).findFirst().orElse(null);
	}
	
	public int getCount() {
		return this.data.size();
	}
	public List<Pet> getData() {
		return data;
	}

	public void setData(List<Pet> data) {
		this.data = data;
	}
	
	public String getStatistics() {
		StringBuilder builder = new StringBuilder("The clinic has the following patients:");
		this.data.forEach(p -> {
			builder.append(System.lineSeparator());
			builder.append(String.format("%s %s", p.getName(),p.getOwner()));
		});
		return builder.toString();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
