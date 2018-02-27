/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;

/**
 *
 * @author S542046
 */
public class NodeStuff {

    
    
    class Node {

        char name;
        ArrayList<Node> siblings = new ArrayList<>();

        public Node(char name) {
            this.name = name;
        }

        //must be added to both sibling sets, unless a unidirectional path

        public void addC(Node n) {
            siblings.add(n);
        }

        public int distTo(char n, ArrayList<Character> bl) {
            if (name == n) {
                return 0;
            }
            bl.add(name);
            int min = Integer.MAX_VALUE - 4;
            for (Node nod : siblings) {
                //System.out.println(bl.contains(nod.name));
                if (!bl.contains(nod.name)) {
                    int cur = nod.distTo(n, (ArrayList<Character>) bl.clone());
                    if (cur < min) {
                        min = cur;
                    }
                }

            }
            min++;
            //System.out.println(name + "'s closest dist to " + n + " is " + min);
            return min;

        }

        @Override
        public String toString() {
            String ans = name + ": ";
            for (Node n : siblings) {
                ans += " " + n.name;
            }
            return ans;
        }
    }

}
