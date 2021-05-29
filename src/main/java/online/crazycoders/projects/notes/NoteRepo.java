package online.crazycoders.projects.notes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepo extends MongoRepository<Note, String> {

}
