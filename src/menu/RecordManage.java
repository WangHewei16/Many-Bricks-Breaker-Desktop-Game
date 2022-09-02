package menu;

import java.io.*;
//write the record of top 10 into the menu
public class RecordManage {

    public Record record;
    final String jiluPath = System.getProperty("user.dir") + "\\jilu.ser";

    public boolean isjinru10(int fenshu) {

        return record.isjinru10(fenshu);
    }


    public void writeObj() {

        File file = new File(jiluPath);
        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(jiluPath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(record);
            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }


    public void readObj() {
        File file = new File(jiluPath);
        if (file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(jiluPath);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                record = (Record) in.readObject();
                in.close();
                fileIn.close();
            } catch (IOException | ClassNotFoundException i) {
                i.printStackTrace();
            }

        } else {
            record = new Record();

        }


    }

}
