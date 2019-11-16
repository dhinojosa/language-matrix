package com.evolutionnext.generics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericsBasicsTest {

    @SuppressWarnings("unchecked")
    @Test
    public void testRawTypes() {
        List list = new ArrayList();
        list.add("Foo");
        list.add(4);
        list.add(10.0);
        Object object = list.get(0); //Object
        if (object instanceof String) {
            String string = (String) object;
            string.substring(0, 1); //Substring belongs to String
        }
    }

    //2. Demo: Needless Casting of Raw Types Before
    @SuppressWarnings("unchecked")
    @Test
    public void testAnotherWithCastingWithRawTypes() {
        List words = new ArrayList(); //raw type
        words.add("Hello ");
        words.add("world!");
        String s = ((String) words.get(0)).substring(1, 2) +
                ((String) words.get(1)).substring(2, 4);
        System.out.println(s);
    }

    //3. Demo: No Casting of Raw Types After
    @Test
    public void testEliminationOfCasting() {
        //JDK11
        //final var words = new ArrayList<String>();
        List<String> words = new ArrayList<>(); //JDK 5- 10
        words.add("Hello ");
        words.add("world!");
        String s = words.get(0).substring(1, 2) +
                words.get(1).substring(2, 4);
        System.out.println(s);
    }

    //4. Demo: Needless Boxing and Unboxing Before
    @Test
    public void testAutomaticBoxingOfPrimitivesBefore() {
        List<Integer> ints = new ArrayList<>();
        ints.add(new Integer(1));
        int n = ints.get(0).intValue();
        System.out.println(n);
    }

    //5. Demo: Automatic Boxing and Unboxing After
    @Test
    public void testAutomaticBoxingOfPrimitivesAfter() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        int n = ints.get(0);
        System.out.println(n);
    }

    //6. Demo: A Container in a container
    @Test
    public void testContainerInAContainer() {
        List<List<Integer>> ints = new ArrayList<>();
        ints.add(Arrays.asList(4, 10, 11, 12));
        ints.add(Arrays.asList(5, 9, 3, 42));
        Integer actual = ints.get(0).get(1);
        assertThat(actual).isEqualTo(10);
    }

    //7. Demo: Static
    @Test
    public void testOverrideStaticGenericTypes() {
        Number n = Arrays.<Number>asList(5, 1, 3, 3, 6, 10).get(0);
        assertThat(n).isInstanceOf(Number.class);
    }

    //8. Demo: Erasure
    @Test
    @SuppressWarnings("InstantiatingObjectToGetClassObject")
    public void testErasure() {
        System.out.format("Runtime type of ArrayList<String>: %s\n",
                new ArrayList<String>().getClass());
        System.out.format("Runtime type of ArrayList<Long>  : %s\n",
                new ArrayList<Long>().getClass());
    }


    @Test
    public void testStream() {
        /*
            View the types we start with List<String>
            Then we have a Stream<String
            Then can fit a function of <CharSequence> and <Number>
         */
        Stream.of("One", "Two", "Three", "Four")
              .map(new Function<CharSequence, Number>() {
                  @Override
                  public Integer apply(CharSequence s) {
                      return s.length();
                  }
              })
              .forEach(new Consumer<Object>() {
                  @Override
                  public void accept(Object o) {
                      System.out.println(o);
                  }
              });
    }
}
