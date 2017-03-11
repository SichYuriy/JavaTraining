package com.gmail.at.sichyuriyy.javatraining.homework4.task22;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Yuriy on 3/10/2017.
 */
public class PostOfficeTest {

    @Test
    public void sendToSubscribers() {
        Magazine magazine = new Magazine("magazine1");
        Newspaper newspaper = new Newspaper("newspaper1");

        PostOffice postOffice = new PostOffice();

        Subscriber yuriy = new Subscriber("Yuriy");
        Subscriber sergiy = new Subscriber("Sergiy");

        magazine.addSubscriber(yuriy);
        magazine.addSubscriber(sergiy);

        newspaper.addSubscriber(sergiy);

        Edition magazineEdition = new Edition(magazine, null);
        Edition newspaperEdition = new Edition(newspaper, null);

        postOffice.sendToSubscribers(magazineEdition);
        postOffice.sendToSubscribers(newspaperEdition);

        List<Edition> yuriyLibraryExpected = Collections.singletonList(magazineEdition);
        List<Edition> sergiyLibraryExpected = Arrays.asList(magazineEdition, newspaperEdition);

        List<Edition> yuriyLibraryActual = yuriy.getLibrary();
        List<Edition> sergiyLibraryActual = sergiy.getLibrary();

        assertEquals(yuriyLibraryExpected, yuriyLibraryActual);
        assertEquals(sergiyLibraryExpected, sergiyLibraryActual);
    }

}