package src;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Link {

	private Node[] nodes;
	private int myId = 0;
	private int rightId = 0;
	private int leftId = 0;
	private Node me;
	private Lock lock = null;


	public Link(Node me, Node[] nodes) {
		this.lock = new ReentrantLock();
		this.me = me;
		this.nodes = nodes;
		configure();
	}

	private void configure() {
		for (int i = 0; i < nodes.length; i++) {
			if (me.compareTo(nodes[i]) == 0 ) {
				myId = i;
				leftId = backward(i, nodes.length);
				rightId = (i + 1) % nodes.length;
			}
		}
	}

	private int backward(int i, int length) {
		if (i - 1 < 0) {
			return length - 1 ;
		} else {
			return i - 1;
		}
	}

	public int getNodeId() {
		return myId;
	}

	public int getLeftId() {
		return leftId;
	}
	public int getRightId() {
		return rightId;
	}


}
