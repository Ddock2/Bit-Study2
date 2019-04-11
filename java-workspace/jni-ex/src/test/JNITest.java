package test;

public class JNITest {
	
	static {
		System.loadLibrary("JNI");
	}
	
	private native int getNumber();
	public native void printHelloWorld();
	public native String hi(String str);
	public native String baLog(String str);
	
	public static void main(String[] args) {
		JNITest jni = new JNITest();
		
//		jni.printHelloWorld();
//		System.out.println(jni.getNumber());
//		System.out.println(jni.hi("???"));
//		System.out.println("no - job id - job status - error code - job type - backup method - client - job - schedule - files - files size - data transferred- throughput - start time - end time - server - volume pool - storage - tape drive - volume");
		System.out.println(jni.baLog("finished_job4.log"));
	}
}
