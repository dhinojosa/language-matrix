package com.evolutionnext.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Hinojosa
 * @since 8/24/16 3:48 PM
 * url: <a href="http://www.evolutionnext.com">http://www.evolutionnext.com</a>
 * email: <a href="mailto:dhinojosa@evolutionnext.com">dhinojosa@evolutionnext.com</a>
 * tel: 505.363.5832
 */
public class GenericsRunner {

    public static void main(String[] args) {



        List<? extends American> americans = new ArrayList<NewMexican>();

        //The Get Principal!
        Object object = americans.get(0);
        Human human = americans.get(0);
        NorthAmerican northAmerican = americans.get(0);
        American american = americans.get(0);

        //You can only put a null
        americans.add(null);

        List<? super American> newMexicans = new ArrayList<Human>();

        //The Put Principal
        newMexicans.add(new American("A", "B"));
        newMexicans.add(new NewMexican("A", "B", ChilePreference.GREEN));
        newMexicans.add(new Coloradan("A", "B"));
        newMexicans.add(null);

        //You can only get an object
        Object object2 = newMexicans.get(0);
    }
}