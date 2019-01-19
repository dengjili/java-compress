package priv.dengjl.compress.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import priv.dengjl.compress.Compress;

/**
 * deflater压缩,基于java jdk
 * 
 * <p>继承关系,基于FilterOutputStream的包装流</p>
 * <pre>
 * java.lang.Object
 *   java.io.OutputStream
 *     java.io.FilterOutputStream
 *       java.util.zip.DeflaterOutputStream
 * </pre>
 * 
 * @author it
 */
public class DeflaterCompress implements Compress {

	@Override
	public byte[] compress(byte[] data) throws IOException {
		// 构建压缩器
		Deflater compressor = new Deflater();
		compressor.setInput(data);
		compressor.finish();
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		try {
			while (!compressor.finished()) {
				int compressLen = compressor.deflate(buffer);
				bos.write(buffer, 0, compressLen);
			}
		} finally {
			// 释放资源
			compressor.end();
		}
		
		return bos.toByteArray();
	}

	@Override
	public byte[] uncompress(byte[] data) throws IOException {
		// 构建解压器
		Inflater decompressor = new Inflater();
		decompressor.setInput(data);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		try {
			while (!decompressor.finished()) {
				int decompressLen = decompressor.inflate(buffer);
				bos.write(buffer, 0, decompressLen);
			}
		} catch (DataFormatException e) {
			throw new RuntimeException(e);
		} finally {
			// 释放资源
			decompressor.end();
		}
		
		return bos.toByteArray();
	}
}
