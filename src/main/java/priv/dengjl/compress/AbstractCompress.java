package priv.dengjl.compress;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 重构gzip、bzip2、lz4、lzo重复代码
 * 
 * @author it
 */
public abstract class AbstractCompress implements Compress {
	
	// 构建模板方法
	protected abstract OutputStream createOutputStream(OutputStream output) throws IOException;
	protected abstract InputStream createInputStream(InputStream input) throws IOException;
	
	@Override
	public byte[] compress(byte[] data) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try (OutputStream cs = createOutputStream(os)) {
			cs.write(data);
		}
		return os.toByteArray();
	}

	@Override
	public byte[] uncompress(byte[] data) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int len = 0;
		
		try (InputStream us = createInputStream(new ByteArrayInputStream(data))) {
			while ((len = us.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
		}
		return baos.toByteArray();
	}
}
