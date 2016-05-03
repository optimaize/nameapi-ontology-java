package org.nameapi.ontology5.input.entities.person;

/**
 *
 * @author sam
 */
public class InputPersonBuilders {

    public static NaturalInputPersonBuilder natural() {
        return new NaturalInputPersonBuilder();
    }

    public static LegalInputPersonBuilder legal() {
        return new LegalInputPersonBuilder();
    }

    //TODO
    //legal
    //business
    //family
    //couple
    //multi-people

//    public static NaturalInputPersonBuilder unknown() {
//        //TODO
//        throw new UnsupportedOperationException();
//    }

}
