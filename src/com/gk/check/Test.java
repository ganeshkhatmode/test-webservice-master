package com.gk.check;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.gk.dao.User;
import com.google.gson.Gson;

public class Test {
	
	public static final String SERVER_PATH = "http://localhost:8081";
	
	public static void main(String[] args) throws IOException {
		postUser();
		updateUser();
	}

	public static void postUser() throws IOException {
       try { 
        	CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(SERVER_PATH+"/user/add");
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
//            String json = "{\r\n" +
//                "  \"firstName\": \"Ram\",\r\n" +
//                "  \"lastName\": \"Jadhav\",\r\n" +
//                "  \"email\": \"ramesh1234@gmail.com\",\r\n" +
//                "  \"createdAt\": \"2018-09-11T11:19:56.000+0000\",\r\n" +
//                "  \"createdBy\": \"Ramesh\",\r\n" +
//                "  \"updatedAt\": \"2018-09-11T11:26:31.000+0000\",\r\n" +
//                "  \"updatedby\": \"Ramesh\"\r\n" +
//                "}";
            User user = new User();
            user.setDepartmentId("45");
            user.setDepartmentName("Computer");
            user.setDisplayName("Ganesh Patil");
            user.setEmail("Ganesh.Patil9096@yahoo.in");
            user.setFirstName("Ganesh");
            user.setLastName("Patil");
            user.setTelephoneNumber("9096888722");
            user.setUserLogin("GaNesh");
            Gson gson = new Gson();
            StringEntity stringEntity = new StringEntity(gson.toJson(user));
            httpPost.setEntity(stringEntity);

            System.out.println("Executing request " + httpPost.getRequestLine());

            // Create a custom response handler
            ResponseHandler <String> responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);
            System.out.println("------------------------------------------");
            // JSON TO OBJECT CONVERSION
//            User convertJsonToUser = gson.fromJson(responseBody, User.class);
//            System.out.println(convertJsonToUser.toString());
        }catch (Exception e) {
			e.printStackTrace(System.err);
		}
       
    }
	
	public static void updateUser() {
	       try { 
	        	CloseableHttpClient httpclient = HttpClients.createDefault();
	            HttpPut httpPost = new HttpPut(SERVER_PATH+"/user/update/userLoginValueHere");
	            httpPost.setHeader("Accept", "application/json");
	            httpPost.setHeader("Content-type", "application/json");
	            User user = new User();
	            user.setDepartmentId("45");
	            user.setDepartmentName("Computer Science");
	            user.setDisplayName("Ganesh Khatmode-Patil");
	            user.setEmail("Ganesh.Patil9096@yahoo.in");
	            user.setFirstName("Ganesh");
	            user.setLastName("Patil");
	            user.setTelephoneNumber("9096888722");
	            user.setUserLogin("GaNesh");
	            Gson gson = new Gson();
	            StringEntity stringEntity = new StringEntity(gson.toJson(user));
	            httpPost.setEntity(stringEntity);

	            System.out.println("\nExecuting request " + httpPost.getRequestLine());

	            // Create a custom response handler
	            ResponseHandler <String> responseHandler = response -> {
	                int status = response.getStatusLine().getStatusCode();
	                if (status >= 200 && status < 300) {
	                    HttpEntity entity = response.getEntity();
	                    return entity != null ? EntityUtils.toString(entity) : null;
	                } else {
	                    throw new ClientProtocolException("Unexpected response status: " + status);
	                }
	            };
	            String responseBody = httpclient.execute(httpPost, responseHandler);
	            System.out.println("----------------------------------------");
	            System.out.println(responseBody);
	            System.out.println("------------------------------------------");
	            // JSON TO OBJECT CONVERSION
//	            User convertJsonToUser = gson.fromJson(responseBody, User.class);
//	            System.out.println(convertJsonToUser.toString());
	        }catch (Exception e) {
				e.printStackTrace(System.err);
			}
	}
}
