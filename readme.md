# java常见压缩与解压算法

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/dengjili/java-compress/pulls)
[![GitHub Watch](https://img.shields.io/github/forks/dengjili/java-compress.svg?style=social&label=Watch)](https://github.com/dengjili/java-compress)
[![GitHub Star](https://img.shields.io/github/stars/dengjili/java-compress.svg?style=social&label=Star)](https://github.com/dengjili/java-compress)
[![GitHub Fork](https://img.shields.io/github/forks/dengjili/java-compress.svg?style=social&label=Fork)](https://github.com/dengjili/java-compress)

## 支持算法
* Bzip2

bzip2是Julian Seward开发并按照自由软件／开源软件协议发布的数据压缩算法及程序。Seward在1996年7月第一次公开发布了bzip2 0.15版，在随后几年中这个压缩工具稳定性得到改善并且日渐流行，Seward在2000年晚些时候发布了1.0版。bzip2比传统的gzip的压缩效率更高，但是它的压缩速度较慢。

* Deflater

DEFLATE是同时使用了LZ77算法与哈夫曼编码（Huffman Coding）的一个无损数据压缩算法，DEFLATE压缩与解压的源代码可以在自由、通用的压缩库zlib上找到，zlib官网：http://www.zlib.net/ 
jdk中对zlib压缩库提供了支持，压缩类Deflater和解压类Inflater，Deflater和Inflater都提供了native方法。

* Gzip

gzip的实现算法还是deflate，只是在deflate格式上增加了文件头和文件尾，同样jdk也对gzip提供了支持，分别是GZIPOutputStream和GZIPInputStream类，同样可以发现GZIPOutputStream是继承于DeflaterOutputStream的，GZIPInputStream继承于InflaterInputStream，并且可以在源码中发现writeHeader和writeTrailer方法。

* Lz4

LZ4是一种无损数据压缩算法，着重于压缩和解压缩速度。

* Lzo

LZO是致力于解压速度的一种数据压缩算法，LZO是Lempel-Ziv-Oberhumer的缩写，这个算法是无损算法。

* Snappy

Snappy（以前称Zippy）是Google基于LZ77的思路用C++语言编写的快速数据压缩与解压程序库，并在2011年开源。它的目标并非最大压缩率或与其他压缩程序库的兼容性，而是非常高的速度和合理的压缩率。

## 压缩使用
```java
	CompressUtil.GZIP.compress(bytes)
```

## 解压使用
```java
	CompressUtil.GZIP.uncompress(bytes)
```

## demo
```java
public class CompressDemo {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		try {
			String data = generateString(1024 * 10);
			System.out.println("压缩前数据内容：" + data);
			byte[] dataBytes = data.getBytes();
			System.out.println("压缩前数据大小：" + dataBytes.length);

			byte[] resultBytes = CompressUtil.GZIP.compress(dataBytes);
			System.out.println("压缩后数据大小:" + resultBytes.length);
			
			byte[] uncompressBytes = CompressUtil.GZIP.uncompress(resultBytes);
			System.out.println("解压后数据大小：" + uncompressBytes.length);
			String result = new String(uncompressBytes);
			System.out.println("解压后数据内容：" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

```

## 核心工具类封装
```java
public enum CompressUtil {
	DEFLATER {
		Compress compress = new DeflaterCompress();

		public byte[] compress(byte[] data) throws IOException {
			return compress.compress(data);
		}

		public byte[] uncompress(byte[] data) throws IOException {
			return compress.uncompress(data);
		}
	},
	BZIP2 {
		Compress compress = new LzoCompress();

		public byte[] compress(byte[] data) throws IOException {
			return compress.compress(data);
		}

		public byte[] uncompress(byte[] data) throws IOException {
			return compress.uncompress(data);
		}
	},
	GZIP {
		Compress compress = new GzipCompress();

		public byte[] compress(byte[] data) throws IOException {
			return compress.compress(data);
		}

		public byte[] uncompress(byte[] data) throws IOException {
			return compress.uncompress(data);
		}
	},
	LZ4 {
		Compress compress = new Lz4Compress();

		public byte[] compress(byte[] data) throws IOException {
			return compress.compress(data);
		}

		public byte[] uncompress(byte[] data) throws IOException {
			return compress.uncompress(data);
		}
	},
	LZO {
		Compress compress = new LzoCompress();

		public byte[] compress(byte[] data) throws IOException {
			return compress.compress(data);
		}

		public byte[] uncompress(byte[] data) throws IOException {
			return compress.uncompress(data);
		}
	},
	SNAPPY {
		Compress compress = new SnappyCompress();

		public byte[] compress(byte[] data) throws IOException {
			return compress.compress(data);
		}

		public byte[] uncompress(byte[] data) throws IOException {
			return compress.uncompress(data);
		}
	};

	public byte[] compress(byte[] data) throws IOException {
		throw new AbstractMethodError();
	}

	public byte[] uncompress(byte[] data) throws IOException {
		throw new AbstractMethodError();
	}
}

```
