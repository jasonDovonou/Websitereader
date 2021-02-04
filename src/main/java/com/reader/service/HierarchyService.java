package com.reader.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.reader.bean.Header;

@Service
public class HierarchyService {
	
	public List<Header> getWebsiteHierachy(String url) throws IOException{
		List<Header> headers =new ArrayList<>();
		Document doc = Jsoup.connect(url).get();  
		Elements headerTags = doc.select("h1, h2, h3, h4, h5, h6");
		headerTags.stream().forEach(t -> {
			headers.add(new Header(t.tagName(),t.text()));
		});	
		return headers;
	}

}
