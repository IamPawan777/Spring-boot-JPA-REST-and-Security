package com.project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.Entity.Books;

@Service
public class DemoService {
	private static List<Books> list = new ArrayList<>();
	
	static {
		list.add(new Books(1, "Java Complete Reference", "XYZ"));
		list.add(new Books(10, "CPP Coding", "PQR"));
		list.add(new Books(100, "C sharp", "ABC"));
		list.add(new Books(99, "Rich Dad", "Jams"));
		list.add(new Books(11, "Harry potter", "hry"));
	}
	
	
	
	// 1. get all data.......
	public List<Books> getAllBooks() {
		return list;
	}
	
	// 2.get single data...
	public Books getBookById(int id) {
		Books book = null;
//		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		// or........
		for (Books e : list) {
		    if (e.getId() == id) {
		        book = e;
		        break;  // exit loop after finding first match
		    }
		}
		if (book == null) {
		    throw new NoSuchElementException();  // to match the behavior of get()
		}
		return book;
	}
	
	
	// 3.add data.......
	public Books addBook(Books b) {
		list.add(b);
		return b;
	}
	
	
	
	// 4. delete data......
	public void deleteBookById(int bid) {
		list = list.stream().filter(b->b.getId()!=bid).collect(Collectors.toList());		// create new list (id is match then skip that)
	}
	
	
	// 5. update data.........
	public void updataBook(Books book, int id) {
		list = list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
