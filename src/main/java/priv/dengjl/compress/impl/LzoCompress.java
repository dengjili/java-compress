package priv.dengjl.compress.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.anarres.lzo.LzoAlgorithm;
import org.anarres.lzo.LzoCompressor;
import org.anarres.lzo.LzoDecompressor;
import org.anarres.lzo.LzoInputStream;
import org.anarres.lzo.LzoLibrary;
import org.anarres.lzo.LzoOutputStream;

import priv.dengjl.compress.AbstractCompress;

/**
 * LZO是致力于解压速度的一种数据压缩算法，LZO是Lempel-Ziv-Oberhumer的缩写。这个算法是无损算法
 * 
 * 依赖于lzo-core包
 * 
 * @author it
 */
public class LzoCompress extends AbstractCompress {

	@Override
	protected OutputStream createOutputStream(OutputStream output) throws IOException {
		LzoCompressor compressor = LzoLibrary.getInstance().newCompressor(LzoAlgorithm.LZO1X, null);
		return new LzoOutputStream(output, compressor);
	}

	@Override
	protected InputStream createInputStream(InputStream input) throws IOException {
		LzoDecompressor decompressor = LzoLibrary.getInstance().newDecompressor(LzoAlgorithm.LZO1X, null);
		return new LzoInputStream(input, decompressor);
	}
}
