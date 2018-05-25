package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Model {

	private List<String> anatomy = new ArrayList<String>();
	private List<String> clothing = new ArrayList<String>();
	private List<String> action = new ArrayList<String>();

	public void populateLists() {

		InputStream fileIsAnatomy = Model.class.getResourceAsStream("Anatomy.txt");
		InputStream fileIsClothing = Model.class.getResourceAsStream("Clothing.txt");
		InputStream fileIsAction = Model.class.getResourceAsStream("Action.txt");

		readFile(fileIsAnatomy, anatomy);
		readFile(fileIsClothing, clothing);
		readFile(fileIsAction, action);
	}

	private void readFile(InputStream fileName, List<String> array) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(fileName))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				array.add(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> randomTags() {
		List<String> result = new ArrayList<String>();
		int lines = anatomy.size();
		int randomNum = ThreadLocalRandom.current().nextInt(0, lines);
		result.add(anatomy.get(randomNum));

		lines = clothing.size();
		randomNum = ThreadLocalRandom.current().nextInt(0, lines);
		result.add(clothing.get(randomNum));

		lines = action.size();
		randomNum = ThreadLocalRandom.current().nextInt(0, lines);
		result.add(action.get(randomNum));
		return result;

	}

	public Model() {
		this.populateLists();
	}

}
