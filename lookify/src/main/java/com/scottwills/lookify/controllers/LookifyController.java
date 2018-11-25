package com.scottwills.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.scottwills.lookify.models.Song;
import com.scottwills.lookify.services.SongService;


@Controller
@RequestMapping("/")
public class LookifyController {
	private final SongService songService;

    public LookifyController(SongService songService){
        this.songService = songService;
    }
    
	@RequestMapping("")
	public String index(){
		return "index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dash(Model model, @ModelAttribute("song") Song song) {
		List<Song> songs = songService.getAllSongs();
		model.addAttribute("songs",songs);
		return "dash.jsp";
	}
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist) {
		return "redirect:/search/"+artist;
	}
	@RequestMapping("/search/{artist}")
	public String showSearch(Model model, @PathVariable("artist") String artist) {
		List<Song> songs = songService.getSearchSongs(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	@RequestMapping("/songs/new")
	public String showCreateForm(Model model, @ModelAttribute("song") Song song) {
		return "add.jsp";
	}
	@PostMapping("/songs/new")
	public String createLang(@Valid @ModelAttribute("song") Song song, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/songs/new";
		} else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}
	@RequestMapping("/songs/{id}")
	public String showSong(Model model, @PathVariable("id") Long id) {
		Song song = (Song) songService.getSong(id);
		model.addAttribute("song", song);
		return "song.jsp";
	}
	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	@RequestMapping("/songs/delete/{artist}/{id}")
	public String deleteSongFromSearch(@PathVariable("artist") String artist, @PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/search/"+artist;
	}
	@RequestMapping("/songs/top")
	public String showTopSongs(Model model) {
		List<Song> songs = songService.getTopSongs();
		model.addAttribute("songs", songs);
		return "topSongs.jsp";
	}
}
