import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Inventory {
    Scanner reader;
    File file;
    FileWriter writer;

    public Inventory(File file) {
        this.file = file;
    }

    public Boolean addTextbook(String SKU, String title, String price, String quantity) {
        try {
            reader = new Scanner(file);
            while(reader.hasNextLine()){
                String[] line = reader.nextLine().split("\t");
                if(line[0].equals(SKU)) {
                    return false;
                }
            }
            writer = new FileWriter(file, true);
            writer.write(SKU + "\t" + title + "\t" + price + "\t" + quantity + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {e.printStackTrace();}
        return true;
    }

    public Boolean removeTextbook(String SKU) {
        File tempFile = new File("temp.txt");
        Boolean found = false;
        try {
            reader = new Scanner(file);
            writer = new FileWriter(tempFile);
            while(reader.hasNextLine()) {
                String[] line = reader.nextLine().split("\t");
                if(line[0].equals(SKU)) {
                    found = true;
                } else if(line[0].length() == 0) {  } else { 
                    writer.write(line[0] + "\t" + line[1] + "\t" + line[2] + "\t" + line[3] + "\n");
                    writer.flush();
                }
            }
            writer.flush();
            writer.close();
            file.delete();
            tempFile.renameTo(file);

        } catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
        return found;
    }

    public String[] getTextDetails(String SKU) {
        String line[] = null;
        try {
            reader = new Scanner(file);
            while(reader.hasNextLine()) {
                line = reader.nextLine().split("\t");
                if(line[0].equals(SKU)) {
                    System.out.println("Match found");
                    return line;
                } else { line = null; }
            }
        } catch (FileNotFoundException e) { e.printStackTrace(); }
        reader.close();
        return line; 
    }
}
