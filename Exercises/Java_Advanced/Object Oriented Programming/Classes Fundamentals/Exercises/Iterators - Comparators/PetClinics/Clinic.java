package iteratorsandcomparators.petclinics;


import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Clinic implements Iterable<Room>,Comparable<Clinic>{
    String name;
    List<Room> rooms;

    public Clinic(String name) {
        this.name = name;
    }

    public Clinic(String name, int size) {
        this(name);
        if (size % 2 != 0) {
            // I am creating a list of defined size and all rooms
            rooms = Stream.generate(Room::new)
                    .limit(size)
                    .collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Invalid Operation!");
        }
    }

    public boolean add(Pet p) {
        Iterator<Room> iterator = new ClinicAddIterator();
        boolean added = false;
        while (iterator.hasNext()) {
            if (iterator.next().setPet(p)) {
                added = true;
                break;
            }
        }
        return added;
    }

    public boolean release() {
        Iterator<Room> iterator = new ClinicReleaseIterator();

        boolean released = false;
        while (iterator.hasNext()) {
            Room next = iterator.next();
            if (!next.isFree()) {
                next.setFree(true);
                released = true;
                break;
            }

        }
        return released;
    }

    public boolean hasEmptyRooms() {
        for (Room r : rooms) {
            if (r.isFree()) {
                return true;
            }

        }
        return false;
    }

    public Room get(int index) {
        if (index >= 0 && index < rooms.size()) {
            return rooms.get(index);
        }
        return null;
    }




    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Clinic) obj).name);

    }

    @Override
    public int compareTo(Clinic o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public Iterator<Room> iterator() {
        return new Iterator<Room>() {
            int counter=0;
            @Override
            public boolean hasNext() {
                return counter < rooms.size();
            }

            @Override
            public Room next() {
                return rooms.get(counter++);
            }
        };
    }


    private final class ClinicReleaseIterator implements Iterator<Room> {
            int counter;
            int center;
            int index=0;

            public ClinicReleaseIterator() {
                this.counter=0;
                this.index = this.center = (int) (Math.floor(rooms.size() / 2.0))-1;


            }

            @Override
            public boolean hasNext() {
                return counter < rooms.size();
            }

            @Override
            public Room next() {
                counter++;
                if(index+1 < rooms.size()){
                    index++;
                }else{
                    index=0;
                }
                return rooms.get(index);
            }
        }

    private final class ClinicAddIterator implements Iterator<Room> {
        int counter;
        int center;
        boolean firstIter;
        boolean toLeft;

        public ClinicAddIterator() {

            this.counter = this.center = (int) (Math.floor(rooms.size() / 2.0));
            toLeft = true;
            firstIter = true;
        }

        @Override
        public boolean hasNext() {
            if(rooms.size() == 1 && counter == 0){
                return true;
            }else if(counter == -1){
                return false;
            }
            return counter != rooms.size() - 1;
        }

        @Override
        public Room next() {

            if (toLeft) {
                if (this.counter == this.center) {
                    if (firstIter) {
                        firstIter = false;
                        if(rooms.size() == 1){

                            counter=-1;
                            return rooms.get(center);
                        }else{
                            return rooms.get(counter);
                        }

                    } else {
                        this.counter--;
                    }

                } else {
                    counter -= Math.abs(this.counter - this.center) * 2 + 1;
                }

                toLeft = false;
            } else {
                counter += Math.abs(this.counter - this.center) * 2;
                toLeft = true;
            }
            return rooms.get(counter);
        }
    }
}
