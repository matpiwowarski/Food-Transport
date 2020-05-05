package si.um.opj.piwowarski.ui;

import si.um.opj.piwowarski.logic.FoodItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndependentFoodItemListener implements ActionListener {

    private JList<FoodItem> foodItemJList;

    public IndependentFoodItemListener(JList<FoodItem> foodItemJList)
    {
        this.foodItemJList = foodItemJList;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        DefaultListModel<FoodItem> model = (DefaultListModel<FoodItem>) foodItemJList.getModel();

        if(foodItemJList.getSelectedIndex() >= 0)
        {
            model.remove(foodItemJList.getSelectedIndex());
        }
    }
}
