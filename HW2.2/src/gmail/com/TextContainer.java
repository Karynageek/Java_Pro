package gmail.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
@interface SaveTo {
    String path();
}
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface Saver {
}

@SaveTo(path="C:\\Users\\Karina\\Desktop\\Courses\\file.txt")
public class TextContainer {
    private static final String text = "Hello, World!";
    @Saver
    public void save(String path) {
        try(PrintWriter pw = new PrintWriter(new File(path))) {
            pw.write(text);
            System.out.println("Done!");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
