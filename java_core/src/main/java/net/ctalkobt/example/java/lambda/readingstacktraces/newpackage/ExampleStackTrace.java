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
package net.ctalkobt.example.java.lambda.readingstacktraces.newpackage;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import net.ctalkobt.example.java.lambda.readingstacktraces.newpackage.util.AnnotatedStackTraceElement;
import org.apache.log4j.Logger;

public class ExampleStackTrace {
    private static final Logger LOG = Logger.getLogger(ExampleStackTrace.class);

    // Key points:
    //   - Lambdas should be implemented with a seperation of principles. Simplicity is your friend.
    //
    //   - Catch exceptions that can be reasonably expected to be thrown and add a parsable message
    //     Add the original exception as the cause if possible. (eg: non RunTimeException). 

    private static int exceptionCount = 0;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> ints = Arrays.asList("1", "2", "exceptionThrow");
        Function<StackTraceElement, AnnotatedStackTraceElement> makeAnnotatedSte = 
                ste -> { 
                    exceptionCount++;
                    return new AnnotatedStackTraceElement(ste); };
        Function<AnnotatedStackTraceElement, AnnotatedStackTraceElement> annotateThisClass =
                ast -> { 
                    if (ast.getSte().getClassName().equals(ExampleStackTrace.class.getName())) {
                        ast.setMsg("The root of all your problems");
                    }
                    return ast;
                };
        Function<AnnotatedStackTraceElement, AnnotatedStackTraceElement> annotateFirst = 
                ast -> {
                    if (1 == exceptionCount) {
                        ast.setMsg("Actual exception cause.");
                    }
                    return ast;
                };
        Function<AnnotatedStackTraceElement, AnnotatedStackTraceElement> annotateNonStream = 
                ast -> {
                    if (!ast.getSte().getClassName().startsWith("java.util.stream")) {
                        ast.setMsg("Used to narrow down cause of exception");
                    }
                    return ast;
                };
        

        
        try {
            ints.stream()
                    .map(Integer::parseInt)
                    .forEach(LOG::debug);
        } catch (Exception ex) {
            LOG.debug("-----------------");
            Arrays.asList(ex.getStackTrace()).forEach(LOG::debug);
            LOG.debug("------Cause------");
            LOG.debug("Cause:" + ex.getCause());
            LOG.debug("------ Annotated ----- ");
            
            Arrays.asList(ex.getStackTrace()).stream()
                    .map(makeAnnotatedSte)
                    .map(annotateNonStream)
                    .filter(ast -> !ast.getSte().getClassName().startsWith("java.util"))  // ignore all stream exceptions.
                    .map(annotateThisClass)
                    .map(annotateFirst)
                    .forEach(LOG::debug);
        }
    }   

}
