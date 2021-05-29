package online.crazycoders.projects.notes;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class NoteController {

	@Autowired
	NoteRepo noteRepo;

	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");
	}

	@GetMapping("/api/v1/note/getAll/")
	public @ResponseBody List<Note> getAll() {
		return this.noteRepo.findAll();
	}

	@GetMapping("/api/v1/note/get/{id}/")
	public @ResponseBody ResponseEntity<Object> getById(@PathVariable("id") String id) {
		if (this.noteRepo.existsById(id)) {
			ResponseEntity<Object> res = new ResponseEntity(this.noteRepo.findById(id).get(), HttpStatus.OK);
			return res;
		} else {
			return new ResponseEntity("note not found", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/api/v1/note/add/")
	public @ResponseBody ResponseEntity<Object> add(@RequestBody Note note) {
		if (this.noteRepo.existsById(note.getId())) {
			this.noteRepo.save(note);
			ResponseEntity<Object> res = new ResponseEntity("Success", HttpStatus.OK);
			return res;
		} else {
			return new ResponseEntity("already exists", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/api/v1/note/update/{id}")
	public @ResponseBody ResponseEntity<Object> update(@RequestBody Note note, @PathVariable("id") String id) {
		if (this.noteRepo.existsById(id)) {
			this.noteRepo.save(note);
			ResponseEntity<Object> res = new ResponseEntity("Success", HttpStatus.OK);
			return res;
		} else {
			return new ResponseEntity("note not found", HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/api/v1/note/delete/{id}/")
	public @ResponseBody ResponseEntity<Object> deleteById(@PathVariable("id") String id) {
		if (this.noteRepo.existsById(id)) {
			this.noteRepo.deleteById(id);
			ResponseEntity<Object> res = new ResponseEntity("Success", HttpStatus.OK);
			return res;
		} else {
			return new ResponseEntity("note not found", HttpStatus.NOT_FOUND);
		}
	}
}
