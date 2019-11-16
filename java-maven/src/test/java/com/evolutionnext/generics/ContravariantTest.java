package com.evolutionnext.generics;

import com.evolutionnext.generics.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ContravariantTest {
    //You know the boundary but you don't know the specifics
    public void processContravariantList(List<? super American>
                                                 americans) {
        americans.add(new American());
        americans.add(new Massachusettsan());
        americans.add(new Bostonian());
        americans.add(new Wisconsinite());
        americans.add(new Madisonian());
        americans.add(new NorthernCalifornian());
        americans.add(new Raleighite());
        americans.add(new Denverite());
        americans.add(new Coloradan());
        americans.add(new Missourian());
        americans.add(new StLouisan());
        //americans.add(new European()); //Nein!
        //americans.add(new Person());
        americans.add(null);

        Object o = americans.get(0);
        //American a = americans.get(0);
    }

    /*
     *
     * Space is intentional
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    //16. Contravariant Method
    @Test
    public void testContravariantMethod() {
        List<Object> objects = new ArrayList<>();
        objects.add(new Object());
        objects.add(new Object());
        processContravariantList(objects);

        List<Person> people = new ArrayList<>();
        objects.add(new Person());
        objects.add(new Canadian());
        objects.add(new American());
        processContravariantList(people);


        List<NorthAmerican> northAmericans = new ArrayList<>();
        northAmericans.add(new NorthAmerican());
        northAmericans.add(new NorthAmerican());
        processContravariantList(northAmericans);


        List<American> americans = new ArrayList<>();
        americans.add(new American());
        americans.add(new American());
        processContravariantList(americans);
    }

    //17. Contravariant Assignment
    @Test
    public void testContravariantAssignment() {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Canadian());
        people.add(new American());
        people.add(new Coloradan());
        people.add(new Mexican());
        people.add(new European());

        List<? super American> americans = people;

        Object object = americans.get(0); //special case

        //       Person person = americans.get(0);                   //nope
        //       NorthAmerican northAmerican = americans.get(0);     //nope
        //       American american = americans.get(0);               //nope
        //       Massachusettsan Massachusettsan = americans.get(0); //nope
        //       Bostonian bostonian = americans.get(0);           //nope
        //
         //      americans.add(new Object());
         //      americans.add(new Person());
         //      americans.add(new NorthAmerican());
        americans.add(new American());
        americans.add(new Massachusettsan());
        americans.add(new Bostonian());
        americans.set(1, new NewMexican());
        americans.add(null);
    }
}
