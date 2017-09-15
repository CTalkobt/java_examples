/*
 * Copyright (C) 2017 Craig Taylor <ctalkobt@ctalkobt.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
**/
package net.ctalkobt.example.java.lambda.readingstacktraces.newpackage.util;

public class AnnotatedStackTraceElement {

    StackTraceElement ste;
    String message;

    /**
     *
     * @param ste2
     */
    public AnnotatedStackTraceElement(StackTraceElement ste2) {
        ste = ste2;
    }

    /**
     *
     * @return
     */
    public StackTraceElement getSte() {
        return ste;
    }

    /**
     *
     * @param msg
     */
    public void setMsg(String msg) {
        message = msg;
    }

    /**
     *
     * @return
     */
    public String getMsg() {
        return message;
    }
    
    public String toString() { 
        return ste.getClassName()+ " # " + ste.getMethodName() + " @ " + ste.getLineNumber() + 
                ((null == message) ? "" :  " <-- " + message);
    }
}
