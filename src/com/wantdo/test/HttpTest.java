package com.wantdo.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.wantdo.utils.CustomerHttpClient;

public class HttpTest {

	@Test
	public void testget() throws IOException {
		Set<String> set=new HashSet<String>();
		set.add("hi");
		CustomerHttpClient.get(new File("xx.pdf"),
				"http://www.baidu.com/link?url=ZPwQNk-6PlV74bszqisqlgi1rRTg1h6RDsTsAZoHPEdPh5NMhDlxIdOnWbQA7JM6-TvhfL1lm9vxxi2UjsEHlNZaa1GLFfjWDotWcbWHiMq");
	}

}
