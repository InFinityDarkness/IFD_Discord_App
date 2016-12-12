package de.telekom.emcsbi01;

import de.telekom.emcsbi01.wordReader.IO;

public class Main {

    public static void main(String[] args) {
	    IO baseFile = new IO();
	    baseFile.loadWordFile();
	    baseFile.write2Console();
    }
}
