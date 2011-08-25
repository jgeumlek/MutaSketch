package MutaSketchGame;
//An entry representing a sentence.
public class TextEntry implements Entry {
	private String content;
	private String author;
	
	//This class is used to record any packet of text, not just those in a chain.
	//Used to communicate over the network too.
	//GAME_TEXT: a sentence describing a picture in game.
	//CHAT: used to hold a message from a player to the others.
	//COMMAND: used for various game-management requests over the network.
	enum TextType {GAME_TEXT, CHAT, COMMAND};
	
	private TextType type;
	public TextEntry(String author, String content, TextType type) {
		//Should probably place restrictions on length.
		this.content = content;
		this.author = author;
		this.type = type;
	}
	@Override
	public EntryType type() {
		return EntryType.TEXT;
	}
	public String getContent() {
		return content;
	}
	public String getAuthor() {
		return author;
	}
	public TextType identifyText() {
		return type;
	}
}
