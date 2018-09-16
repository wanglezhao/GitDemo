package buchong;
/*
 * 写一个线程的死锁
 * 当DeadLock类的对象flag==1时（td1），先锁定o1，休眠500毫秒
 * 在td1休眠时，另一个对象flag==0（td2）线程启动，先锁定o2休眠
 * 500毫秒，td1休眠时间结束后需要锁定o2才能继续执行，而此时o2
 * 已经别td2锁定；td2休眠时间结束后需要锁定o1才能继续执行，而此时
 * o1已被td1锁定；td1和td2互相等待，都需要得到对方的资源才能继续执行；
 * ，但双方资源都在锁定状态，从而造成死锁。
 * 
 * 产生死锁必须同时满足4个条件
 * 互斥条件：在一段时间内某个资源仅为一个进程所占有，此时若有其它
 *          线程请求该资，则请求必须等待。
 * 不剥夺条件：进程所获得的资源在未使用完毕之前，不能被其它进程强行
 *            中止，即只能由该获得资源的进程自己来主动释放
 *            
 * 循环等待条件：存在一种进程资源的循化等待链，链中每个进程已获得的
 *              资源同时被链中的下一个进程所请求
 *              
 * 请求和保持条件：进程已经保持了至少一个资源，但又提出了新的资源请求
 *                而该资源已经被其它进程占有，此时请求进程被阻塞。但
 *                对自己已获得的资源保持不放。
 *        
 * 进程和线程的区别：
 * 进程是指在系统中正在运行的一个应用程序，程序一旦运行就是一个进程
 * 进程是指程序执行时的一个实例.
 * 线程是进程的一个实体
 * 进程：资源分配的最小单位。可以拥有多个线程，而且至少拥有一个线程
 * 线程：程序执行的最小单位。必定只能属于一个进程
 * 
 * 同步的表现方式
 * synchronized
 * 1.同步代码块，被synchronized关键字封装的代码就是同步代码块
 * 2.同步函数（方法）被synchronized修饰的函数（方法）就是同步函数（方法）
 */
import java.nio.charset.MalformedInputException;

public class DeadLock implements Runnable{
	int flag=1;
	private static Object o1=new Object(),o2=new Object();
	/*
	 * 线程的生命周期5个  待运行  启动（start）  运行（run）  
	 * 阻塞（sleep，yiled，wait）  销毁（死亡）
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("flag"+flag);
		if(flag==1) {
			synchronized(o1) {
				
			}
		}
	
		
	}
	public static void main(String[] args) {
		DeadLock td1=new DeadLock();
		DeadLock td2=new DeadLock();
		td1.flag=1;
		td2.flag=0;
		//td1和td2都处于可执行状态但jvm调用执行哪个线程是不确定的
		//td2的run方法可能会在td1的run方法之前执行
		new Thread(td1).start();
		new Thread(td2).start();
	}
}
