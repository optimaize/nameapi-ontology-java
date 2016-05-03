package org.nameapi.ontology5.input.entities.person;

import org.nameapi.ontology5.input.entities.address.*;
import org.nameapi.ontology5.input.entities.contact.EmailAddressFactory;
import org.nameapi.ontology5.input.entities.contact.TelNumberFactory;
import org.nameapi.ontology5.input.entities.person.age.AgeInfoFactory;
import org.nameapi.ontology5.input.entities.person.gender.StoragePersonGender;
import org.nameapi.ontology5.input.entities.person.name.builder.NameBuilders;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author sam
 */
public class NaturalInputPersonBuilderTest {

    @Test
    public void testBuildFresh() throws Exception {
        NaturalInputPerson simplePerson = buildJohnDoe();
        assertTrue( simplePerson.getPersonName().toString().contains("John") );
        assertEquals(simplePerson.getCorrespondenceLanguage().get(), "en");
    }

    @Test
    public void testBuildCopyConstructor() throws Exception {
        NaturalInputPerson simplePerson = new NaturalInputPersonBuilder( buildJohnDoe() )
                .gender(StoragePersonGender.FEMALE)
                .build();
        assertTrue( simplePerson.getPersonName().toString().contains("John") );
        assertEquals( simplePerson.getGender(), StoragePersonGender.FEMALE );
    }

    private NaturalInputPerson buildJohnDoe() {
        return new NaturalInputPersonBuilder()
                .name(
                        NameBuilders.western()
                                .givenName("John")
                                .surname("Doe")
//                            .add(Fields.title("Dr.")) //TODO enable
                                .build()
                )
                    //TODO move to name (above)    name.addTitle("Dr.")
                    .gender(StoragePersonGender.MALE)
                    .age(AgeInfoFactory.forYear(1950))
                    .addNationality("US")
                    .addNativeLanguage("en")
                    .correspondenceLanguage("en")
                    .addAddressForAll(new StructuredAddressBuilder()
                                    .streetInfo(new StructuredStreetInfoBuilder()
                                                    .streetName("Hill road")
                                                    .streetNumber("512")
                                    )
                                    .placeInfo(new StructuredPlaceInfoBuilder()
                                                    .locality("Beverly Hills")
                                                    .postalCode("90210")
                                                    .country("US")
                                    )
                                    .build()
                    )
        .build();
    }

    @Test
    public void buildPersonFromDataArray() {
        /*
        Name	FirstName	ZipCode	Place	Street	HouseNr	Sex	Birthdate	ContactPhone	Mail
        Nachname	Vorname	75177	Pforzheim	Strasse	54	2	12.08.1982	01234/56789	web@email.de
         */
        String[] fields = new String[]{
                "Nachname", "Vorname",
                "75177", "Pforzheim", "Strasse", "54",
                "2", "12.08.1982",
                "01234/56789", "web@email.de"
        };
        NaturalInputPersonBuilder builder = new NaturalInputPersonBuilder()
                .name(
                        NameBuilders.western()
                                .givenName(fields[1])
                                .surname(fields[0])
                                .build()
                )
        ;
        StructuredAddress address = new StructuredAddressBuilder()
                .streetInfo(new StructuredStreetInfoBuilder().streetName(fields[4]).streetNumber(fields[5]).build())
                .placeInfo(new StructuredPlaceInfoBuilder()
                                .locality(fields[3])
                                .postalCode(fields[2])
                                .build()
                )
        .buildOrNull();
        if (address!=null) builder = builder.addAddressForAll(address);
        if (fields[6].equals("1")) {
            builder = builder.gender(StoragePersonGender.MALE);
        } else if (fields[6].equals("2")) {
            builder = builder.gender(StoragePersonGender.FEMALE);
        }
        if (!fields[7].isEmpty()) {
            builder = builder.age(AgeInfoFactory.forDate(fields[7].substring(6, 10), fields[7].substring(3, 5), fields[7].substring(0, 2)));
        }
        if (!fields[8].isEmpty()) {
            builder = builder.addTelNumber(TelNumberFactory.forNumber(fields[8]));
        }
        if (!fields[9].isEmpty()) {
            builder = builder.addEmail(EmailAddressFactory.forAddress(fields[9]));
        }

        NaturalInputPerson person = builder.build();

        assertTrue(person.getGender().isFemale());
        assertFalse(person.getAddresses().isEmpty());
        assertEquals(person.getAddresses().size(), 1);
        assertTrue(person.getAddresses().get(0).isUsageForAll());
        assertTrue(person.getAge().isPresent());
        assertEquals(person.getAge().get().getYear().get(), (Integer) 1982);
        assertEquals(person.getTelNumbers().iterator().next().getFullNumber(), "01234/56789");
        assertEquals(person.getEmailAddresses().iterator().next().getEmailAddress(), "web@email.de");
    }

    /**
     * "At least one value must be available!"
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void empty() {
        new NaturalInputPersonBuilder().build();
    }

}
