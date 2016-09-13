package com.awapi.bootcamp;



public interface BookRepository {

    Book getByIsbn(String isbn);

}