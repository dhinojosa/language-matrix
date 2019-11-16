package com.evolutionnext.generics;

import com.evolutionnext.generics.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvariantTest {

    public void processInvariantList(List<American> americans) {
        Object object = americans.get(1);                //producer
        Person person = americans.get(1);                //producer
        NorthAmerican northAmerican = americans.get(1);  //producer
        American american = americans.get(1);            //producer
        americans.add(new American());                   //consumer
        americans.add(new Massachusettsan());            //consumer
        americans.add(new Coloradan());                  //consumer
        americans.add(new StLouisan());                  //consumer
        americans.add(new Denverite());                  //consumer
        americans.add(new NorthCarolinian());            //consumer
        americans.add(new Bostonian());                  //consumer
        americans.add(new Minnesotan());                 //consumer
        americans.add(new Wisconsinite());
        americans.add(new Madisonian());
        americans.add(new SaltLaker());
        americans.add(new Utahn());
        americans.add(new Texan());
        americans.add(null);                             //consumer
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


    //9. Invariant Method Calls
    @Test
    public void testInvariantMethod() throws Exception {
        List<American> americans = new ArrayList<>();
        americans.add(new American());
        americans.add(new Wisconsinite());
        americans.add(new Madisonian());
        americans.add(new Milwaukeean());
        americans.add(new StLouisan());
        americans.add(new SanFranciscan());
        processInvariantList(americans);
    }


    //10. Invariant Assignments
    @Test
    public void testInvariantAssignment() throws Exception {
        List<American> americans = new ArrayList<American>();
        //americans.add(new Object());                         //won't work
        //americans.add(new NorthAmerican());                  //won't work
        americans.add(new American());                         //consumer
        americans.add(new Massachusettsan());                  //consumer
        americans.add(new Bostonian());                        //consumer
        americans.add(new Milwaukeean());

        Object object = americans.get(1);                      //producer
        Person person = americans.get(1);                      //producer
        NorthAmerican northAmerican = americans.get(1);        //producer
        American american = americans.get(1);                  //producer
        //Massachusettsan massachusettsan = americans.get(1);  //won't work
        //Bostonian bostonian = americans.get(1);              //won't work
        //Madisonian madisonian = americans.get(0);            //won't work
    }

}
