import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Path dirPath = Paths.get("C:/JavaProgramming/gameData");
        Path usersfilePath = Paths.get("Highscores.txt");
        Path settingsfilePath = Paths.get("Settings.txt");
        Path users, settings;
        users = checkFiles(dirPath, usersfilePath);
        settings = checkFiles(dirPath, settingsfilePath);
        if (usersfilePath != null){
            displayFileStatus(users,settings);
        }
//        deleteFile(settings);
//        deleteFile(users);
    }//end of main method

    static Path checkFiles(Path dirPath, Path filePath){
        Path absPath = dirPath.resolve(filePath);
        try {
            if (Files.notExists(dirPath))
                Files.createDirectories(dirPath);
            //end of 1st if
            if (Files.notExists(absPath))
                Files.createFile(absPath);
            //end of 2nd if
        }//end try
        catch (IOException x){
            System.err.println(x);
            return null;
        }//end of catch
        return absPath;
    }//end of checkfiles

    static void displayFileStatus(Path users, Path settings) throws IOException{
        System.out.println("Readable : " + Files.isReadable(users));
        System.out.println("Writeable : " + Files.isWritable(users));
        System.out.println("Executable : " + Files.isExecutable(users));
        System.out.println("Hidden : " + Files.isHidden(users));
        System.out.println("Same files : " + Files.isSameFile(users, settings));
    }// end of DFS


    static void deleteFile (Path filepath){
        try {
            if (Files.exists(filepath)){
                Files.delete(filepath);
                System.out.println(filepath.toString() + " deleted!");
            }
            else {
                System.out.println(filepath.toString() + " not found!");
            }
        }
        catch (DirectoryNotEmptyException e){
            System.out.println("The directory is not empty");
        }
        catch (IOException x){
            System.err.println(x);
        }

    }
}// end of Files Demo class
