package si.um.opj.piwowarski.logic;

import si.um.opj.piwowarski.logic.exception.CapacityExceededException;
import si.um.opj.piwowarski.logic.exception.FoodItemTypeException;
import si.um.opj.piwowarski.logic.exception.VolumeExceededException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventReporter {

    public void addToReport(Exception e)
    {
        try
        {
            FileWriter fileWriter = new FileWriter("info.txt", true);
            BufferedWriter bw = new BufferedWriter(fileWriter);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            bw.write("---\n");
            bw.write(now.toString());
            bw.write("\t" + e.getMessage());
            if(e instanceof CapacityExceededException)
            {
                bw.write("\n"+ ((CapacityExceededException) e).gravity + "\n");
                bw.write("\t" + ((CapacityExceededException)e).info);
            }
            else if(e instanceof FoodItemTypeException)
            {
                bw.write("\n"+ ((FoodItemTypeException) e).gravity + "\n");
                bw.write("\t" + ((FoodItemTypeException)e).info);
            }
            else if(e instanceof VolumeExceededException)
            {
                bw.write("\n"+ ((VolumeExceededException) e).gravity + "\n");
                bw.write("\t" + ((VolumeExceededException)e).info);
            }

            bw.write("\n---\n");
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addToReport(String info)
    {
        try
        {
            FileWriter fileWriter = new FileWriter("info.txt", true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            bw.write("---\n");
            bw.write(now.toString());
            bw.write("\t" + info);
            bw.write("\n---\n");
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
