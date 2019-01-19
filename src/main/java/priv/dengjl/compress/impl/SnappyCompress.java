package priv.dengjl.compress.impl;

import java.io.IOException;

import org.xerial.snappy.Snappy;

import priv.dengjl.compress.Compress;

/**
 * Snappy（以前称Zippy）是Google基于LZ77的思路用C++语言编写的快速数据压缩与解压程序库，
 * 并在2011年开源。它的目标并非最大压缩率或与其他压缩程序库的兼容性，而是非常高的速度和合理的压缩率
 * 
 * 依赖于snappy-java包
 * 
 * @author it
 */
public class SnappyCompress implements Compress {

	@Override
	public byte[] compress(byte[] data) throws IOException {
		return Snappy.compress(data);
	}

	@Override
	public byte[] uncompress(byte[] data) throws IOException {
		return Snappy.uncompress(data);
	}

}
