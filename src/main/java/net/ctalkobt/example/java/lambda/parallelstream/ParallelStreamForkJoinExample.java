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

package net.ctalkobt.example.java.lambda.parallelstream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.apache.log4j.Logger;

public class ParallelStreamForkJoinExample {
    private static final Logger log = Logger.getLogger(ParallelStreamForkJoinExample.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long maxLong = 1000;
        int maxForks = 3;
        
        Map<Long, Long> result = new HashMap<>(); 
        List<Long> countHolder = Arrays.asList(0l);

        List<Long> ints = LongStream.range(0, maxLong)
                .mapToObj(x -> x)
                .collect(Collectors.toList());

        ForkJoinPool fjp = new ForkJoinPool(maxForks);
        
        long start = System.currentTimeMillis();
        fjp.submit(()
                -> ints.parallelStream().forEach((Long x) -> {
                    Long count = countHolder.get(0);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        Arrays.asList(ex.getStackTrace()).stream().forEach(log::debug);
                    }
                    result.put(count, x);
                    countHolder.set(0, count + 1);
                })
        ).join();
        
        while(!fjp.isQuiescent()) {
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        
        log.debug("ForkJoinPool:" + fjp);
        log.debug("After parallel count for " + maxLong + " = " + result.size());
        log.debug("Time: " + (end-start) / 1000.0);
    }

}
