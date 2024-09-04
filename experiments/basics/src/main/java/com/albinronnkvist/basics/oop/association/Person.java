package com.albinronnkvist.basics.oop.association;

// Both objects can exist independently:
// - A Person can exist without being associated with a Company
// - A Company can exist without being associated with any Person.
public class Person {
    private String name;
    private Company company; // Association: Person "works for" Company

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // The association can be easily changed or removed (passing null)
    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCompanyName() {
        return company != null ? company.getName() : "No Company";
    }
}
