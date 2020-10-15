package com.blank.study.third.guava.code;

import com.google.common.base.Joiner;
import com.google.common.io.Files;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Guava Collection Files 文件IO处理
 * @author wudc
 * @date 2020/10/15 14:07
 */
public class GuavaFiles {

	private final static String SOURCH_FILE_PATH = "E:\\WuDiCong\\my-git-project\\java-study-note\\src\\main\\resources\\files\\myFile";
	private final static String TARGET_FILE_PATH = "E:\\WuDiCong\\my-git-project\\java-study-note\\src\\main\\resources\\files\\myFile-copy";

	public static void main(String[] args) throws IOException {
		GuavaFiles.moveOrTouch(1);
	}

	/**
	 * Files-copy
	 * 复制文件
	 * 1.文件->文件
	 * 2.文件->输出流
	 */
	public static void copy(int type) throws IOException {
		File sourceFile = new File(SOURCH_FILE_PATH);
		File targetFile = new File(TARGET_FILE_PATH);
		OutputStream outputStream = new FileOutputStream(targetFile);
		switch (type) {
			case 1:
				// File->File
				// 这种实现,其实可以有两种方式
				// （1）Files.copy(sourceFile, targetFile)
				// （2）Files.asByteSource(sourceFile).copyTo(Files.asByteSink(targetFile))
				// 第（1）种实现的方式其实是第（2）种
				// 追溯source code发现,最终还是IO的InputStream和OutputStream，最后通过ByteStream写
				Files.copy(sourceFile, targetFile);
				break;
			case 2:
				// File->OutputStream
				// 这个更简单粗暴, 只是把目标File变成OutputStream而已, 后续完全一毛一样
				Files.copy(sourceFile, outputStream);
				break;
			default:
				break;
		}
	}

	/**
	 * Files-read
	 * 读取文件内容
	 */
	public static void read(int type) throws IOException {
		File sourceFile = new File(SOURCH_FILE_PATH);
		switch (type) {
			case 1:
				// readLines
				// 这里用charSource,最终调用的是charStream
				List<String> lines = Files.readLines(sourceFile, Charset.forName("UTF-8"));
				String lineContent = Joiner.on("\n").join(lines);
				System.out.println(lineContent);
				break;
			case 2:
				// newReader
				// 这里就直接用JDK8 InputStreamReader封装一层BufferedReader
				BufferedReader reader = Files.newReader(sourceFile, Charset.forName("UTF-8"));
				List<String> readerList = reader.lines().collect(Collectors.toList());
				String readerContent = Joiner.on("\n").join(readerList);
				System.out.println(readerContent);
				break;
			default:
				break;
		}
	}

	/**
	 * Files-move and touch
	 * 文件移动或者更新
	 */
	public static void moveOrTouch(int type) throws IOException {
		File sourceFile = new File(SOURCH_FILE_PATH);
		File targetFile = new File(TARGET_FILE_PATH);
		switch (type) {
			case 1:
				// 移动
				// 重命名sourceFileName
				// 复制过去
				// 删除sourceFile
				Files.move(sourceFile, targetFile);
				break;
			case 2:
				// 更新
				Files.touch(sourceFile);
				break;
			default:
				break;
		}
	}

	/**
	 * TODO 这个后续完善 没看懂
	 * Files-map 相关
	 */
	public static void map(int type) throws IOException {
		File sourceFile = new File(SOURCH_FILE_PATH);
		MappedByteBuffer map = Files.map(sourceFile);

	}

	/**
	 * 移除文件
	 */
	public static void delete() {
		File targetFile = new File(TARGET_FILE_PATH);
		if (targetFile.exists()) {
			targetFile.delete();
		}
	}
}
