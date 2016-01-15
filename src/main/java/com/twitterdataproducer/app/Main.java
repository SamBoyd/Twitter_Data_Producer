package com.twitterdataproducer.app;

import twitter4j.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.io.File;


public class Main
{
	public static void main(String[] args) {

		String TWITTER_OUTPUT_FILE = System.getenv("TWITTER_DATA_OUTPUT_PATH");

		System.out.println("Writing to: " + TWITTER_OUTPUT_FILE);

		Twitter twitter = new TwitterFactory().getInstance();
		try {
			// UK: 23424975
			// London: 44418
			// Paris: 615702S
//			String path = "/Users/Sam/logs/twitter_data_producer/data_output.txt";

			File file = new File(TWITTER_OUTPUT_FILE);

//			if (!file.exists()) {
//				file.createNewFile();
//			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bfw = new BufferedWriter(fw);

//			Trends trends = twitter.getPlaceTrends(44418);
//			System.out.println("Showing location trends for woeid:" + 44418);
//			System.out.println("As of : " + trends.getAsOf());
//			for (Trend trend : trends.getTrends()) {
//				System.out.println(" " + trend.getName());
			//}
			//System.out.println("done.");

			//search
			QueryResult result = twitter.search(new Query("corbyn"));
			List<Status> tweets = result.getTweets();
			for (Status tweet : tweets) {
				bfw.write(tweet.toString() + "\n");
				System.out.println(tweet.toString() + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
