package priv.dengjl.compress.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import net.jpountz.lz4.LZ4BlockInputStream;
import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;
import priv.dengjl.compress.AbstractCompress;

/**
 * LZ4是一种无损数据压缩算法，着重于压缩和解压缩速度
 * 
 * 依赖于lz4包
 * 
 * @author it
 */
public class Lz4Compress extends AbstractCompress {

	@Override
	protected OutputStream createOutputStream(OutputStream output) throws IOException {
		LZ4Compressor compressor = LZ4Factory.fastestInstance().fastCompressor();
		return new LZ4BlockOutputStream(output, 4096, compressor);
	}

	@Override
	protected InputStream createInputStream(InputStream input) throws IOException {
		LZ4FastDecompressor decompresser = LZ4Factory.fastestInstance().fastDecompressor();
		return new LZ4BlockInputStream(input, decompresser);
	}

}
