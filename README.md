nameapi-ontology-java
===================

Contains the domain classes that are used as input to the NameAPI services as well as the result objects.

This library is used by our Java client library https://github.com/optimaize/nameapi-client-java

This library requires at least Java 7, it's also tested and used with Java 8.


CORE module:

Contains the domain classes that are used as input to the NameAPI server as well as the result objects.

These are the same that the Java web service client library uses.
That's exactly the reason why these are in a separate project; so that they can
be shared easily, and can be included as a separate dependency in other projects.


JSON module:

Provides from and to JSON marshalling for the domain classes in the 'core' module.
This uses the Jackson library.

You don't necessarily need this module. It may serve you also as a functional demo.
It also contains tests to ensure the conversion from and to JSON using Jackson works correctly.