package logic;

import java.io.*;

public class FileUtility {

    static final String FILE = "./profitStatsData";

    public static void saveModelToFile(Object o) throws IOException
    {
        ObjectOutputStream oos = null;
        try{
            File file = new File(FILE);
            boolean createdFile = file.createNewFile();
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(o);
        }finally{
            if(oos != null)
                oos.close();
        }
    }

    public static Object retrieveModelFromFile() throws IOException, ClassNotFoundException
    {
        ObjectInputStream ois = null;
        try{
            File file = new File(FILE);
            if (!file.exists()) {
                return null;
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            return ois.readObject();

        }finally{
            if(ois != null)
                ois.close();
        }
    }
}
