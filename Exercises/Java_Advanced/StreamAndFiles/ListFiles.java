package lineardatastructure.streamfilesdirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class ListFiles {
    public static void main(String[] args) {
        File root=new File("C:\\Users\\aleks\\Downloads\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        Deque<File> paths=new ArrayDeque<>();
        paths.offer(root);
        int count=1;
        while(!paths.isEmpty()){
            File current=paths.poll();
            File [] nested=current.listFiles();
            for(File f:nested){
                if(f.isDirectory()){

                    paths.offer(f);
                    count++;
                }
            }

            System.out.println(current.getName());
        }
        System.out.println(count+" folders");
    }
}
