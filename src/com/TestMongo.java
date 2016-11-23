
package com;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongo {

	public static void main(String[] args) {
		MongoClient client = mongoDBFindAll("114.215", 2, "", "", "");
		MongoDatabase database = client.getDatabase("lgh");
		MongoCollection<Document> collection = database.getCollection("collection");
		FindIterable<Document> iterable = collection.find();
		for (Document document : iterable) {
			System.out.println(document);
		}
		if (client != null) {
			client.close();
		}
	}

	private static MongoClient mongoDBFindAll(String ip, int port, String user, String db, String pwd) {
		MongoClient client = null;
		try {
			// IP port
			ServerAddress addr = new ServerAddress(ip, port);
			// 用户名 数据库 密码
			MongoCredential credential = MongoCredential.createCredential(user, db, pwd.toCharArray());
			client = new MongoClient(addr, Arrays.asList(credential));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}
}
