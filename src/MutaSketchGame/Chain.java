package MutaSketchGame;

import java.util.LinkedList;

//Represents a set of sentences and pictures. 
//In terms of the physical game, this is a single sheet of paper passed around.
public class Chain {
	
	
	//Not sure if needed, but will keep track of whether
	//the chain is incomplete.
	private boolean isFinished; 
	//Holds the set of sentences and sketches.
	private LinkedList<Entry> entries;
	//Keeps track of the last entry type
	private EntryType lastType;

	//Every chain starts with a sentence. (Is this a dumb restriction?)
	public Chain(TextEntry firstSentence) {
		if (firstSentence == null)
			throw new IllegalArgumentException("No sentence given.");
		isFinished = false;
		entries = new LinkedList<Entry>();
		entries.add(firstSentence);
		lastType = EntryType.TEXT;
	}
	//Attempts to add another entry to the chain
	void addEntry(Entry entry) {
		//Entries must alternate between sentences and sketches
		if (entry.type() == lastType)
			throw new IllegalArgumentException("An entry of the wrong type was supplied to this chain.");
		entries.add(entry);
		lastType = entry.type();
	}
}
