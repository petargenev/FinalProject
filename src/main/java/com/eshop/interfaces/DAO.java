package com.eshop.interfaces;

import java.sql.SQLException;
import java.util.Collection;

import javax.activity.InvalidActivityException;

import com.eshop.exceptions.ArticleException;
import com.eshop.exceptions.InvalidInputException;
import com.eshop.models.Article;
import com.eshop.models.Computer;

public interface DAO {

	Article getArticleById(int articleId) throws SQLException, InvalidInputException;

	Collection<Article> getArticleByLabel(String articlelabel) throws SQLException, InvalidInputException;

	Collection<Article> showAll() throws SQLException, InvalidInputException, InvalidInputException, InvalidActivityException;

	void deleteArticleById(int id) throws SQLException;

	void insertArticle(Article article) throws ArticleException;

}