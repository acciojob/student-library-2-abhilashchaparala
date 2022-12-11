package com.driver.services;

import com.driver.models.Author;
import com.driver.models.Book;
import com.driver.repositories.AuthorRepository;
import com.driver.repositories.BookRepository;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository2;
    @Autowired
    AuthorRepository authorRepository;

    public void createBook(Book book){
        Author author = authorRepository.findById(book.getAuthor().getId()).get();
        List<Book> books = author.getBooksWritten();
        books.add(book);
        author.setBooksWritten(books);
        authorRepository.save(author);
    }

    public List<Book> getBooks(String genre, boolean available, String author){
        List<Book> books = new ArrayList<>();
        if(author == null && genre != null && available){
            books = bookRepository2.findBooksByGenre(genre, available);
        }
        else if (!available && genre!=null && author != null){
            books = bookRepository2.findBooksByAuthor(author,available).stream().filter(x->x.getGenre().toString().equals(genre)).collect(Collectors.toList());
        }
         //find the elements of the list by yourself
        return books;
    }
}
