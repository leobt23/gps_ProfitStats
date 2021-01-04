package logic;

import java.io.*;

public class FileUtility {

    static final String FILE = "./profitStatsData";

    public static void saveModelToFile(Object o)
    {
        ObjectOutputStream oos = null;
        try{
            File file = new File(FILE);
            boolean createdFile = file.createNewFile();
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(o);
        }
        catch (IOException e){
            System.exit(-1);
        }
        finally {
            if(oos != null) {
                try {
                    oos.close();
                } catch (IOException ignored) {

                }
            }
        }
    }

    public static Object retrieveModelFromFile()
    {
        ObjectInputStream ois = null;
        try{
            File file = new File(FILE);
            if (!file.exists()) {
                return null;
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.exit(-2);
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException ignored) {
                }
            }
        }
        return null;
    }
}
