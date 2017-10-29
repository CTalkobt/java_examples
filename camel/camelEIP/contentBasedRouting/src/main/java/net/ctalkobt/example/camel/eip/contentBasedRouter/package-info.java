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

package net.ctalkobt.example.camel.eip.contentBasedRouter;

/*
Content Based Router : Allows routing of messages to the correct destination 
   based on the contents of the message exchanges.

In the example, example here shows the list of People and breaks them into
the first matching category:

   Young Person   Age <= 10
   Older Person   Age < 100
   otherwise an Ancient Person 

Age is extracted into a header field which is then used to perform the comparsion
w/in a choice()/when() route.

*/
