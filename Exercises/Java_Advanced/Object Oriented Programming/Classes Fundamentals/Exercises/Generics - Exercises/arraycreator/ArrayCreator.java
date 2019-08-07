package arraycreator;
import java.lang.reflect.Array;
class ArrayCreator<T>{
    private final Class<T> type;

     public ArrayCreator(Class<T> type) {
          this.type = type;
     }

    public  <T> T[] create(int length,T item){
        T[] array= (T[]) Array.newInstance(this.type,length);
        for(int i=0;i<array.length;i++){
            array[i]=item;
        }
        return array;
    }
    public <T> T[] create(Class<T> c,int length,T item){
        T[] array= (T[]) Array.newInstance(c,length);
        for(int i=0;i<array.length;i++){
            array[i]=item;
        }
        return array;
    }
}