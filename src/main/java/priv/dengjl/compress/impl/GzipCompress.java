package priv.dengjl.compress.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import priv.dengjl.compress.AbstractCompress;

/**
 * gzip算法
 * 
 * <p>继承关系,基于DeflaterOutputStream的包装</p>
 * <pre>
 * java.lang.Object
 *   java.io.OutputStream
 *     java.io.FilterOutputStream
 *       java.util.zip.DeflaterOutputStream
 *         java.util.zip.GZIPOutputStream
 * </pre>
 * 
 * @author it
 */
public class GzipCompress extends AbstractCompress {

	@Override
	protected OutputStream createOutputStream(OutputStream output) throws IOException {
		return new GZIPOutputStream(output);
	}

	@Override
	protected InputStream createInputStream(InputStream input) throws IOException {
		return new GZIPInputStream(input);
	}
}
