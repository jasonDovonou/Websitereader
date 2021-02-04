package controller;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.reader.bean.Header;
import com.reader.service.HierarchyService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Jsoup.class)
public class ReaderControllerTest {

	 
	private final HierarchyService hierarchyService = new HierarchyService();	
	private final String url = "https://www.opslycloud.com/";
	private final String html = "<html><head><title>First parse</title></head>"
			  + "<body><p>Parsed HTML into a doc.</p></body></html>";
	private final List<Header> doc = Stream.of(new Header("h1", "Title h1 test"), new Header("h2", "Title h2 test")).collect(Collectors.toList()) ;

	  @Test
	  void test() throws IOException {
	    try (MockedStatic<Jsoup> mockedJsoup = Mockito.mockStatic(Jsoup.class)) {
	      mockedJsoup.when( () -> Jsoup.connect(Mockito.anyString()).get()).thenReturn(doc);
	      List<Header> headers = hierarchyService.getWebsiteHierachy(url);
	      assertEquals(2, headers.size());
	    }
	  }
	
}


