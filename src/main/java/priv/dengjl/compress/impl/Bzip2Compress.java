package priv.dengjl.compress.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

import priv.dengjl.compress.AbstractCompress;

/**
 * bzip2压缩依赖于apache commons-compress包
 * 
 */
public class Bzip2Compress extends AbstractCompress {

	@Override
	protected OutputStream createOutputStream(OutputStream output) throws IOException {
		return new BZip2CompressorOutputStream(output);
	}

	@Override
	protected InputStream createInputStream(InputStream input) throws IOException {
		return new BZip2CompressorInputStream(input);
	}
}
