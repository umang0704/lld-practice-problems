package org.lld;

import org.lld.client.LibraryClient;

public class Main {
    public static void main(String[] args) {
        LibraryClient libraryClient = new LibraryClient();
        libraryClient.startLibrary();
    }
}