package org.nameapi.ontology5.input.entities.person.age;

import org.testng.annotations.Test;
import java.util.Date;
import static org.testng.Assert.assertEquals;

/**
 * @author Nicole Torres
 */
public class BirthDateTest {

    @Test
    public void getBirthMonth() throws Exception {
        assertEquals(new BirthDate(1960, 2, 15).getMonth().get(), (Integer)2);
    }

    @Test
    public void equal() throws Exception {
        assertEquals(new BirthDate(1960, 2, 15), new BirthDate(new Date(60,1,15)));
        assertEquals(new BirthDate(1960, 2, 15), new BirthDate("1960", "2","15"));
        assertEquals(new BirthDate(1960, 9, 9),  new BirthDate("1960", "09","09")); //testing for octal parsing bug
    }
}
