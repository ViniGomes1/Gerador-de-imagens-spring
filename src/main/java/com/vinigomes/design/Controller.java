package com.vinigomes.design;

import java.io.IOException;

import com.vinigomes.request.OkHttpPost;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
	
	@FXML
	private ImageView myImageView;
	@FXML
	private TextField myTextField;
	
	
	String imageSource;
	
	//
	
	@FXML
	public void pressionado(ActionEvent e) throws IOException {
		//imageSource = OkHttpPost.comando(myTextField.getText());
		System.out.println(myTextField.getText());
		imageSource = OkHttpPost.comando(myTextField.getText());
		Image myImage = new Image(imageSource);
		myImageView.setImage(myImage);
		System.out.println("Ain");
	}
	
}
