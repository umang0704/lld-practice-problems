package org.lld.repositories;

import org.lld.entities.Contact;
import org.lld.models.Trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DataRepository {
    private HashMap<String, Contact> phoneNumberMapping = new HashMap<>();
    private Trie trie = new Trie();

    public HashMap<String, Contact> getPhoneNumberMapping() {
        return phoneNumberMapping;
    }

    public Trie getTrie() {
        return trie;
    }

    /**
     * Checks if phone number exists in Map
     * @param phoneNumber
     * @return
     */
    public boolean checkIfPhoneExists(String phoneNumber){
        return phoneNumberMapping.containsKey(phoneNumber);
    }

    /**
     * addes contact to Map
     * @param contact
     */
    public void addContactMap(Contact contact){
        phoneNumberMapping.put(contact.getPhoneNumber(), contact);
    }

    /**
     * Adds contact to trie
     * @param key
     * @param contact
     */
    public void addContactNode(String key, Contact contact){
        if(key == null || key.trim().isBlank()){
            System.out.println("Key is empty");
        }
        key = key.toLowerCase();
        Trie node = trie;
        for(char c : key.toCharArray()){
            node.getNode().putIfAbsent(c,new Trie());
            node = node.getNode().get(c);
        }
        node.getContacts().add(contact);
    }

    /**
     * Fetch contact by phone number from map
     * @param phoneNumber
     * @return
     */
    public Contact getContactByPhoneNumber(String phoneNumber){
        return phoneNumberMapping.get(phoneNumber);
    }

    /**
     * Fetch Contacts from Trie
     * @param key
     * @return {@link Collection}
     */
    public Collection<Contact> findByKey(String key){
        if(key == null || key.trim().isBlank()){
            System.out.println("Key is empty");
        }
        key = key.toLowerCase();
        Trie node = trie;
        for(char c : key.toCharArray()) {
            node = trie.getNode().get(c);
            if(node == null){
                return null;
            }
        }
        return collectContacts(node);
    }

    /**
     * Collects contacts from last character of key from all nodes
     * @param node
     * @return
     */
    private List<Contact> collectContacts(Trie node) {
        List<Contact> result = new ArrayList<>(node.getContacts());
        for (Trie child : node.getNode().values()) {
            result.addAll(collectContacts(child));
        }
        return result;
    }

}
