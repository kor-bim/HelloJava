package kr.or.ddit.rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;

/**
 * RMI용 인터페이스는 Remote를 상속해야 한다.<br>
 * 이 인터페이스에서 선언된 모든 메서드는 RemoteException을 throw해야 한다.
 */
public interface RemoteInterface extends Remote {

	/**
	 * @param str
	 * @return 
	 * @throws RemoteException
	 */
	public int doRemotePrint(String str) throws RemoteException;

	/**
	 * @param list
	 * @throws RemoteException
	 */
	public void doPrintList(List<String> list) throws RemoteException;

	/**
	 * @param vo
	 * @throws RemoteException
	 */
	public void doPrintVO(TestVO vo) throws RemoteException;

	/**
	 * 파일전송을 위한 메서드
	 * 
	 * @param fInfo
	 * @throws RemoteException
	 */
	public void setFiles(FileInfoVO[] fInfo) throws RemoteException;
}
