package com.vinigomes.request;

import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPost {
	
	OkHttpClient client = new OkHttpClient().newBuilder()
			  .build();
	
	MediaType mediaType = MediaType.parse("application/json");
	
	
	String post(String url, String json) throws IOException {
		RequestBody body = RequestBody.create(json, mediaType);
		Request request = new Request.Builder()
				.url(url)
				.method("POST", body)
				.addHeader("Content-Type", "application/json")
				.build();
		try (Response response = client.newCall(request).execute()){
			return response.body().string();
		}
	}
	
	public static String comando(String comando) throws IOException {
		OkHttpPost example = new OkHttpPost();
		String json = "{\n    \"key\": \"YourKey\",\n"
				+ "  \"prompt\": \""+ comando + "\",\n"
				+ "   \"negative_prompt\": null,\n"
				+ "  \"width\": \"512\",\n"
				+ " \"height\": \"512\",\n"
				+ " \"samples\": \"1\",\n"
				+ " \"num_inference_steps\": \"20\",\n"
				+ " \"seed\": null,\n \"guidance_scale\": 7.5,\n"
				+ "\"safety_checker\":\"yes\",\n"
				+ "  \"multi_lingual\":\"no\",\n"
				+ "  \"panorama\":\"no\",\n"
				+ "  \"self_attention\":\"no\",\n"
				+ "  \"upscale\":\"no\",\n"
				+ " \"embeddings_model\":\"no\",\n"
				+ "   \"webhook\": null,\n"
				+ "  \"track_id\": null\n}";
		String response = example.post("https://stablediffusionapi.com/api/v3/text2img", json);
		JsonObject data = new Gson().fromJson(response, JsonObject.class);
		JsonArray names = data.get("output").getAsJsonArray();
		String url_completa;
		url_completa = names.toString().replace("[", "").replace("]", "").replace("\"", "");
		System.out.println(url_completa);
		return url_completa;
	}
	
	public static void main(String[] args) throws IOException {
		/*
		System.out.println("iniciado");
		OkHttpPost example = new OkHttpPost();
		String json = "{\n    \"key\": \"bAuJsJRjS77qLyKIn0fFuymVy4mzkpXn2l40azlyqs1a7tKalFxJ9mgQro7w\",\n  \"prompt\": \"ultra realistic close up portrait ((beautiful pale cyberpunk female with heavy black eyeliner))\",\n   \"negative_prompt\": null,\n  \"width\": \"512\",\n \"height\": \"512\",\n \"samples\": \"1\",\n \"num_inference_steps\": \"20\",\n \"seed\": null,\n \"guidance_scale\": 7.5,\n\"safety_checker\":\"yes\",\n  \"multi_lingual\":\"no\",\n  \"panorama\":\"no\",\n  \"self_attention\":\"no\",\n  \"upscale\":\"no\",\n \"embeddings_model\":\"no\",\n   \"webhook\": null,\n  \"track_id\": null\n}";
		String response = example.post("https://stablediffusionapi.com/api/v3/text2img", json);
		JsonObject data = new Gson().fromJson(response, JsonObject.class);
		JsonArray names = data.get("output").getAsJsonArray();
		System.out.println(data);
		String url_completa = names.toString().replace("[", "").replace("]", "").replace("\"", "");
		System.out.println(url_completa);
		*/
	}

}
