package MutaSketchGame;

import java.awt.image.RenderedImage;
//An entry representing a sketch. 
public class PictureEntry implements Entry{
	private RenderedImage content;
	private String author;
	public PictureEntry(String author, RenderedImage content) {
		//Should probably make restrictions on the image size.
		this.content = content;
		this.author = author;
	}
	@Override
	public EntryType type() {
		return EntryType.PICTURE;
	}
	public RenderedImage getContent() {
		return content;
	}
	public String getAuthor() {
		return author;
	}
}
