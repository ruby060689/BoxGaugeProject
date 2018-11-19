package com.box.steps;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

public class GaugeTestSteps {
    @Step("Say <hello> to <Gauge>")
    public void implementation1(String val1, String val2) {
        System.out.println(val1 + " " + val2);
    }

    @Step("Step that takes a table <table>")
    public void tableStep(Table table) {
        for (TableRow row : table.getTableRows()) {
            System.out.println(row.getCell("Product") + "      " + row.getCell("Description"));
        }
    }


}
