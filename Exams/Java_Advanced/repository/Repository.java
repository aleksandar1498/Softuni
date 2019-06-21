package repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    int idPerson=0;
    Map<Integer,Person> data;

    public Repository() {
        this.data=new LinkedHashMap<>();
    }
    public void add(Person person){
        this.data.putIfAbsent(idPerson++,person);
    }
    public Person get(int id){
        if(this.data.containsKey(id)){
            return data.get(id);
        }
        return null;
    }
    public boolean update(int id,Person newPerson){
        if(this.data.containsKey(id)){
            this.data.put(id,newPerson);
            return true;
        }
        return false;
    }
    public boolean delete(int id){
        Person person=this.data.remove(id);
        if(person == null){
            return false;
        }
        return true;
    }
    public int getCount(){
        return this.data.size();
    }

    public int getIdPerson() {
        return idPerson;
    }

    public Map<Integer, Person> getData() {
        return data;
    }
}
