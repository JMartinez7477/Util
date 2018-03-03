/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author S542046
 */
public class DateStuff {

    class Date extends GregorianCalendar  {

        public Date(int y, int m, int d) {
            super(y, m - 1, d);
        }

        public int getDayOfWeek() {
            return super.get(GregorianCalendar.DAY_OF_WEEK);
        }

        @Override
        public String toString() {
            return super.getDisplayName(GregorianCalendar.DAY_OF_WEEK, 2, Locale.ENGLISH) + ", "
                    + super.getDisplayName(GregorianCalendar.MONTH, 2, Locale.ENGLISH) + " "
                    + super.get(GregorianCalendar.DAY_OF_MONTH) + ", "
                    + super.get(GregorianCalendar.YEAR);
        }

    }

}
