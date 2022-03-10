package kr.ac.kopo.bookstore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.bookstore.model.Book;

@Repository
public class BookDaoImpl implements BookDao{

	List<Book> list;
	
	public BookDaoImpl() {
		list = new ArrayList<Book>();
		
		Book book = new Book();
		book.setBookid(10);
		book.setBookname("엑셀완성");
		book.setPublisher("한빛미디어");
		book.setPrice(2000);
		
		list.add(book);
	
	}
	
	@Override
	public List<Book> list() {
		return list;
	}

	@Override
	public void add(Book item) {
		list.add(item);
	}

	@Override
	public Book item(int bookid) {
		for(Book item : list) {
			if(item.getBookid() == bookid)
				return item;
		}
		return null;
	}

	@Override
	public void update(Book item) {
		for(Book book : list) {
			if(item.getBookid() == book.getBookid()) {
				book.setBookname(item.getBookname());
				book.setPublisher(item.getPublisher());
				book.setPrice(item.getPrice());
			
				return;
			}
		}
		
	}

	@Override
	public void delete(int bookid) {
		for(Book item : list) {
			if(item.getBookid() == bookid) {
				list.remove(item);
				
				return;
			}
			
		}
		
	}
	
	
}
