package com.github.zjjfly.ca.nio;

import one.nio.mem.MappedFile;
import one.nio.serial.DataStream;

import java.io.IOException;
import java.nio.ByteOrder;

import static one.nio.mem.MappedFile.MAP_RW;

/**
 * @author zjjfly[https://github.com/zjjfly] on 2020/10/15
 */
public class MMapDemo {
    public static void main(String[] args) throws IOException {
        MappedFile mapped = new MappedFile("/tmp/mmap-demo.data", 1024L * 1024, MAP_RW);
        DataStream writeStream = mapped.dataStream(ByteOrder.BIG_ENDIAN);
        writeStream.writeUTF("hello");
        DataStream readStream = mapped.dataStream(ByteOrder.BIG_ENDIAN);
        String s = readStream.readUTF();
        System.out.println("char:" + s);
    }
}
