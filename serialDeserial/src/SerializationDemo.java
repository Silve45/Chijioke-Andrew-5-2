import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializationDemo {
    public static void main(String[] args) {
        Course course = new Course("Java Programming",
                "Oracle", "JP", 60);

        Path path = Paths.get("C:/JavaProgramming/details.ser");
        serializeData(course, path);
        Course savedCourse = deSerializeData(path);
        if (course != null){
            displayData(savedCourse);
        }
    }// end main

    static void serializeData(Course course, Path path){
        try(FileOutputStream fileOut = new FileOutputStream(path.toString());
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) { // this tries to write to a file
            objOut.writeObject(course);
            System.out.println("Serialized data is saved in " + path.toString());
        }
        catch (IOException e){
            e.printStackTrace();
        }// end catch
    }//end method serialData

    static Course deSerializeData(Path path){
        try(FileInputStream fileIn = new FileInputStream(path.toString());
            ObjectInputStream objIN = new ObjectInputStream(fileIn))  {// tries to read the file
            Course course = (Course) objIN.readObject();
            return course;
        }//end try
        catch (ClassNotFoundException e){
            System.out.println("course class not found");
            return null;
        }//end class
        catch (IOException i ){
            i.printStackTrace();
            return null;
        }
    }// end deserialize data

    public static void displayData(Course course){
        System.out.println("Deserialized Course Details...");
        System.out.println(course);
//        System.out.println("Name    :" + course.getName());
//        System.out.println("Type    :" + course.getType());
//        System.out.println("Code    :" + course.getCourseCode());
//        System.out.println("Pass Score    :" + course.getPassingScore());


    }// end displayData

}
