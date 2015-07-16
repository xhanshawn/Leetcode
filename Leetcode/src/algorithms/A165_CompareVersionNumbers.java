package algorithms;

public class A165_CompareVersionNumbers {
	public static void main (String[]  args) {
		A165_CompareVersionNumbers a165 = new A165_CompareVersionNumbers();
		System.out.println("" + a165.compareVersion("1.2.0", "1.2"));
	}
	
	public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        int result = 0;
        while(i < v1.length && j < v2.length && result == 0) {
            if(Integer.valueOf(v1[i]) > Integer.valueOf(v2[j])) result = 1;
            else if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[j])) result = -1;
            i++;
            j++;
        }

        if(result == 0) {
            if(i < v1.length && !v1[i].equals("0")) return 1;
            else if(j < v2.length && !v2[j].equals("0")) return -1;
            else return 0;
        }else return result;
    }
}
