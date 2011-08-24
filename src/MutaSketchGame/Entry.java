package MutaSketchGame;
//Entries in the chain, must have either a sentence or a sketch.
public interface Entry {
	//Must identify itself as a sentence or a sketch.
	EntryType type();
	//Must provide access to its sentence or sketch.
	Object getContent();
	//After a chain is done, it would be nice to know who did what.
	//I think I should make a class to represent players.
	//For now, a string of their chosen name will suffice.
	String getAuthor();
}
