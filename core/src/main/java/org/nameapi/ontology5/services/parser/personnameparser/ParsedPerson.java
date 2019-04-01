package org.nameapi.ontology5.services.parser.personnameparser;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import org.nameapi.ontology5.cremalang.annotation.GeneratedCode;
import org.nameapi.ontology5.output.entities.person.MailingPersonRole;
import org.nameapi.ontology5.output.entities.person.PersonRole;
import org.nameapi.ontology5.output.entities.person.PersonType;
import org.nameapi.ontology5.output.entities.person.name.OutputPersonName;
import org.nameapi.ontology5.services.genderizer.GenderizerResult;

import java.util.List;
import java.util.Set;

/**
 * @author Fabian Kessler
 * @author Nicole Torres
 */
public class ParsedPerson {

    private final PersonType personType;
    private final PersonRole personRole;
    private final Set<MailingPersonRole> mailingPersonRoles;
    private final GenderizerResult gender;
    private final String addressingGivenName;
    private final String addressingSurname;
    private final OutputPersonName outputPersonName;
    private final List<ParsedPerson> people;

    @JsonCreator
    public ParsedPerson(
            @JsonProperty("personType") @JsonPropertyDescription("The type of person, it can be types of natural and legal people, and groups of them.\n See https://goo.gl/1iwt9p for the documentation of the PersonType enum values.") PersonType personType,
            @JsonProperty("personRole") @JsonPropertyDescription("The role of the person. For example it can be the receiver, the owner or just a contact.\n See https://goo.gl/xVhJXh for the documentation of the PersonRole enum values.") PersonRole personRole,
            @JsonProperty("mailingPersonRoles") @JsonPropertyDescription("The roles of a person within a mailing address. " +
                    "It is of interest once not only a single, but multiple entities are mentioned." +
                    "\nSee https://goo.gl/11XqE5 for the documentation of the MailingPersonRole enum values.") Set<MailingPersonRole> mailingPersonRoles,
            @JsonProperty("gender") @JsonPropertyDescription("The result of the Genderizer containing the gender, optionally the male proportion and the confidence.") GenderizerResult gender,
            @JsonProperty("addressingGivenName") @JsonPropertyDescription("The given name that may be used when addressing the person.") String addressingGivenName,
            @JsonProperty("addressingSurname")  @JsonPropertyDescription("The surname that may be used when addressing the person.") String addressingSurname,
            @JsonProperty("outputPersonName") @JsonPropertyDescription("All the names identified in an input person name.") OutputPersonName outputPersonName,
            @JsonProperty("people") @JsonPropertyDescription("The list of people parsed from the input.") List<ParsedPerson> people) {
        this.personType = personType;
        this.personRole = personRole;
        this.mailingPersonRoles = mailingPersonRoles;
        this.gender = gender;
        this.addressingGivenName = addressingGivenName;
        this.addressingSurname = addressingSurname;
        this.outputPersonName = outputPersonName;
        this.people = people;
    }


    public PersonType getPersonType() {
        return personType;
    }

    public PersonRole getPersonRole() {
        return personRole;
    }

    public Set<MailingPersonRole> getMailingPersonRoles() {
        return mailingPersonRoles;
    }

    public GenderizerResult getGender() {
        return gender;
    }

    public String getAddressingGivenName() {
        return addressingGivenName;
    }

    public String getAddressingSurname() {
        return addressingSurname;
    }

    public OutputPersonName getOutputPersonName() {
        return outputPersonName;
    }

    public List<ParsedPerson> getPeople() {
        return people;
    }


    @Override
    public String toString() {
        return "ParsedPerson{" +
                "personType=" + personType +
                ", personRole=" + personRole +
                ", mailingPersonRoles=" + mailingPersonRoles +
                ", gender=" + gender +
                ", addressingGivenName='" + addressingGivenName + '\'' +
                ", addressingSurname='" + addressingSurname + '\'' +
                ", outputPersonName=" + outputPersonName +
                ", people=" + people +
                '}';
    }


    @Override @GeneratedCode
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParsedPerson that = (ParsedPerson) o;

        if (personType != that.personType) return false;
        if (personRole != that.personRole) return false;
        if (!mailingPersonRoles.equals(that.mailingPersonRoles)) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (addressingGivenName != null ? !addressingGivenName.equals(that.addressingGivenName) : that.addressingGivenName != null)
            return false;
        if (addressingSurname != null ? !addressingSurname.equals(that.addressingSurname) : that.addressingSurname != null)
            return false;
        if (outputPersonName != null ? !outputPersonName.equals(that.outputPersonName) : that.outputPersonName != null)
            return false;
        return !(people != null ? !people.equals(that.people) : that.people != null);

    }

    @Override @GeneratedCode
    public int hashCode() {
        int result = personType != null ? personType.hashCode() : 0;
        result = 31 * result + (personRole != null ? personRole.hashCode() : 0);
        result = 31 * result + (mailingPersonRoles != null ? mailingPersonRoles.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (addressingGivenName != null ? addressingGivenName.hashCode() : 0);
        result = 31 * result + (addressingSurname != null ? addressingSurname.hashCode() : 0);
        result = 31 * result + (outputPersonName != null ? outputPersonName.hashCode() : 0);
        result = 31 * result + (people != null ? people.hashCode() : 0);
        return result;
    }
}
