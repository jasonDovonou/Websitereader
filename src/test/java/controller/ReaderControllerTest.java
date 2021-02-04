package controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.reader.bean.Header;
import com.reader.service.HierarchyService;


public class ReaderControllerTest {

	@Autowired
	HierarchyService hierarchyService;	
	
	@Test
	final void testGetWebsiteHierachy() throws IOException {
		
		Mockito.when(hierarchyService.getWebsiteHierachy("https://"+Mockito.anyString()+".com")).thenReturn(
				Stream.of(new Header("h1", "Title test h1"), new Header("h2" , "Title test h2")).collect(Collectors.toList()));
		assertEquals(2,hierarchyService.getWebsiteHierachy("https://"+Mockito.anyString()+".com").size());
		
	}
	
}


