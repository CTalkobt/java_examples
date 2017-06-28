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
| [Consumers](src/main/java/net/ctalkobt/example/java/lambda/Consumers/ConsumersExample.java) | x -> Consumer.accept(x) |Demonstrates calling and chaining of consumers. |
| [removeIf](src/main/java/net/ctalkobt/example/java/lambda/Collections/RemoveIf/RemoveIfExample.java) | C(x).removeIf(Predicate(x)) |Remove element(s) if predicate matches. |
| [forEach](src/main/java/net/ctalkobt/example/java/lambda/Collections/ForEach/ForEachExample.java) | C(x).forEach(Consumer) |Invokes consumer for each value of C(x) |
| [filter](src/main/java/net/ctalkobt/example/java/lambda/Filter/FilterExample.java) | filter(x -> fn(x)) |Only includes x matching fn(x) in the resulting stream. |
| [partitioningBy](src/main/java/net/ctalkobt/example/java/lambda/Collectors/partitioningBy/PartitioningByExample.java) | C(x) -> Map<Boolean f(x), List<x>> |Divides a list by a given fn(x) |
| [toMap](src/main/java/net/ctalkobt/example/java/lambda/Collectors/toMap/ToMapExample.java) | x -> [key(x), value(x)] :: Map |Converts each x into item in map via key and value functions. |
| [groupingBy](src/main/java/net/ctalkobt/example/java/lambda/Collectors/groupingBy/GroupingByExample.java) | C(x) -> map( function(x), List(x given f(x)) ) |Converts current stream into a map of values.  |
| [joining](src/main/java/net/ctalkobt/example/java/lambda/Collectors/joining/JoiningExample.java) | x1,x2,x3,x3... -> x1 joinChar x2 joinChar x3 joinChar ... |Join stream of arguments joining them by a string. |
| [toList](src/main/java/net/ctalkobt/example/java/lambda/Collectors/toList/ToListExample.java) | C(x) -> List<>({ x1, x2, x3...}) |Converts stream of x to a list result.  |
| [reducingBy](src/main/java/net/ctalkobt/example/java/lambda/Collectors/reducing/ReducingExample.java) | C(x) -> each x : fn(prior, x) |Reduces C(x) by invoking f(x) for each x and prior result. |
