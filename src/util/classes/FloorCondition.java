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
class FloorCondition {
    String name1;
    String condition;
    String name2;
    ArrayList<Integer> notAllowed;
    
    public FloorCondition(String name1, String condition, String second) {
        this.name1 = name1;
        this.condition = condition;
        if (condition.contains("NOT ON FLOOR")){
            secondToFloors(second);
        }
        else {
            name2 = second;
        }
    }

    public void secondToFloors(String second) {
        notAllowed = new ArrayList();
        notAllowed.add(Integer.parseInt(second.substring(0,1))-1);
        if(second.length() > 1){
            notAllowed.add(Integer.parseInt(second.substring(second.length()-1))-1);
        }
    }

    public boolean meetsCondition(ArrayList<String> people) {
        boolean met = false;
        int indexP1 = people.indexOf(name1);
        if(condition.contains("NOT ON FLOOR")){
            boolean onFloor = false;
            for (int i = 0; i < notAllowed.size(); i++) {
                if(indexP1 == notAllowed.get(i)){
                    onFloor = true;
                }
            }
            met = !onFloor;
        }else if(condition.equals("ON HIGHER FLOOR THAN")){
            int indexOfSecond = people.indexOf(name2);
            if(indexP1>indexOfSecond){
                met = true;
            }
        }else if(condition.equals("ON ADJACENT FLOOR TO")){
            int indexOfSecond = people.indexOf(name2);
            if(indexP1+1==indexOfSecond || indexP1-1 == indexOfSecond){
                met = true;
            }
        }else if(condition.equals("NOT ON ADJACENT FLOOR TO")){
            int indexOfSecond = people.indexOf(name2);
            if(indexP1+1==indexOfSecond || indexP1-1 == indexOfSecond){
                met = false;
            }else{
                met = true;
            }
        }
        //System.out.println(condition + ": " + met);
        return met;
    }
}
