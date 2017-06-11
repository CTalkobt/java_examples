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

package net.ctalkobt.example.java.lambda;

/**
 * 
 * Lambda Do's and Dont's:
 * 
 * - Keep it simple, short.
 *   - Keep in mind separation of concerns.
 *   - Don't be afraid to move predicates, functions out into named ones.
 * - If having difficulty try to invert thinking. Eg: removeIf() instead of initial iterator.
 * - Feel free to inline comments
 *
 * Function<Integer,Integer> busUse = x -> x.abc(123) + x.def(343); 
 *   x -> x.abc(124) + x.def(123)
 * 
 * 
 * When to use which / what chart
 * 
 * C<x> - Collection of X.
 * x,y,z - Different types.
 * 
 * Initial     Addtl               Result               Operation
 * -------     -----------         ------------------   ------------------------------
 * x                               x                    Function.Identity() or x -> x
 * C<C<x>>      Function           C<x>                 FlatMap
 * x            Function           y                    Map
 * x,y          BiFunction         z,a                  Map
 * x            Predicate          x iff predicate      Filter
 * x            Predicate          y,x                  partitioningBy
 * x            Delimiter          "x1,x2,x3,x4,..."    terminating - joining (String based)
 * x            Function           y,C(x1,x2,x3,x4,x5)  groupingBy
 * 
 */

