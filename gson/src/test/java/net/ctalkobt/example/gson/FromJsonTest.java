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
 */
package net.ctalkobt.example.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Map;
import java.util.StringJoiner;
import org.junit.Assert;
import org.junit.Test;

public class FromJsonTest {
    @Test
    public void fromJson() {
        String[] keys = new String[] { "a", "b", "c" };
        Object[] values = new Object[] { "A", "B", 3.0 };
        
        String jsonString = buildSimpleJsonString(keys, values);
        
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        Map<Object,Object> vals = gson.fromJson(jsonString, Map.class);
        
        for (int i=0; i<keys.length; i++) {
            Assert.assertEquals(values[i], vals.get(keys[i]));
        }
    }

    protected String buildSimpleJsonString(String[] keys, Object[] values) {
        StringJoiner keyValue = new StringJoiner(",");

        for (int i=0; i < keys.length; i++) {
            Object val = values[i];
            if (val instanceof String) {
                keyValue.add(keys[i] + ":\"" + values[i] + "\"");
            } else {
                keyValue.add(keys[i] + ":" + values[i]);
            }
        }

        return "{" + keyValue.toString() + "}";
    }
}
