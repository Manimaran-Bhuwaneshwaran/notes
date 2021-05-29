package online.crazycoders.projects.notes.exec;

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
	public Note getById(@PathVariable("id") String id) {
		if (this.noteRepo.existsById(id)) {
			return this.noteRepo.findById(id).get();
		} 
		else {
			return new Note();
		}
	}

	@PostMapping("/api/v1/note/add/")
	public @ResponseBody String add(@RequestBody Note note) {
		if (this.noteRepo.existsById(note.getId())) {
			this.noteRepo.save(note);
			return "success";
		}else {
			return "failed";
		}
	}

	@PostMapping("/api/v1/note/update/{id}")
	public String update(@RequestBody Note note, @PathVariable("id") String id) {
		if (this.noteRepo.existsById(id)) {
			this.noteRepo.save(note);
			return "success";
		} else {
			return "failed";
		}
	}

	@DeleteMapping("/api/v1/note/delete/{id}/")
	public String deleteById(@PathVariable("id") String id) {
		if (this.noteRepo.existsById(id)) {
			this.noteRepo.deleteById(id);
			return "success";
		}  else {
			return "failed";
		}
	}
}
