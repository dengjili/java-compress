package compress;

import java.io.IOException;
import java.util.Random;

import priv.dengjl.compress.util.CompressUtil;

public class CompressTest {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}

		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		String data = generateString(1024 * 10);
		// System.out.println("压缩前数据内容：" + data);
		byte[] dataBytes = data.getBytes();
		System.out.println("压缩前数据大小：" + dataBytes.length);
		
		CompressUtil[] values = CompressUtil.values();
		for (CompressUtil compressUtil : values) {
			System.out.println("===================: " + compressUtil.name());
			long start = System.currentTimeMillis();
			byte[] resultBytes = compressUtil.compress(dataBytes);
			System.out.println("压缩后数据大小:" + resultBytes.length);

			byte[] uncompressBytes = compressUtil.uncompress(resultBytes);
			System.out.println("解压后数据大小：" + uncompressBytes.length);
			String result = new String(uncompressBytes);
			// System.out.println("解压后数据内容：" + result);
			System.out.println("压缩时间(ms)：" + (System.currentTimeMillis() - start));
			System.out.println("===================: " + compressUtil.name());
			System.out.println();
		}
	}

}
