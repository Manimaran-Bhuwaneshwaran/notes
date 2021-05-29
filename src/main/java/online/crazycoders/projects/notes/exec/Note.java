package online.crazycoders.projects.notes.exec;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("note")
public class Note {

	@Id
	private String id;
	private String title;
	private String description;
	private String addedDate;
	private String modifiedDate;
	private String author;
	private boolean isActive;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddedDate() {
		return this.addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Note(String id, String title, String description, String addedDate, String modifiedDate, String author,
			boolean isActive) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.addedDate = addedDate;
		this.modifiedDate = modifiedDate;
		this.author = author;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Note [id=" + this.id + ", title=" + this.title + ", description=" + this.description + ", addedDate="
				+ this.addedDate + ", modifiedDate=" + this.modifiedDate + ", author=" + this.author + ", isActive="
				+ this.isActive + "]";
	}

	public Note() {
		super();
	}

}
