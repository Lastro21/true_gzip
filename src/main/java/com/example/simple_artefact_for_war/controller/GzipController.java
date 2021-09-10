package com.example.simple_artefact_for_war.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@RestController
public class GzipController {

    @RequestMapping(value = "/gzip")
    public void adsd() throws IOException {

//        String sourceString = new String(Files.readAllBytes(Paths.get("/Users/my_user/Desktop/Lorem.txt")));
        String sourceString = "1111111111\n" + "1111111111\n" + "1111111111\n";
        System.out.println("Длинна исходной строки : " + sourceString.length() + " " + sourceString);

        byte[] afterCompress = compress(sourceString);
        System.out.println("Длинна после компрессии : " + afterCompress.length + " " + new String(afterCompress));

        String afterDecompress = decompress(afterCompress);
        System.out.println("Длинна после декомпрессии : " + afterDecompress.length() + " " + afterDecompress);

    }


    public byte[] compress(String data) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length());
        GZIPOutputStream gzip = new GZIPOutputStream(bos);
        gzip.write(data.getBytes());
        gzip.close();
        byte[] compressed = bos.toByteArray();
        bos.close();
        return compressed;
    }

    public String decompress(byte[] compressed) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(compressed);
        GZIPInputStream gis = new GZIPInputStream(bis);
        byte[] bytes = IOUtils.toByteArray(gis);
        return new String(bytes, "UTF-8");
    }

}
