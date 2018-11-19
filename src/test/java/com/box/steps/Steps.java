package com.box.steps;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

public class Steps {
    @Step("Say1 <greeting> to <product name>")
    public void helloWorld(String greeting, String name) {
        System.out.println(greeting + ", " + name);
    }

    @Step("Step1 that takes a table <table>")
    public void stepWithTable(Table table) {
        for (TableRow rows : table.getTableRows()) {
            Gauge.writeMessage(rows.toString());
        }
    }

    @Step("A context step which gets executed before every scenario")
    public void contextStep() {
    }
}

