nameapi-ontology-java
===================

Contains the domain classes that are used as input to the NameAPI server.
Use the 'core' module, and optionally the 'json' module.
        
This library requires at least Java 7.


CORE module:

Contains the domain classes that are used as input to the NameAPI server.

These are the same that the Java web service client library uses.
That's exactly the reason why these are in a separate project; so that they can
be shared easily, and can be included as a separate dependency in other projects.


JSON module:

Provides from and to JSON marshalling for the domain classes in the 'core' module.
This uses the Jackson library.

You don't necessarily need this module. It may serve you also as a functional demo.
It also contains tests to ensure the conversion from and to JSON using Jackson works correctly.