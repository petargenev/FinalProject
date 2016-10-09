package com.eshop.interfaces;

import java.sql.SQLException;
import java.util.Collection;

import javax.activity.InvalidActivityException;

import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Article;


public interface DAO {
	Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException, InvalidActivityException;
    
   

	
    
}
