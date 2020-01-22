package logic.utils;

import logic.interfaces.Post;

public class Sample implements Post {
	
	private String name;
	private Float duration;
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Float getDuration() {
		return duration;
	}


	public void setDuration(Float duration) {
		this.duration = duration;
	}


	public Sample() {

	}


	@Override
	public void createPost() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modifyPost() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void removePost() {
		// TODO Auto-generated method stub
		
	}

}
