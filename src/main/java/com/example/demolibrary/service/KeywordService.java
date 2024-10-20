package com.example.demolibrary.service;

import com.example.demolibrary.entity.Keyword;

public interface KeywordService {
     Keyword save(String word,int bookId);

     void deleteById(int id);
}
