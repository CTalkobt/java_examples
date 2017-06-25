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


| **Expression**      | **Type** | **Result**  | **Description**            | **Examples** |
| ----------          | -------  | ----------- | ----                       |--   |
| x                   |          |           x | Identity Operation         |   |
| Function.Identity() |          |           x | Identity Operation         |   |
| C<x>                | Function |           x | FlatMap - Expands collection into stream | [FlatMap.java](./src/main/java/net/ctalkobt/example/java/lambda/Mapping/FlatMap/FlatMap.java)
| x                   | Function |       fn(x) | Map - Maps values through fn | [MapExample.java](./src/main/java/net/ctalkobt/example/java/lambda/Mapping/Map/MapExample.java)
