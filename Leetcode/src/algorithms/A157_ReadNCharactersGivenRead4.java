package algorithms;

public class A157_ReadNCharactersGivenRead4 {
	
	
	// a very confusing problem
	public int read(char[] buf, int n) {
		
		// a temp buffer for each time of read4
		char[] temp_buf = new char[4];
		// bytes num already read
		int read_bytes = 0;
		// if meets the end
		boolean end = false;
		
		//iteration
		while (!end && read_bytes < n) {
			
			//how many bytes read each read4()
			int read = read4(temp_buf);
			//not read 4, meet the end
			if(read < 4) end = true;
			//next time read number of remain number or 4;
			int rem_bytes = Math.min(n - read_bytes, read);
			//copy action
			System.arraycopy(temp_buf, 0, buf, read_bytes, rem_bytes);
			// how many bytes read
			read_bytes += rem_bytes;
		}
		
		return read_bytes;
	}
	
	private int read4(char[] buf) {
		
		return 0;
	}
}
