package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.EventReporter;
import si.um.opj.piwowarski.logic.FoodItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DeleteFoodItemListener implements ActionListener {

    private JList<FoodItem> foodItemJList;
    private ArrayList<FoodItem> foodItemArrayList;

    public DeleteFoodItemListener(JList<FoodItem> foodItemJList, ArrayList<FoodItem> foodItemArrayList)
    {
        this.foodItemJList = foodItemJList;
        this.foodItemArrayList = foodItemArrayList;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultListModel<FoodItem> model = (DefaultListModel<FoodItem>) foodItemJList.getModel();

        if(foodItemJList.getSelectedIndex() >= 0)
        {
            try
            {
                int index = foodItemJList.getSelectedIndex();
                model.remove(index);
                foodItemArrayList.remove(index);
                EventReporter reporter = new EventReporter();
                reporter.addToReport("Deleted food item");
            }
            catch(Exception e)
            {
                EventReporter reporter = new EventReporter();
                reporter.addToReport(e);
            }
        }
        foodItemJList.setSelectedIndex(-1);
    }
}
