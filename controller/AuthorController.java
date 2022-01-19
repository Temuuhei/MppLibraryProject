package MppLibraryProject.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import MppLibraryProject.business.Author;
import MppLibraryProject.config.Config;
import MppLibraryProject.config.Config.StorageType;

public class AuthorController {
	private static HashMap<String, Author> authors;

	public AuthorController() {
		authors = readAuthorMap();
	}

	@SuppressWarnings("unchecked")
	private HashMap<String, Author> readAuthorMap() {
		Object object = Config.readFromStorage(Config.StorageType.AUTHORS);
		return object != null ? (HashMap<String, Author>) object : new HashMap<String, Author>();
	}

	public Author getAuthor(String authorId) {
		if (authors.containsKey(authorId)) {
			return authors.get(authorId);
		}
		return null;
	}

	public Collection<Author> getAuthorList() {
		return getAuthorsMap();
	}

	private Collection<Author> getAuthorsMap() {
		Object object = Config.readFromStorage(Config.StorageType.AUTHORS);
		return object != null ? ((HashMap<String, Author>) object).values() : new ArrayList<Author>();
	}

	public void createAuthor(Author author) {
		String memberId = author.getUserId();
		authors.put(memberId, author);
		Config.saveToStorage(StorageType.AUTHORS, authors);
	}

	public void updateAuthor(Author author) {
		String authorId = author.getUserId();
		if (authors.containsKey(authorId)) {
			authors.put(authorId, author);
			Config.saveToStorage(StorageType.AUTHORS, authors);
		}
	}

	public void deleteAuthor(String authorId) {
		if (authors.containsKey(authorId)) {
			authors.remove(authorId);
			Config.saveToStorage(StorageType.AUTHORS, authors);
		}
	}

	public void loadAuthorMap(List<Author> authorList) {
		HashMap<String, Author> authors = new HashMap<String, Author>();
		authorList.forEach(author -> authors.put(author.getUserId(), author));
		Config.saveToStorage(StorageType.AUTHORS, authors);
	}
}
