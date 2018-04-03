package org.linuxsogood.flume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.lang.NullPointerException;


public class LogDemo {

	protected static final Logger logger = LoggerFactory.getLogger(LogDemo.class);

	public static void main(String[] args) throws Exception {
        File f = new File("E://1.txt");
        BufferedReader bf = new BufferedReader(new FileReader(f));
        String str =null;
        str = bf.readLine();
		while (true) {
			logger.info(String.valueOf(str));

			Thread.sleep(2000);
		}}

}