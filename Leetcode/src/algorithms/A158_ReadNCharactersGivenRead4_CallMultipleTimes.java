package algorithms;

public class A158_ReadNCharactersGivenRead4_CallMultipleTimes {
	
	private char[] buffer = new char[4];
	
	int offset = 0, bufsize = 0;
	
	public int read(char[] buf, int n) {
		int read_bytes = 0;
		boolean end = false;
		while(!end && read_bytes < n) {
			int size = (bufsize > 0) ? bufsize : read4(buffer);
			if(bufsize == 0 && size < 4) end = true;
			int bytes = Math.min(n - read_bytes, size);
			System.arraycopy(buffer, offset, buf, read_bytes, bytes);
			offset = (offset+bytes) % 4;
			bufsize = size - bytes;
			read_bytes += bytes;
		}
		
		return read_bytes;
	}
	
	private int read4(char[] buf) {
		return 0;
	}
	
}
