package MutaSketchGame;
//An entry representing a sentence.
public class TextEntry implements Entry {
	private String content;
	private String author;
	public TextEntry(String author, String content) {
		//Should probably place restrictions on length.
		this.content = content;
		this.author = author;
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
}
