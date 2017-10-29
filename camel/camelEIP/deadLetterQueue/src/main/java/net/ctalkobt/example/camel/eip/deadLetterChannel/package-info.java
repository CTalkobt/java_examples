/*
 * Copyright (C) 2017 Pivotal Software, Inc.
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
 */
package net.ctalkobt.example.camel.eip.deadLetterChannel;

/*
Dead Letter Queue : When a messaging system determines that it cannot or should
  not deliver a messsage it may elect to move the message to a Dead Letter Queue
  or channel.
   
In the example, incoming messages will be diverted to a dead letter queue route
   approximately 50% of the time.  After they're delivered, they can manually be
   moved within jms to attempt to resend, removal of them, or manually moving
   them to the operational queue.

Note: Tracing is forced to be enabled as without a NPE is thrown.  It's undetermined
  as yet whether this is a bug in camel or in the actual test. @@TODO: Investigate. 
*/
