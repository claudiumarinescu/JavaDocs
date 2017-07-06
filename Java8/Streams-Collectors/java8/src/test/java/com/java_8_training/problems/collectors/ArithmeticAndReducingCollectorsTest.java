
package com.java_8_training.problems.collectors;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingInt;
import static junit.framework.Assert.assertEquals;

@Ignore
public class ArithmeticAndReducingCollectorsTest {

    // See: Dish.menu.stream()

    @Test
    public void leastCaloricDishMEAT() {
        //TODO #C5
        Dish leastCaloricMEAT = new Dish();
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> op = Dish.menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .collect(minBy(dishComparator));

        leastCaloricMEAT = op.get();
        assertEquals("chicken", leastCaloricMEAT.getName());
    }

    @Test
    public void statisticsForVegetarianDishes() {
        //TODO #C6
        IntSummaryStatistics vegetarianStats = new IntSummaryStatistics();
        vegetarianStats = Dish.menu.stream().filter(d -> d.isVegetarian()).collect(summarizingInt(Dish::getCalories));


        assertEquals(4, vegetarianStats.getCount());
        assertEquals(1550, vegetarianStats.getSum());
        assertEquals(120, vegetarianStats.getMin());
        assertEquals(387.5, vegetarianStats.getAverage());
        assertEquals(550, vegetarianStats.getMax());

    }
}
