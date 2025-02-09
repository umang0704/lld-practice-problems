package org.lld.models.dto;

import lombok.Data;
import org.lld.entities.Contact;

import java.util.Collection;
import java.util.Collections;

public class SearchResults {

    private int count;
    private Collection<Contact> contacts;

    public void setCount(int count) {
        this.count = count;
    }

    public void setContacts(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "count=" + count +
                ", contacts=" + contacts +
                '}';
    }
}
