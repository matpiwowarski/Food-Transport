package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.EventReporter;
import si.um.opj.piwowarski.logic.facility.BusinessFacility;
import si.um.opj.piwowarski.logic.transport.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteVehicleListener implements ActionListener {

    private JList<Vehicle> vehicleJListJList;
    private ArrayList<Vehicle> vehicleArrayList;

    public DeleteVehicleListener(JList<Vehicle> vehicleJListJList, ArrayList<Vehicle> vehicleArrayList)
    {
        this.vehicleJListJList = vehicleJListJList;
        this.vehicleArrayList = vehicleArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultListModel<Vehicle> model = (DefaultListModel<Vehicle>) vehicleJListJList.getModel();

        if(vehicleJListJList.getSelectedIndex() >= 0)
        {
            try
            {
                int index = vehicleJListJList.getSelectedIndex();
                model.remove(index);
                vehicleArrayList.remove(index);
                EventReporter reporter = new EventReporter();
                reporter.addToReport("Deleted vehicle");
            }
            catch (Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }
        }
        vehicleJListJList.setSelectedIndex(-1);
    }
}
