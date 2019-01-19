package priv.dengjl.compress;

import java.io.IOException;

/**
 * 数据压缩和解压，提供顶层抽象
 * <ul>
 * <li>deflate</li>
 * <li>gzip</li>
 * <li>bzip2</li>
 * <li>lzo</li>
 * <li>lz4</li>
 * <li>snappy</li>
 * </ul>
 */
public interface Compress {

	/**
	 * 数据压缩
	 */
	byte[] compress(byte[] data) throws IOException;

	/**
	 * 数据解压
	 */
	byte[] uncompress(byte[] data) throws IOException;

}

