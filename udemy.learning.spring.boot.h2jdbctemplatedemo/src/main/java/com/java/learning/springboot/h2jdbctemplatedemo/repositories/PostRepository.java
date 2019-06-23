package com.java.learning.springboot.h2jdbctemplatedemo.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.java.learning.springboot.h2jdbctemplatedemo.models.Post;

@Repository
public class PostRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*custom query - find the latest post to display in homepage*/
	public Post findFirstByOrderByPostedOnDesc() {
		String sql = "select * from post order by posted_on limit 1";
		
		//Map the row retrieved by the query
		RowMapper<Post> rowMapper = new RowMapper<Post>() {
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post post = new Post();
                post.setId( rs.getInt("id") );
    			post.setTitle( rs.getString("title") );
    			post.setTeaser( rs.getString("teaser") );
    			post.setBody( rs.getString("body") );
    			post.setSlug( rs.getString("slug") );
    			post.setPostedOn( rs.getDate("posted_on") );
    			post.setAuthor( rs.getInt("author_id") );
                return post;
			}
		};
		
		return jdbcTemplate.queryForObject(
				sql, 
				rowMapper
				);
	}

	
	/*custom query - find all posts order by latest*/
	public List<Post> findAllByOrderByPostedOnDesc(){
		
		String sql = "select * from post order by posted_on";
		
		return jdbcTemplate.query(sql, (rs,i) -> new Post(
			rs.getInt("id"),
			rs.getString("title"),
			rs.getString("teaser"),
			rs.getString("body"),
			rs.getString("slug"),
			rs.getDate("posted_on"),
			rs.getInt("author_id")
		));
		
	}

	/*custom query - find post based on slug*/
	public Post findBySlug(String slug) {
		
		String sql = "select * from post where slug = ? order by posted_on";
		
		//Map the row retrieved by the query
		RowMapper<Post> rowMapper = new RowMapper<Post>() {
			public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
		    	Post post = new Post();
		        post.setId( rs.getInt("id") );
		    	post.setTitle( rs.getString("title") );
		    	post.setTeaser( rs.getString("teaser") );
		    	post.setBody( rs.getString("body") );
		    	post.setSlug( rs.getString("slug") );
		    	post.setPostedOn( rs.getDate("posted_on") );
		    	post.setAuthor( rs.getInt("author_id") );
		        return post;
		    }
		};

		return jdbcTemplate.queryForObject(
				sql,
				new Object[]{slug},
				rowMapper
				);
	}
	
}
