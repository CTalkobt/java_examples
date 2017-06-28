# java_examples
Java Examples

This repository contains a number of examples of Java core library functionality. 
The primary version target is Java 8 at the present time.  This may and probably will
change over time as newer versions are released. At that time branches will be created
as appropritate. 

*Current Focus*
The current focus right now is to iterate throught the Java 8 lambda functionality and
create a set of clear, easy to use reference examples as well as a cross reference table
showing how Java can implement lambda functionality.  See the package-info under the lambda
directory for the beginning of such a table.  This is likely to move into it's own HTML table
in the near future. 


| **Link** | **Usage** | **Description** |
| ---- | ---- | ----------- |
|
| [removeIf](src/main/java/net/ctalkobt/example/java/lambda/Collections/RemoveIf/RemoveIfExample.java) | C(x).removeIf(Predicate(x)) |Remove element(s) if predicate matches. |
|
|
| [forEach](src/main/java/net/ctalkobt/example/java/lambda/Collections/ForEach/ForEachExample.java) | C(x).forEach(Consumer) |Invokes consumer for each value of C(x) |
|
|
| [groupingBy](src/main/java/net/ctalkobt/example/java/lambda/Collectors/groupingBy/GroupingByExample.java) | C(x) -> map( function(x), List(x given f(x)) ) |Converts current stream into a map of values.  |
|
|
| [joining](src/main/java/net/ctalkobt/example/java/lambda/Collectors/joining/JoiningExample.java) | x1,x2,x3,x3... -> x1 joinChar x2 joinChar x3 joinChar ... |Join stream of arguments joining them by a string. |
|
