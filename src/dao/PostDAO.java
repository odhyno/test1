package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.PostBean;
import entity.Post;
import utility.ConnectionDB;

public class PostDAO {
	
	static Connection con;
	
	private PostDAO() {
		//Default Constructor
	}
	

	public static void insertPost(Post post) {
		
		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String sql = "INSERT INTO post (titolo,autore,descrizione,nomeSample,argomento,risolto) "
						+ "VALUES ('" + post.getEntityTitolo() + "','" + post.getEntityAutore() + "','"
						+ post.getEntityDescrizione() + "','" + post.getEntityNomeSample() + "','" + post.getEntityArgomento() + "','" 
						+ post.getEntityRisolto() + "');";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public static List<Post> getPostList() {	
		
		List<Post> postList = new ArrayList<>();
		
		ResultSet tempRs;
				
		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String sql = "SELECT * FROM post"; 
						
				tempRs = tempSt.executeQuery(sql);
						
				while(tempRs.next()) {
					
					Post post = new Post();
					post.setEntityId(tempRs.getInt(1));
					post.setEntityTitolo(tempRs.getString(2));
					post.setEntityAutore(tempRs.getString(3));
					post.setEntityDescrizione(tempRs.getString(4));
					post.setEntityNomeSample(tempRs.getString(5));
					post.setEntityArgomento(tempRs.getString(6));
					post.setEntityRisolto(tempRs.getString(7));
							
					postList.add(post);
				}
			}			
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
				
		return postList;
	}

	public static void deletePost(int id) {
		
		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String sql = "DELETE FROM post WHERE idPost = '" + id + "'";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void modifyPost( PostBean postBean) {
		
		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String sql = "UPDATE post SET titolo = '" + postBean.getTitolo() + "', "
						+ "descrizione = '" + postBean.getDescrizione() +  "' WHERE idPost = '"
						+ postBean.getId() + "'";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}		
	}
	
	public static void modifyTopicPost( PostBean postBean) {
		
		try {
			con = ConnectionDB.dbConn();
			try(Statement tempSt = con.createStatement()){
				String sql = "UPDATE post SET titolo = '" + postBean.getTitolo() + "', "
						+ "descrizione = '" + postBean.getDescrizione() + "', "+  "argomento = '" + postBean.getArgomento() + "' WHERE idPost = '" + postBean.getId() + "'";
				tempSt.executeQuery(sql);
			}
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}		
	}
}
