/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.classes;

import java.util.ArrayList;

/**
 *
 * @author S531749
 */
public class Condition {
    String name1;
    String condition;
    String name2;
    int position;

    public Condition(String name1, String condition, String second) {
        this.name1 = name1;
        this.condition = condition;
        if(condition.equalsIgnoreCase("BEAT")){
            this.name2 = second;
        }
        if (condition.equalsIgnoreCase("WAS")) {
            secondToPosition(second);
        }
    }

    public boolean secondToPosition(String second) {
        if (second.equalsIgnoreCase("FIRST")) {
            position = 1;
        } else if (second.equalsIgnoreCase("SECOND")) {
            position = 2;
        } else if (second.equalsIgnoreCase("THIRD")) {
            position = 3;
        } else if (second.equalsIgnoreCase("LAST")) {
            position = 4;
        }

        if (position > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean meetsCondition(ArrayList<String> people) {
        boolean met = false;

        if (condition.equalsIgnoreCase("BEAT")) {
            int index1 = people.indexOf(name1);
            int index2 = people.indexOf(name2);
            if (index1 < index2) {
                met = true;
            }
        } else if (condition.equalsIgnoreCase("WAS")) {
            int index = people.indexOf(name1);
            if (index == (position - 1)) {
                met = true;
            }
        }
        return met;
    }
}
