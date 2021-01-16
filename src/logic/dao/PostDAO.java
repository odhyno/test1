package logic.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logic.bean.PostBean;
import logic.entity.Post;
import logic.utils.ConnectionDB;

public class PostDAO {
	
	static Connection con;
	

	public static void insertPost(Post post) {
		
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "INSERT INTO post (titolo,autore,descrizione,nomeSample,argomento,risolto) "
					+ "VALUES ('" + post.getTitolo() + "','" + post.getAutore() + "','"
					+ post.getDescrizione() + "','" + post.getNomeSample() + "','" + post.getArgomento() + "','" 
					+ post.getRisolto() + "')";
			tempSt.executeQuery(sql);
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public static List<Post> getPostList() {	
		
		List<Post> postList = new ArrayList<Post>();
		
		ResultSet tempRs;
				
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "SELECT * FROM post"; 
					
			tempRs = tempSt.executeQuery(sql);
					
			while(tempRs.next()) {
				
				Post post = new Post();
				post.setId(tempRs.getInt(1));
				post.setTitolo(tempRs.getString(2));
				post.setAutore(tempRs.getString(3));
				post.setDescrizione(tempRs.getString(4));
				post.setNomeSample(tempRs.getString(5));
				post.setArgomento(tempRs.getString(6));
				post.setRisolto(tempRs.getString(7));
						
				postList.add(post);
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
			Statement tempSt = con.createStatement();
			String sql = "DELETE FROM post WHERE idPost = '" + id + "'";
			tempSt.executeQuery(sql);
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void modifyPost(int id, PostBean postBean) {
		
		try {
			con = ConnectionDB.dbConn();
			Statement tempSt = con.createStatement();
			String sql = "UPDATE post SET titolo = '" + postBean.getTitolo() + "', "
					+ "descrizione = '" + postBean.getDescrizione() +  "' WHERE idPost = '" + id + "'";
			tempSt.executeQuery(sql);
			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}		
	}
}
