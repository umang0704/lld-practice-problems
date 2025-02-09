
```
Contact
    - int id PK
    - String firstName
    - String lastName
    - String phoneNumber 
    
ContactService
    + addContact(String firstName, String lastName, String phoneNumber)

Search Service 
    + List<Contact> findByFirstName(String key)
    + List<Contact> findByLastName(String key)
    + List<Contact> findByNumber(String key)

DataRepository
    - Map<String number, Contact contact> director
    - TrieNode trie
    + getTrie()
    + getDirectory()

TrieNode 
    - Map<Character,TrieNode> node 
    - Set<Contact> contacts
```