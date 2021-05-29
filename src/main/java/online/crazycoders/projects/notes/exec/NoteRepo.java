package online.crazycoders.projects.notes.exec;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepo extends MongoRepository<Note, String> {

}
