package org.lld.models;

import lombok.Getter;
import org.lld.entities.Contact;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    private HashMap<Character,Trie> node = new HashMap<>();
    private ArrayList<Contact> contacts = new ArrayList<>();

    public HashMap<Character, Trie> getNode() {
        return node;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "node=" + node +
                ", contacts=" + contacts +
                "}";
    }
}
