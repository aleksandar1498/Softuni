package com.dxc.internship;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


final class SignatureTest {
	
	@ParameterizedTest(name = "{0} should return ''")
	@DisplayName("result should be '' on passed emtpy")
	@ValueSource(strings = {""," ","  ","   "})
	void shouldReturnEmptyIfEmptyStringIsPassed(String value) throws UnsupportedEncodingException {
		checkData(Signature::signData,value,"");		
	}
	
	@ParameterizedTest(name = "sign {0} should be equal {1}")
	@MethodSource
	@DisplayName("signData")
	void shouldReturnAKeyValuePairOfElaborated(String input,String expected) throws UnsupportedEncodingException {
		checkData(Signature::signData,input,expected);
	}
	
	static Stream<Arguments> shouldReturnAKeyValuePairOfElaborated() {
		return Stream.of(
				Arguments.arguments("",""),
				Arguments.arguments(" am","am am\n"),
				Arguments.arguments("My","My My\n"),
				Arguments.arguments("acdb prova","abcd acdb\naoprv prova\n")
				);
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
