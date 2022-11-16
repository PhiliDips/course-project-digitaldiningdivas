package Frameworks_and_Drivers;
import APP_Business_Rules.DataAccessStorageInterface;

import java.io.*;

public class DataAccessStorage implements DataAccessStorageInterface {
    /**
     * Class for accessing data from a file.
     * @param fileName
     * @return
     */

    @Override
    public Object accessData(String fileName){
        /**
         * The method for accessing data. Returns an object from a given file.
         */

        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            Object fileData = in.readObject();

            in.close();
            file.close();

            return fileData;
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void storeData(String fileName, Object inputData){
        /**
         * Stores a given object to a given file.
         */

        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(inputData);

            out.close();
            file.close();
        }
        catch (IOException ex){
            System.out.println("IOException is caught");
        }
    }

}
