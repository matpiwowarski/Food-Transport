package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.FoodItem;
import si.um.opj.piwowarski.logic.facility.BusinessFacility;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteBusinessFacilityListener implements ActionListener {

    private JList<BusinessFacility> businessFacilityJList;
    private ArrayList<BusinessFacility> businessFacilityArrayList;

    public DeleteBusinessFacilityListener(JList<BusinessFacility> businessFacilityJList, ArrayList<BusinessFacility> businessFacilityArrayList)
    {
        this.businessFacilityJList = businessFacilityJList;
        this.businessFacilityArrayList = businessFacilityArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultListModel<BusinessFacility> model = (DefaultListModel<BusinessFacility>) businessFacilityJList.getModel();

        if(businessFacilityJList.getSelectedIndex() >= 0)
        {
            int index = businessFacilityJList.getSelectedIndex();
            model.remove(index);
            businessFacilityArrayList.remove(index);
        }
        businessFacilityJList.setSelectedIndex(-1);
    }

}
