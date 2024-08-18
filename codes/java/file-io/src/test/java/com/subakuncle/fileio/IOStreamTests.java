package com.subakuncle.fileio;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IOStreamTests {

    private static final ClassPathResource resource = new ClassPathResource("text/example.txt");
    private static final Logger log = LoggerFactory.getLogger(IOStreamTests.class);

    @Test
    @DisplayName("InputStream만 사용했을 시 한글 꺠짐")
    @Order(1)
    void testInputStream() throws IOException {

        // given
        InputStream inputStream = resource.getInputStream();
        int data;

        // when & then
        while((data = inputStream.read()) != -1) { // 파일을 다 읽으면 -1 반환, read는 바이트 단위로 읽음. byte[]를 인자로 넣으면 길이만큼 읽음.
            System.out.print((char) data);
        }

        // finally
        inputStream.close();

        /*
        * 1byte는 범위가 0~255까지이며 알파벳 대,소문자의 아스키드 값은 다 저 범위 안에 들어간다.
        * 그러나 한글을 나타내려면 2byte가 필요하므로 바이트 기반인 Stream에서는 깨지는것이다.
        * 따라서 한글 file을 읽고쓰려면 캐릭터 기반 스트림인 Reader나 Writer을 사용해야한다.
        * */

    }

    @Test
    @DisplayName("OutputStream 사용 방법 & 속도 측정")
    @Order(3)
    void testOutputStream() throws IOException {

        // given
        long start = System.nanoTime();

        InputStream inputStream = resource.getInputStream();
        // 새 파일을 위한 OutputStream 설정 (새 파일명: new_example.txt)
        OutputStream outputStream = new FileOutputStream("./src/main/resources/text/output.txt") ;

        int data;

        // when & then
        while((data = inputStream.read()) != -1) {
            outputStream.write(data);
        }
        long end = System.nanoTime();
        System.out.printf("일반 스트림 실행 시간: %f seconds%n", (end - start) / 1e9);

        // finally
        inputStream.close();
        outputStream.close();
    }

    @Test
    @DisplayName("Buffered Stream의 성능 측정")
    @Order(4)
    void testBufferedStream() throws IOException {

        // 기본적으로 8192byte 크기의 버퍼를 가짐

        // given
        long start = System.nanoTime();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resource.getInputStream());
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("./src/main/resources/text/output.txt"));
        int data;

        // when & then
        while ((data = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(data);
        }
        long end = System.nanoTime();
        System.out.printf("버퍼 스트림 실행시간: %f seconds%n", (end - start) / 1e9);

        // finally
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }

    @Test
    @DisplayName("FileReader 사용 시 한글 정상화")
    @Order(2)
    void testFileReader() throws IOException {

        // given
        FileReader fileReader = new FileReader(resource.getFile());
        int data;

        // when & then
        while((data = fileReader.read()) != -1) {
            System.out.print((char) data);
        }
    }

    @Test
    @DisplayName("Character Stream 성능 측정")
    @Order(5)
    void testCharacterStream() throws IOException {

        // given
        long start = System.nanoTime();
        FileReader fileReader = new FileReader(resource.getFile());
        FileWriter fileWriter = new FileWriter("./src/main/resources/text/output.txt");
        int data;

        // when & then
        while((data = fileReader.read()) != -1) {
            fileWriter.write(data);
        }
        long end = System.nanoTime();
        System.out.printf("캐릭터 스트림 실행 시간: %f seconds%n", (end - start)/1e9);

        // finally
        fileReader.close();
        fileWriter.close();

    }

    @Test
    @DisplayName("Buffered Character Stream 성능 측정")
    @Order(6)
    void testBufferedCharacterStream() throws IOException {

        // given
        long start = System.nanoTime();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/main/resources/text/output.txt"));
        int data;

        // when & then
        while((data = bufferedReader.read()) != -1) {
            bufferedWriter.write(data);
        }
        long end = System.nanoTime();
        System.out.printf("버퍼 캐릭터 스트림 실행 시간: %f seconds%n", (end - start)/1e9);

        // finally
        bufferedReader.close();
        bufferedWriter.close();
    }
}
