
package Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadWriteProduct {

    public ReadWriteProduct() {
    }
    public void writeFile(String fileName, Object obj){
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Object readFile(String fileName){
        Object result = null;
        try {
           FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                result = ois.readObject();
            }
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadWriteProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
