package com.dxc.internship;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SquashTest {

	@Test
	@DisplayName("squashData function with input 'My\n' ")
	 void squashDatashouldReturnAKeyValuePairOfElaborated() throws UnsupportedEncodingException {
		StringBuilder input = new StringBuilder();
		input.append("am ma\n");
		input.append("am am\n");
		input.append("acs sac\n");
		checkData(Squash::squash,input.toString(),"ma am\nsac");
	}

	private final static void checkData(BiConsumer<ByteArrayInputStream,PrintStream> func,final String INPUT,final String EXPECTED_OUTPUT) throws UnsupportedEncodingException {
		//final String EXPECTED = "My My\n";
		ByteArrayInputStream in = new ByteArrayInputStream(INPUT.getBytes());
		
		// Reassign the standard input stream
		System.setIn(in);
		
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		PrintStream ps = new PrintStream(baos,true,"UTF-8");
		
		func.accept(in, ps);
		
		String actual = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		assertEquals(actual,EXPECTED_OUTPUT);
		
	}
}
