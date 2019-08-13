package com.tao.util;

import java.io.BufferedInputStream;
import java.sql.Blob;

public class DbDataTypeChangeUtil {

	public static byte[] blonToByteArray(Blob blob) {
		if (blob == null) {
			return null;
		}
		BufferedInputStream is = null;
		byte[] bytes = null;
		try {
			is = new BufferedInputStream(blob.getBinaryStream());
			bytes = new byte[(int) blob.length()];
			int len = bytes.length;
			int offset = 0;
			int read = 0;
			while (offset < len && (read = is.read(bytes, offset, len - offset)) >= 0) {
				offset += read;
			}
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
