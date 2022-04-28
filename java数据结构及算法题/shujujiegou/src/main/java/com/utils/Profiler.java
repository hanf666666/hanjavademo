package com.utils;

/**
 * 
 * @author CuttleFish
 *
 */
public class Profiler {
	private final static ThreadLocal<ContextData> dataHolderThreadLocal = new ThreadLocal<ContextData>();

	private static int ELAPSE_TIME_MS_TO_LOG = 100;

	private static TraceManager traceManager = new TraceManagerImpl();

	public static void start(String logName) {
		start(logName, ELAPSE_TIME_MS_TO_LOG);
	}


	public static void start(String logName, int elapseTimeMsToLog) {
		ContextData execData = dataHolderThreadLocal.get();
		ContextNode currentNode = new ContextNode(logName, System.currentTimeMillis(), elapseTimeMsToLog);
		if (execData == null) {
			execData = new ContextData();
			execData.root = currentNode;
			dataHolderThreadLocal.set(execData);
		} else {
			ContextNode parent = execData.currentNode;
			currentNode.setParent(parent);
			parent.getChildList().add(currentNode);
		}
		execData.currentNode = currentNode;
		execData.level++;
	}

	public static void stop() {
		ContextData execData = dataHolderThreadLocal.get();
		long nowTime = System.currentTimeMillis();
		execData.currentNode.setEndTime(nowTime);
		ContextNode child = execData.currentNode;
		execData.currentNode = child.getParent();
		execData.level--;
		if (execData.level == 0) {
			if ((nowTime - execData.root.getStartTime()) >= execData.root.getElapseTimeMsToLog() || execData.showflag) {
				traceManager.showTree(execData.root);
			}
			dataHolderThreadLocal.remove();
		} else {
//			dataHolderThreadLocal.remove();
			if (child.getExecTime() >= child.getElapseTimeMsToLog()) {
				execData.showflag = true;
			}
		}
	}

	public static void showTree(){
		ContextData execData = dataHolderThreadLocal.get();
		traceManager.showTree(execData.root);
	}

}