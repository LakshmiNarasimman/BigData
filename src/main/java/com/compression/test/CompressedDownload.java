package com.compression.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressedDownload {
	public static void main(String arg[]) throws IOException
	{
		byte[] buffer = new byte[1024];     
	    try
	    {   
	    	System.out.println("Zipping is started..");
	    	String FILE_NAME = "/home/bigdata/bigdata_noahdata/Hive-Benchmarking/1502105646858.csv";
	    	File file = new File(FILE_NAME);
	    	String zipFileName = file.getName().concat(".zip");
	    	File zipFile = new File("/home/bigdata/bigdata_noahdata/Hive-Benchmarking/"+zipFileName);
	    	FileOutputStream fos = new FileOutputStream(zipFile);
	        ZipOutputStream zos = new ZipOutputStream(fos);
	        ZipEntry ze= new ZipEntry(file.getName());
	        zos.putNextEntry(ze);
	        FileInputStream in = new FileInputStream(FILE_NAME);
	        int len;
	        byte[] tmp = new byte[4*1024];
            int size = 0;
            while((size = in.read(tmp))>0){
                zos.write(tmp, 0, size);
            }
	        System.out.println("Zipped the file...!");
	        in.close();
	        zos.closeEntry();
	        zos.close();
	    }
	    catch(IOException ex)
	    {
	       ex.printStackTrace();
	    }
	}

}
