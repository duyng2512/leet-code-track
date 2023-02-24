package org.dng.code.interview;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;

/**
 * @author duyntc 01/2023
 */
public class MainTest {

static public Map<String, Map<Integer, Double>> map = new HashMap<>();

static public String callAPI(String url) throws IOException {
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	
	int responseCode = con.getResponseCode();
	StringBuilder response = new StringBuilder();
	if (responseCode == HttpURLConnection.HTTP_OK) {
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	}
	return response.toString();
}

static public void getAllData(String city, List<String> names, List<Double> rate, List<Integer> cost) throws IOException {
	String urlCall = String.format("https://jsonmock.hackerrank.com/api/food_outlets?city=%s", city);
	String firstCall = callAPI(urlCall);
	int totalPages = new JsonParser().parse(firstCall).getAsJsonObject().get("total_pages").getAsInt();
	
	for (int i = 1; i <= totalPages; i++) {
		String url = String.format("https://jsonmock.hackerrank.com/api/food_outlets?city=%s&page=%d", city, i);
		String response = callAPI(url);
		
		JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();
		JsonArray array = jsonObject.getAsJsonArray("data");
		
		for (int j = 0; j < array.size(); j++) {
			JsonElement element = array.get(j);
			int resCost = element.getAsJsonObject().get("estimated_cost").getAsInt();
			String resRestaurant = element.getAsJsonObject().get("name").getAsString();
			double resRate = element.getAsJsonObject().get("user_rating").getAsJsonObject().get("average_rating").getAsDouble();
			
			names.add(resRestaurant);
			cost.add(resCost);
			rate.add(resRate);
		}
	}
}

static public String initializeData() throws IOException {
	
	List<String> resultName = new ArrayList<>();
	List<Integer> resultCost = new ArrayList<>();
	List<Double> resultRate = new ArrayList<>();
	
	getAllData("Seattle", resultName, resultRate, resultCost);
	
	int N = resultName.size();
	int checkCost = 0;
	String checkRes = "";
	double checkRate = 0;
	
	int index = 0;
	for (int i = 0; i < N; i++) {
		if (resultRate.get(i) > checkRate && resultCost.get(i) <= 0) {
			index = i;
		}
	}
	
	int finalResult = index;
	for (int i = 0; i < N; i++) {
		if (Objects.equals(resultRate.get(i), resultRate.get(finalResult))) {
			if (resultCost.get(i) < resultCost.get(finalResult)) {
				finalResult = i;
			}
		}
	}
	
	System.out.println(resultName);
	System.out.println(resultCost);
	System.out.println(resultRate);
	
	return checkRes;
}

public static int getExpressionSums(String num) {
	// Write your code here
	List<String> ans = new ArrayList<>();
	
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < num.length() * 2 + 1; i++) {
		builder.append(" ");
	}
	
	String output = builder.toString();
	
	backtrack(num, 0, output, 0, ans);
	
	
	int result = 0;
	long[] resultArr = new long[ans.size()];
	for (int i = 0; i < ans.size(); i++) {
		long currentResult = 0;
		int startIndex = 0;
		for (int j = 0; j < ans.get(i).length(); j++) {
			char currentChar = ans.get(i).charAt(j);
			
			if (currentChar == ' ') {
				break;
			}
			
			if (currentChar == '+') {
				currentResult += Long.parseLong(ans.get(i).substring(startIndex, j));
				startIndex = j + 1;
			}
		}
		
		resultArr[i] = currentResult;
	}
	
	long NUM = (long) (Math.pow(10, 9) + 7);
	
	for (int i = 0; i < resultArr.length; i++) {
		result = (int) ((result + resultArr[i]) % NUM);
	}

//	System.out.println(ans);
//	System.out.println(Arrays.toString(resultArr));
	return result;
}

private static void backtrack(String input, int index, String output, int outputLength, List<String> result) {
	if (index == input.length()) {
		result.add(output);
		return;
	}
	
	StringBuilder builder = new StringBuilder(output);
	builder.setCharAt(outputLength, input.charAt(index));
	builder.setCharAt(outputLength + 1, '+');
	output = builder.toString();
	
	backtrack(input, index + 1, output, outputLength + 2, result);
	
	if (input.length() != index + 1) {
		backtrack(input, index + 1, output, outputLength + 1, result);
	}
}

public static int point(List<Integer> nums, int x, int y, int index) {
	int total = 0;
	for (int i = 0; i < nums.size(); i++) {
		if (i == index) {
			total += nums.get(i) - x;
		} else {
			total += nums.get(i) - y;
		}
	}
	return total;
}

public static boolean isDone(List<Integer> nums) {
	boolean done = true;
	for (Integer num : nums) {
		if (num > 0) {
			done = false;
			break;
		}
	}
	return done;
}

public static int getMinimumOperations(List<Integer> executionTime, int x, int y) {
	return 0;
}

public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
	int res = getExpressionSums("123");
	System.out.println(res);
}

}
