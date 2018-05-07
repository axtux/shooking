package be.ac.ulb.infof307.g10.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import be.ac.ulb.infof307.g10.models.Product;

public class Parser {

	public static void main(String[] args) throws IOException {
		List<Product> products = new ArrayList<Product>();
		List<List<String>> data = parseResource("items");
		Map<String, Integer> stats = new HashMap<>();
		
		int old;
		String name;
		String size;
		String[] parts;
		for(List<String> list: data) {
			if(list.size() != 26) {
				continue;
			}
			name = list.get(2);
			size = list.get(3);
			parts = size.split(" ");
			if (parts.length != 2) {
				continue;
			}
			old = stats.getOrDefault(parts[1], 0);
			stats.put(parts[1], old+1);
			
			for(String s: list) {
				//System.out.print(s+"|");
			}
			//System.out.println("");
		}
		
		System.out.println(stats);
	}

	public static List<List<String>> parseResource(String name) throws IOException {
		List<List<String>> data = new ArrayList<List<String>>();
		
		InputStream in = Parser.class.getResourceAsStream("/"+name+".csv");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		String line = reader.readLine();
		while(line != null) {
			data.add(parseLine(line.toCharArray()));
			line = reader.readLine();
		}
		
		return data;
	}

	public static List<String> parseLine(char[] s) throws IOException {
		List<String> line = new ArrayList<String>();
		StringBuffer buff = new StringBuffer();
		
		boolean inquotes = false;
		boolean started = false;
		
		for(char c: s) {
			if (inquotes) {
				started = true;
				if (c == '"') {
					inquotes = false;
				} else {
					buff.append(c);
				}
			} else {
				if (c == '"') {
					inquotes = true;
					if (started) {
						// if this is the second quote in a value, add a quote
						// this is for the double quote in the middle of a value
						buff.append('"');
					}
				} else if (c == ',') {
					line.add(buff.toString());
					buff = new StringBuffer();
					started = false;
				} else {
					buff.append(c);
				}
			}
		}
		if(buff.length() > 0) {
			line.add(buff.toString());
		}
		return line;
	}
}
