package priv.dengjl.compress.util;

import java.io.IOException;

import priv.dengjl.compress.Compress;
import priv.dengjl.compress.impl.DeflaterCompress;
import priv.dengjl.compress.impl.GzipCompress;
import priv.dengjl.compress.impl.Lz4Compress;
import priv.dengjl.compress.impl.LzoCompress;
import priv.dengjl.compress.impl.SnappyCompress;

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
